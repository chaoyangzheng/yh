package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 标签
 */
@Component
public class Tag implements Serializable {
    /**
     * 标签id，UUID
     */
    private String tagId;
    /**
     * 标签类型id
     */
    private Integer tagTypeId;
    /**
     * 标签名
     */
    private String tagName;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getTagTypeId() {
        return tagTypeId;
    }

    public void setTagTypeId(Integer tagTypeId) {
        this.tagTypeId = tagTypeId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
