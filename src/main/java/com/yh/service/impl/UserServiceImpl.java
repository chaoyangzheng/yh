package com.yh.service.impl;

import com.yh.entity.User;
import com.yh.mapper.UserMapper;
import com.yh.service.UserService;
import com.yh.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
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
        boolean loginCountExit = findEmailOrPhone(map);
        if (!loginCountExit){
            throw new RuntimeException("login/未注册");
        }
        String tempLogin = (String) map.get("loginCount");
        Integer firstLocation = tempLogin.indexOf("@");
        Integer lastLocation = tempLogin.lastIndexOf("@");
        User user = new User();
        //设置密码
        String password = (String) map.get("password");
        if (!passwordCheck(password)){
            throw new RuntimeException("login/密码至少6位");
        }
        if (firstLocation>0){
            if (firstLocation.equals(lastLocation)){
                //用户使用邮箱登录
                String email = (String) map.get("loginCount");
                if(!emailCheck(email)){
                    throw new RuntimeException("login/请使用支持的邮箱：QQ、网易、谷歌、阿里云");
                }
                user = userMapper.findUserByEmail(email);
            }
        }else {
            //用户使用手机号登录
            String phone=((String)map.get("loginCount"));
            Boolean phoneCheck = phoneCheck(phone);
            if (phoneCheck){
                throw new RuntimeException("login/请不要调皮，请输入正确的手机号");
            }
            System.out.println(phone+phoneCheck);
            user = userMapper.findUserByPhone(phone);
        }
        if (user ==null){
            throw new RuntimeException("login/邮箱或手机号错误");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("login/密码错误");
        }
        token = addTokenIntoRedis(user.getUserId());
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
        if (!passwordCheck((String) map.get("password"))){
            throw new RuntimeException("regedit/密码至少6位");
        }
        user.setPassword((String) map.get("password"));
        //用户通过邮箱或者手机号注册
        String  loginCount = (String) map.get("loginCount");
        if (findEmailOrPhone(map)) {
            throw new RuntimeException("regedit/账号已存在");
        }
        Integer emailLocation = loginCount.indexOf("@");
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        if (emailLocation<0){
            //通过手机号注册 验证手机号
           /* if (phoneCheck(loginCount)){
                throw new RuntimeException("regedit/请不要调皮，请输入正确的手机号");
            }*/
            user.setPhone(loginCount);
            userMapper.addUserByPhone(user);
            user = userMapper.findUserByPhone(loginCount);
        }else {
           /* if(!emailCheck(loginCount)){
                throw new RuntimeException("regedit/请使用支持的邮箱：QQ、网易、谷歌、阿里云");
            }*/
            user.setEmail(loginCount);
            userMapper.addUserByEmail(user);
            user = userMapper.findUserByEmail(loginCount);
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
        if (emailLocation<0){
            //验证手机号
            if (phoneCheck(loginCount)){
                throw new RuntimeException("regedit/请不要调皮，请输入正确的手机号");
            }
            user = userMapper.findUserByPhone(loginCount);
        }else {
            if(!emailCheck(loginCount)){
                throw new RuntimeException("regedit/请使用支持的邮箱：QQ、网易、谷歌、阿里云");
            }
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
     * 查询用户的个人信息
     * @author chaoyang
     * @date 2019/10/4
     */
    @Override
    public User findUserInformation (Map<String, Object> map) {
        String token = (String) map.get("token");
        String userId = getUserIdFromRedisToken(token);
        if (userId==null){
            throw new RuntimeException("login/未登录");
        }
        User user = userMapper.findUserByUserId(userId);
        if (user==null){
            throw new RuntimeException("error/数据异常，请联系管理员");
        }
        return user;
    }

    @Override
    public Boolean phoneCheck (String phone) {
        //手机号长度验证
        if (phone.length()!=11){
            System.out.println("长度错误");
            return false;
        }
        //手机号纯数字验证
        for ( int  i=phone.length();--i>=0;){
            int  chr=phone.charAt(i);
            if(chr<48 || chr>57)
                System.out.println("数字错误");
               return false;
        }
        return true;
    }

    @Override
    public Boolean emailCheck (String email) {
        Integer location = email.lastIndexOf("@");
        String suffix = email.substring(location + 1);
        if ("qq.com".equals(suffix)||"163.com".equals(suffix)||"126.com".equals(suffix)||"gmail.com".equals(suffix)||"aliyun.com".equals(suffix)){
            return true;
        }
        return false;
    }

    @Override
    public Boolean passwordCheck (String password) {
        if (password==null||password.equals("")||password.length()<6){
            return false;
        }
        return true;
    }

//    @Override
//    public List<User> findHotSuperUserById() {
//        Map<String,Integer> map = userMapper.findHotSuperUserId();
//        List<User> hotSuperUserList = userMapper.findHotSuperUserById(map);
//        return hotSuperUserList;
//    }


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

    /*author:zxs
     * Date:19/10/4
     * update:19/10/4
     */
    /*查询社区发现页热门达人*/
    @Override
    public List<User> findHotSuperUserById() {
        List<User> userList = userMapper.findHotSuperUserId();
        List<User> users = userMapper.findHotSuperUserById(userList);
        for (int i = 0;i<7;i++){
            users.get(i).setFansNumber(userList.get(i).getFansNumber());
        }
        return users;
    }

    /*查询社区发现页热门达人的作品数*/
    @Override
    public List<Integer> findHotSuperUserShowNumById() {
        List<User> userList = userMapper.findHotSuperUserId();
//        for (User u:userList
//             ) {
//            System.out.println(u);
//        }
        List<Integer> userShowNumList = userMapper.findHotSuperUserShowNumById(userList);
        return userShowNumList;
    }

    /*查询社区内所有的用户*/
    @Override
    public List<User> findAllUser() {
        List<User> BbsAllUserList = userMapper.findAllUser();
        return BbsAllUserList;
    }

    /*查询所有是金牌讲师的用户*/
    @Override
    public List<User> getGoldenUserForTch() {
        List<User> goldenUserForTch = userMapper.getGoldenUserForTch();
        return goldenUserForTch;
    }

    /*end:zxs*/
}
