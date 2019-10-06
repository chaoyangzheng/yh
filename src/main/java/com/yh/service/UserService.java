package com.yh.service;

import com.yh.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 请后来修改者按照这个格式添加备注
 *  * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
public interface UserService {

    //返回值是String的一般都是返回token
    String login(Map<String ,Object> map);
    String regedit(Map<String ,Object> map);

    boolean findEmailOrPhone(Map<String, Object> map);

    String getTokenFromRedisUserId(String userId);
    String getUserIdFromRedisToken(String token);
    User findUserInformation(Map<String, Object> map);
    Boolean phoneCheck(String phone);
    Boolean emailCheck(String email);
    Boolean passwordCheck(String password);
    //字符为数字或者英文校验
    Boolean checkChar(String chr);
    //更新用户的个人信息
    User updateUserInformation(Map<String, Object> map);
    //绑定手机号或者邮箱
    User updatePhoneOrEmail(Map<String, Object> map);
    //设置用户的id
    User updateUserOfId(Map<String, Object> map);
    //查询用户的id是否已存在
    boolean checkUserOfId(String id);
    //id校验
    boolean idCheck(String id);


    /*author:zxs*/
     List<User> findAllUser();

     List<User> getGoldenUserForTch();

     List<User> findHotSuperUserById();

     List<Integer> findHotSuperUserShowNumById();
    /*end:zxs*/
}
