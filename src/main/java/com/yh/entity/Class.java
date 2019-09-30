package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 班级
 */
@Component
public class Class implements Serializable {
    /**
     * 班级id，UUID
     */
    private String classId;
    /**
     * 班级名
     */
    private String className;
    /**
     * 班级人数
     */
    private Integer classNumber;
    /**
     * 创建人id
     */
    private String createUserId;
    /**
     * 导师id
     */
    private String teacherUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上课时间
     */
    private String classTime;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(String teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
