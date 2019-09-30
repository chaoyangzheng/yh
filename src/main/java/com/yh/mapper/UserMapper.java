package com.yh.mapper;

import com.yh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<User> getGoldenUserForTch();


}
