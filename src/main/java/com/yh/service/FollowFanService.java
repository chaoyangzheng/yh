package com.yh.service;

import com.yh.entity.FollowFan;
import com.yh.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author chaoyang
 * @date 2019/10/3
 */
public interface FollowFanService {
    //查询用户的所有的关注粉丝数
    Map getUserFollowAndFanIdCount(Map<String, Object> map);
    //查看用户的所有关注用户
    List<User> findAllFollowUser(Map<String,Object> map);
    //查看用户的所有关注用户粉丝
    List<User> findAllFanUser(Map<String,Object> map);

    /*author:zxs
    * 作用:社区用户加关注*/
    int addFollowUser(Map<String,Object> map);

    /*author:zxs
    * 作用:社区用户取消关注*/
    int unfollowUser(Map<String,Object> map);
}
