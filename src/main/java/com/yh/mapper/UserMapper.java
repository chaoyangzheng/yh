package com.yh.mapper;

import com.yh.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
public interface UserMapper {
    /**
     * 功能描述
     * 通过手机号和密码查询用户
     * 通过邮箱和密码查询用户
     * @author chaoyang
     * @date 2019/9/30
     * @param  * @param user
     * @return com.yh.entity.User
     */
    @Select("select * from t_user where phone = #{phone} and password = #{password}")
    User findUserbyPhonePwd(User user);
    @Select("select * from t_user where email = #{email} and password = #{password}")
    User findUserbyEmailPwd(User user);
}
