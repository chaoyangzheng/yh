package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 帖子
 */
@Component
public class Theme implements Serializable {
    /**
     * 帖子id，UUID
     */
    private String themeId;
    /**
     * 帖子标题
     */
    private String themeTitle;
    /**
     * 帖子类别id
     */
    private Integer typeId;
    /**
     * 帖子简介
     */
    private String themeInfo;
    /**
     * 帖子图片地址
     */
    private String imgUrl;
    /**
     * 发帖人
     */
    private String themeUserId;
    /**
     * 帖子上传时间
     */
    private Date uploadTime;
    /**
     * 浏览数
     */
    private Integer watchNumber;
    /*张栩生
    *添加User对象
    * */
    private User user;

    private Type type;


   //end张栩生


    @Override
    public String toString() {
        return "Theme{" +
                "themeId='" + themeId + '\'' +
                ", themeTitle='" + themeTitle + '\'' +
                ", typeId=" + typeId +
                ", themeInfo='" + themeInfo + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", themeUserId='" + themeUserId + '\'' +
                ", uploadTime=" + uploadTime +
                ", watchNumber=" + watchNumber +
                ", user=" + user +
                ", type=" + type +
                '}';
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getThemeInfo() {
        return themeInfo;
    }

    public void setThemeInfo(String themeInfo) {
        this.themeInfo = themeInfo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getThemeUserId() {
        return themeUserId;
    }

    public void setThemeUserId(String themeUserId) {
        this.themeUserId = themeUserId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getWatchNumber() {
        return watchNumber;
    }

    public void setWatchNumber(Integer watchNumber) {
        this.watchNumber = watchNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
