package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

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
}
