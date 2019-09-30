package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 视频课程
 */
@Component
public class VideoCourse implements Serializable {
    /**
     * 视频课程id，UUID
     */
    private String videoCourseId;
    /**
     * 视频课程名称
     */
    private String videoCourseName;
    /**
     * 视频标题
     */
    private String videoTitle;
    /**
     * 视频简介
     */
    private String videoInfo;
    /**
     * 视频课程类别id，总类别id
     */
    private Integer typeId;
    /**
     * 视频课程地址
     */
    private String videoCourseUrl;
    /**
     * 视频课程封面地址
     */
    private String videoCourseImgUrl;
    /**
     * 上传者id
     */
    private String uploadUserId;
    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 导师id
     */
    private String teacherUserId;
    /**
     * 观看数
     */
    private Integer watchNumber;


    /**
     * 课程价格
     *
     */
    private double videoPrice;

    public double getVideoPrice() {
        return videoPrice;
    }

    public void setVideoPrice(double videoPrice) {
        this.videoPrice = videoPrice;
    }

    public String getVideoCourseId() {
        return videoCourseId;
    }

    public void setVideoCourseId(String videoCourseId) {
        this.videoCourseId = videoCourseId;
    }

    public String getVideoCourseName() {
        return videoCourseName;
    }

    public void setVideoCourseName(String videoCourseName) {
        this.videoCourseName = videoCourseName;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(String videoInfo) {
        this.videoInfo = videoInfo;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getVideoCourseUrl() {
        return videoCourseUrl;
    }

    public void setVideoCourseUrl(String videoCourseUrl) {
        this.videoCourseUrl = videoCourseUrl;
    }

    public String getVideoCourseImgUrl() {
        return videoCourseImgUrl;
    }

    public void setVideoCourseImgUrl(String videoCourseImgUrl) {
        this.videoCourseImgUrl = videoCourseImgUrl;
    }

    public String getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(String uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(String teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public Integer getWatchNumber() {
        return watchNumber;
    }

    public void setWatchNumber(Integer watchNumber) {
        this.watchNumber = watchNumber;
    }
}
