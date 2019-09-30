package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 用户身份标识
 */
@Component
public class UserType implements Serializable {
    /**
     * 身份标识id
     */
    private Integer userTypeId;
    /**
     * 身份标识名称
     * 专家，高级导师，导师，高级讲师，讲师，普通用户
     */
    private String userTypeName;

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
