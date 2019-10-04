package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author chaoyang
 * @date 2019/10/3
 */
@Component
public class FollowFan implements Serializable {
    private String followFanId;
    private String followId;
    private String fanId;

    @Override
    public String toString () {
        return "FollowFan{" +
                "followFanId='" + followFanId + '\'' +
                ", followId='" + followId + '\'' +
                ", fanId='" + fanId + '\'' +
                '}';
    }

    public String getFollowFanId () {
        return followFanId;
    }

    public void setFollowFanId (String followFanId) {
        this.followFanId = followFanId;
    }

    public String getFollowId () {
        return followId;
    }

    public void setFollowId (String followId) {
        this.followId = followId;
    }

    public String getFanId () {
        return fanId;
    }

    public void setFanId (String fanId) {
        this.fanId = fanId;
    }
}
