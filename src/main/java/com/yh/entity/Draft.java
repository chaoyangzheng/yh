package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 草稿
 */
@Component
public class Draft implements Serializable {
    /**
     * 草稿id，UUID
     */
    private String draftId;
    /**
     * 草稿标题
     */
    private String draftTitle;
    /**
     * 草稿类型id，总类别id
     */
    private Integer typeId;
    /**
     * 草稿时间
     */
    private Date draftTime;
    /**
     * 制作人id
     */
    private String userId;
    /**
     * 草稿图片地址
     */
    private String draftImgUrl;

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getDraftTitle() {
        return draftTitle;
    }

    public void setDraftTitle(String draftTitle) {
        this.draftTitle = draftTitle;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getDraftTime() {
        return draftTime;
    }

    public void setDraftTime(Date draftTime) {
        this.draftTime = draftTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDraftImgUrl() {
        return draftImgUrl;
    }

    public void setDraftImgUrl(String draftImgUrl) {
        this.draftImgUrl = draftImgUrl;
    }
}
