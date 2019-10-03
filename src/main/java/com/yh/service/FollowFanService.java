package com.yh.service;

import java.util.Map;

/**
 * @author chaoyang
 * @date 2019/10/3
 */
public interface FollowFanService {
    //查询用户的所有的关注粉丝数
    Map getUserFollowAndFanIdCount(Map<String, Object> map);
}
