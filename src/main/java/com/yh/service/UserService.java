package com.yh.service;

import com.yh.entity.User;

import java.util.Map;

/**
 * 请后来修改者按照这个格式添加备注
 *  * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
public interface UserService {

    String login(Map<String ,Object> map);
    String regedit(Map<String ,Object> map);

    boolean findEmailOrPhone(Map<String, Object> map);

    String getTokenFromRedisUserId(String userId);
    String getUserIdFromRedisToken(String token);
    User findUserInformation(Map<String, Object> map);
    Boolean phoneCheck(String phone);
    Boolean emailCheck(String email);
    Boolean passwordCheck(String password);


//    /*author:zxs*/
//    public List<User> findHotSuperUserById();
}
