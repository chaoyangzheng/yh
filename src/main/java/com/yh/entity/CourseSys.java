package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 课程系列表
 */
@Component
public class CourseSys implements Serializable {
    /**
     * 课程系列id，UUID
     */
    private String courseSysId;
    /**
     * 课程系列名
     */
    private String courseSysName;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 课程系列观看次数
     */
    private Integer courseSysWatchNumber;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 课程系列更新时间
     */
    private Date courseSysUpdateTime;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 课程系列封面地址
     */
    private String courseSysImgUrl;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 课程系列讲师id
     */
    private String teacherUserId;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 课程系列讲师
     */
    private User teacher;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 视频课程列表
     */
    private List<VideoCourse> videoCourseList;

    @Override
    public String toString() {
        return "CourseSys{" +
                "courseSysId='" + courseSysId + '\'' +
                ", courseSysName='" + courseSysName + '\'' +
                ", courseSysWatchNumber=" + courseSysWatchNumber +
                ", courseSysUpdateTime=" + courseSysUpdateTime +
                ", courseSysImgUrl='" + courseSysImgUrl + '\'' +
                ", teacherUserId='" + teacherUserId + '\'' +
                ", teacher=" + teacher +
                ", videoCourseList=" + videoCourseList +
                '}';
    }

    public String getCourseSysId() {
        return courseSysId;
    }

    public void setCourseSysId(String courseSysId) {
        this.courseSysId = courseSysId;
    }

    public String getCourseSysName() {
        return courseSysName;
    }

    public void setCourseSysName(String courseSysName) {
        this.courseSysName = courseSysName;
    }

    public Integer getCourseSysWatchNumber() {
        return courseSysWatchNumber;
    }

    public void setCourseSysWatchNumber(Integer courseSysWatchNumber) {
        this.courseSysWatchNumber = courseSysWatchNumber;
    }

    public Date getCourseSysUpdateTime() {
        return courseSysUpdateTime;
    }

    public void setCourseSysUpdateTime(Date courseSysUpdateTime) {
        this.courseSysUpdateTime = courseSysUpdateTime;
    }

    public String getCourseSysImgUrl() {
        return courseSysImgUrl;
    }

    public void setCourseSysImgUrl(String courseSysImgUrl) {
        this.courseSysImgUrl = courseSysImgUrl;
    }

    public String getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(String teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<VideoCourse> getVideoCourseList() {
        return videoCourseList;
    }

    public void setVideoCourseList(List<VideoCourse> videoCourseList) {
        this.videoCourseList = videoCourseList;
    }
}
