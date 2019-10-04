package com.yh.mapper;

import com.yh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.yh.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */

public interface UserMapper {
    /*author:张栩生
    * description:点击社区默认跳转关注页面，查询所有是老师的用户*/
    public List<User> findAllUser();

    /*author:zxs
    * description:查询金牌讲师*/
    public List<User> getGoldenUserForTch();

//    /*author:zxs
//    * description:查询热门达人*/
//    @Select("select follow_id,count(1) from t_follow_fan group by follow_id order by count(1) desc LIMIT 0,1;")
//    public Map<String,Integer> findHotSuperUserId();
//
//    public List<User> findHotSuperUserById(Map<String,Integer>map);

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
    @Select("select * from t_user where userId = #{userId)")
    User findUserByUserId (String userId);
    @Select("select * from t_user where id = #{id)")
    User findUserById (Integer id);
    void addUserByPhone(User user);
    void addUserByEmail(User user);

}
