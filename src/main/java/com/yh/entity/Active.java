package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 活动
 */
@Component
public class Active implements Serializable {
    /**
     * 活动id，UUID
     */
    private String activeId;
    /**
     * 活动名
     */
    private String activeName;
    /**
     * 活动开始时间
     */
    private Date beginTime;
    /**
     * 活动结束时间
     */
    private Date endTime;
    /**
     * 活动介绍
     */
    private String activeInfo;
    /**
     * 导师id
     */
    private String userId;
    /**
     * 活动方式，0线上，1线下
     */
    private Integer activeType;
    /**
     * 活动地点
     */
    private String activeAddress;
    /**
     * 活动图片
     */
    private String activeImgUrl;

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActiveInfo() {
        return activeInfo;
    }

    public void setActiveInfo(String activeInfo) {
        this.activeInfo = activeInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getActiveType() {
        return activeType;
    }

    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    public String getActiveAddress() {
        return activeAddress;
    }

    public void setActiveAddress(String activeAddress) {
        this.activeAddress = activeAddress;
    }

    public String getActiveImgUrl() {
        return activeImgUrl;
    }

    public void setActiveImgUrl(String activeImgUrl) {
        this.activeImgUrl = activeImgUrl;
    }
}
