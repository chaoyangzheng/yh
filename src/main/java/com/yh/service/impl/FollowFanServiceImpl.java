package com.yh.service.impl;

import com.yh.mapper.FollowFanMapper;
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
}
