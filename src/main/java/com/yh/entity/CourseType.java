package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 课程类型
 */
@Component
public class CourseType implements Serializable {
    /**
     * 课程类型id
     */
    private Integer courseTypeId;
    /**
     * 课程类型名称
     * 基础公开课(id=1)，进阶系统课(id=2)，精品小班课(id=3)，视频直播课(id=4)
     */
    private String courseTypeName;

    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }
}
