package com.yh.mapper;

import com.yh.entity.FollowFan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chaoyang
 * @date 2019/10/3
 */
public interface FollowFanMapper {

    /**
     * 通过id查询所有的关注或者粉丝
     * @author chaoyang
     * @date 2019/10/3
     * @return java.util.List<java.lang.String>
     */
    @Select("select follow_id from t_follow_fan where fan_id = #{fanId}")
    List<String> findAllFollowByFanId(String fanId);
    @Select("select fan_id from t_follow_fan where follow_id = #{followId}")
    List<String> findAllFanByFollowId(String followId);

    int addFollowUser(FollowFan followFan);

    int unfollowUser(FollowFan followFan);
}
