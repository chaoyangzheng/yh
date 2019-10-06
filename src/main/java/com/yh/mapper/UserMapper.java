package com.yh.mapper;

import com.yh.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */

public interface UserMapper {
    /*author:张栩生*/
    /*description:点击社区默认跳转关注页面，查询所有是老师的用户*/
    public List<User> findAllUser();

    /*description:查询金牌讲师*/
    public List<User> getGoldenUserForTch();

    /* description:查询热门达人的Id和粉丝数集合，7个人*/
    @Select("select follow_id as userId,count(1) as fansNumber from t_follow_fan group by follow_id order by count(1) desc LIMIT 0,7;")
    public List<User> findHotSuperUserId();

    /*description:查询热门达人的集合，包含所有属性，7个人*/
    public List<User> findHotSuperUserById(List<User> userList);

    /*description:查询热门达人的所有作品数集合*/
    public List<Integer> findHotSuperUserShowNumById(List<User> userList);

    /*end:zxs*/


    /**
     * 功能描述 要求 手机号和邮箱必须唯一
     * 通过手机号和密码查询用户
     * 通过邮箱和密码查询用户
     * 通过userId 或者id查询用户
     * @author chaoyang
     * @date 2019/9/30
     * @param  * @param user
     * @return com.yh.entity.User
     */
    @Select("select * from t_user where phone = #{phone}")
    User findUserByPhone (String phone);
    @Select("select * from t_user where email = #{email}")
    User findUserByEmail (String email);
    @Select("select * from t_user where user_id = #{userId}")
    User findUserByUserId (String userId);
    List<User> findAllUserByUserId(List<String> list);
    @Select("select * from t_user where id = #{id}")
    List<User> findUserById (String id);
    void addUserByPhone(User user);
    void addUserByEmail(User user);
    /**
     * 修改个人信息，，动态sql
     * @author chaoyang
     * @date 2019/10/5
     */
    void updateUserInformation(User user);


}
