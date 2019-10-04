package com.yh.service.impl;

import com.yh.common.JsonResult;
import com.yh.entity.FollowFan;
import com.yh.entity.User;
import com.yh.mapper.FollowFanMapper;
import com.yh.mapper.UserMapper;
import com.yh.service.FollowFanService;
import com.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chaoyang
 * @date 2019/10/3
 */
@Service
public class FollowFanServiceImpl implements FollowFanService {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @Autowired(required = false)
    FollowFanMapper followFanMapper;
    @Override
    public Map getUserFollowAndFanIdCount (Map<String, Object> map) {
        String token = (String) map.get("token");
        if (token==null){
            return null;
        }
        String userId = userService.getUserIdFromRedisToken(token);
        if (userId==null){
            return null;
        }
        List<String> allFanId = followFanMapper.findAllFanByFollowId(userId);
        List<String> allFollowId = followFanMapper.findAllFollowByFanId(userId);
        HashMap<String, Object> followFanMap = new HashMap<>();
        followFanMap.put("follow",allFollowId);
        followFanMap.put("fan",allFanId);
        return followFanMap;
    }

    @Override
    public List<User> findAllFollowUser (Map<String,Object> map) {
        String token = (String) map.get("token");
        String userId = userService.getUserIdFromRedisToken(token);
        List<String> followId = followFanMapper.findAllFollowByFanId(userId);
        if (followId==null){
            return null;
        }
        List<User> allFollowUser = userMapper.findAllUserByUserId(followId);
        if (allFollowUser==null){
            throw new RuntimeException("数据异常");
        }
        return allFollowUser;
    }

    @Override
    public List<User> findAllFanUser (Map<String,Object> map) {
        String token = (String) map.get("token");
        String userId = userService.getUserIdFromRedisToken(token);

        List<String> fanId = followFanMapper.findAllFanByFollowId(userId);
        if (fanId==null){
            return null;
        }
        List<User> allFanUser = userMapper.findAllUserByUserId(fanId);
        if (allFanUser==null){
            throw new RuntimeException("数据异常");
        }
        return allFanUser;
    }

    /*zxs*/
    @Override
    public int addFollowUser(Map<String,Object> map) {
        String token = (String) map.get("token");
        String fanId = userService.getUserIdFromRedisToken(token);
        String followId = (String)map.get("followId");
        FollowFan followFan = new FollowFan();
        followFan.setFanId(fanId);
        followFan.setFollowId(followId);
        int i = followFanMapper.addFollowUser(followFan);
        return i;
    }

    @Override
    public int unfollowUser(Map<String,Object> map) {
        String token = (String) map.get("token");
        String fanId = userService.getUserIdFromRedisToken(token);
        String followId = (String)map.get("followId");
        FollowFan followFan = new FollowFan();
        followFan.setFanId(fanId);
        followFan.setFollowId(followId);
        int i = followFanMapper.unfollowUser(followFan);
        return i;
    }
}
