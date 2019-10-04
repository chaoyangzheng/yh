package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
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
     * 视频课程列表
     */
    private List<VideoCourse> videoCourseList;

    @Override
    public String toString() {
        return "CourseSys{" +
                "courseSysId='" + courseSysId + '\'' +
                ", courseSysName='" + courseSysName + '\'' +
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

    public List<VideoCourse> getVideoCourseList() {
        return videoCourseList;
    }

    public void setVideoCourseList(List<VideoCourse> videoCourseList) {
        this.videoCourseList = videoCourseList;
    }
}
