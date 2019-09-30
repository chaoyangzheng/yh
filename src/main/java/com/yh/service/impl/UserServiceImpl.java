package com.yh.service.impl;

import com.yh.entity.User;
import com.yh.mapper.UserMapper;
import com.yh.service.UserService;
import com.yh.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 请后来修改者按照这个格式添加备注
 *  * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 登录时判断使用的是手机号还是邮箱
     * @author chaoyang
     * @date 2019/9/30
     * @param  map
     * @return String
     */
    @Override
    public String login (Map<String, Object> map) {
        //自动登录功能
        String token = (String) map.get("token");
        if (token!=null){
            //redis 获得token对用的用户 获得用户id
           // String tokenUserId = (String) stringRedisTemplate.opsForValue().get(token);
            String tokenUserId = getUserIdFromRedisToken(token);
            if (tokenUserId!=null){
                return token;
            }
            //查不到则用户需要重新登录
            throw new RuntimeException("login/tokenNull");
        }
        String tempLogin = (String) map.get("loginCount");
        Integer firstLocation = tempLogin.indexOf("@");
        Integer lastLocation = tempLogin.lastIndexOf("@");
        User user = new User();
        //设置密码
        String password = (String) map.get("password");
        if (firstLocation!=null){
            if (firstLocation.equals(lastLocation)){
                //用户使用邮箱登录
                String email = (String) map.get("loginCount");
                user = userMapper.findUserByEmail(email);
            }
        }else {
            //用户使用手机号登录
            String phone=((String)map.get("loginCount"));
            user = userMapper.findUserByPhone(phone);
        }
        if (user ==null){
            throw new RuntimeException("login/邮箱或手机号错误");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("login/密码错误");
        }
        token = addTokenIntoRedis(user.getUserId());
        /*//生成token
        token = TokenUtil.TokenProcessor(user.getUserId());
        //删除之前的redis中存储的值，将用户放到redis中
        //通过用户设置token，若返回null，则不需要删除token，若返回结果，删除token中对应的值
        String tokenOld = stringRedisTemplate.opsForValue().getAndSet(user.getUserId(), token);
        if (tokenOld!=null){
            //设置0毫秒过期，相当于删除
            stringRedisTemplate.expire(tokenOld,0,TimeUnit.MILLISECONDS);
        }
        String userIdOld = stringRedisTemplate.opsForValue().getAndSet(token, user.getUserId());
        if (userIdOld!=null){
            System.out.println(userIdOld);
            //token 是唯一的，如果返回值不为空，就说明另一个用户的token被取代了，程序运行会有问题
            //处理方式 将两位用户的token和userId全部从redis中删除，之后发送报警邮件
            stringRedisTemplate.expire(userIdOld,0,TimeUnit.MILLISECONDS);
            stringRedisTemplate.expire(user.getUserId(),0,TimeUnit.MILLISECONDS);
            stringRedisTemplate.expire(token,0,TimeUnit.MILLISECONDS);
            *//**
             * @author chaoyang
             * @date 2019/9/30
             * 向管理者发送邮件，未实现
             *//*
            throw new RuntimeException("login/Error");
        }
        //设置两天过期时间
        stringRedisTemplate.expire(user.getUserId(),2,TimeUnit.DAYS);
        stringRedisTemplate.expire(token,2,TimeUnit.DAYS);*/
        return token;
    }
    /**
     * 注册
     * @author chaoyang
     * @date 2019/9/30
     */
    @Override
    public String regedit(Map<String, Object> map){
        User user = new User();
        user.setPassword((String) map.get("password"));
        //用户通过邮箱或者手机号注册
        String  loginCount = (String) map.get("loginCount");
        Integer emailLocation = loginCount.indexOf("@");
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        if (emailLocation==null){
            //通过手机号注册
            user.setPhone(loginCount);
            userMapper.addUserByPhone(user);
        }else {
            user.setEmail(loginCount);
            userMapper.addUserByEmail(user);
        }
        //添加过用户之后 生成token，将token保存到redis中
        String token = addTokenIntoRedis(user.getUserId());
        return token;
    }

    /**
     * 查询邮箱/手机号是否存在
     * @author chaoyang
     * @date 2019/9/30
     */
    @Override
    public boolean findEmailOrPhone(Map<String, Object> map){
        String  loginCount = (String) map.get("loginCount");
        Integer emailLocation = loginCount.indexOf("@");
        User user = new User();
        if (emailLocation==null){
            //验证手机号
            user = userMapper.findUserByPhone(loginCount);
        }else {
            user = userMapper.findUserByEmail(loginCount);
        }
        if (user!=null){
            return true;
        }
        return false;

    }


    /**
     * 功能抽取
     * @author chaoyang
     * @date 2019/9/30
     * 通过用户userId查询redis中存储的token
     * 通过用户token查询redis中存储的userId
     */
    @Override
    public String getTokenFromRedisUserId(String userId){
        String token = stringRedisTemplate.opsForValue().get(userId);
        return token;
    }
    @Override
    public String getUserIdFromRedisToken(String token){
        String userId = stringRedisTemplate.opsForValue().get(token);
        return userId;
    }
    /**
     * 登录成功 向redis中添加数据
     * @author chaoyang
     * @date 2019/9/30
     * @param  * @param userId
     * @return java.lang.String
     */
    public String addTokenIntoRedis(String userId){
        //生成token
        String token = TokenUtil.TokenProcessor(userId);
        //删除之前的redis中存储的值，将用户放到redis中
        //通过用户设置token，若返回null，则不需要删除token，若返回结果，删除token中对应的值
        String tokenOld = stringRedisTemplate.opsForValue().getAndSet(userId, token);
        if (tokenOld!=null){
            //设置0毫秒过期，相当于删除
            stringRedisTemplate.expire(tokenOld,0,TimeUnit.MILLISECONDS);
        }
        String userIdOld = stringRedisTemplate.opsForValue().getAndSet(token,userId);
        if (userIdOld!=null){
            System.out.println(userIdOld);
            //token 是唯一的，如果返回值不为空，就说明另一个用户的token被取代了，程序运行会有问题
            //处理方式 将两位用户的token和userId全部从redis中删除，之后发送报警邮件
            stringRedisTemplate.expire(userIdOld,0,TimeUnit.MILLISECONDS);
            stringRedisTemplate.expire(userId,0,TimeUnit.MILLISECONDS);
            stringRedisTemplate.expire(token,0,TimeUnit.MILLISECONDS);
            /**
             * @author chaoyang
             * @date 2019/9/30
             * 向管理者发送邮件，未实现
             */
            throw new RuntimeException("login/Error");
        }
        //设置两天过期时间
        stringRedisTemplate.expire(userId,2,TimeUnit.DAYS);
        stringRedisTemplate.expire(token,2,TimeUnit.DAYS);
        return token;
    }
}
