package com.yh.service.impl;

import com.yh.entity.User;
import com.yh.mapper.UserMapper;
import com.yh.service.UserService;
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
     * 功能描述
     * 登录时判断使用的是手机号还是邮箱
     * @author chaoyang
     * @date 2019/9/30
     * @param  * @param map
     * @return com.yh.entity.User
     */
    @Override
    public String login (Map<String, Object> map) {
        //自动登录功能
        String token = (String) map.get("token");
        if (token!=null){
            //redis 获得token对用的用户 获得用户id
            String tokenUserId = (String) stringRedisTemplate.opsForHash().get("tokenUser", token);
            if (tokenUserId!=null){
                return token;
            }
            //查不到则用户需要重新登录
            throw new RuntimeException("login/tokenNull");
        }
        String tempLogin = (String) map.get("loginNum");
        Integer firstLocation = tempLogin.indexOf("@");
        Integer lastLocation = tempLogin.lastIndexOf("@");
        User user = new User();
        //设置密码
        user.setPassword((String)map.get("password"));
        if (firstLocation!=null){
            if (firstLocation.equals(lastLocation)){
                //用户使用邮箱登录
                user.setEmail((String)map.get("loginNum"));
                user = userMapper.findUserbyEmailPwd(user);
            }
        }else {
            //用户使用手机号登录
            user.setPhone((String)map.get("loginNum"));
            user = userMapper.findUserbyPhonePwd(user);
        }
        //生成token
        token = UUID.randomUUID().toString().replace("-","").toUpperCase();
        //删除之前的redis中存储的值
        //将用户放到redis中
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
            /**
             * 功能描述
             * @author chaoyang
             * @date 2019/9/30
             * 向管理者发送邮件，未实现
             */
            throw new RuntimeException("login/Error");
        }
        //设置两天过期时间
        stringRedisTemplate.expire(user.getUserId(),2,TimeUnit.DAYS);
        stringRedisTemplate.expire(token,2,TimeUnit.DAYS);
        return token;
    }
}
