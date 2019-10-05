package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 班级
 * 和关键字冲突，故开头加T区分
 */
@Component
public class TClass implements Serializable {
    /**
     * 班级id，UUID
     */
    private String classId;
    /**
     * 班级名
     */
    private String className;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 班级描述
     */
    private String classInfo;
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
    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 小班课封面
     */
    private String classImgUrl;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 小班课创建人
     */
    private User creator;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 小班课导师
     */
    private User teacher;

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

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
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

    public String getClassImgUrl() {
        return classImgUrl;
    }

    public void setClassImgUrl(String classImgUrl) {
        this.classImgUrl = classImgUrl;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
