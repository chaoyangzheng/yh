package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 *
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 用户
 */
@Component
public class User implements Serializable {
    /**
     * 用户主键id，UUID
     */
    private String userId;
    /**
     * 账户id，用于前端展示，用户可自行修改，非主键
     */
    private Integer Id;
    /**
     * 昵称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份标识id
     */
    private Integer userTypeId;
    /**
     * 头像地址
     */
    private String userImgUrl;
    /**
     * 个人简介
     */
    private String userInfo;

    /**
     * 张栩生添加
     * 需要一个金牌老师的对象
     */
    private UserType userType;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userTypeId=" + userTypeId +
                ", userImgUrl='" + userImgUrl + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", userType=" + userType +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
