package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 标签类型
 */
@Component
public class TagType implements Serializable {
    /**
     * 标签类型id
     */
    private Integer tagTypeId;
    /**
     * 标签类型名
     * 工具，学习方式，流派，类型（技法，解读），对象，其他
     */
    private String tagTypeName;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 所属标签类型的标签列表
     */
    private List<Tag> tagList;

    public Integer getTagTypeId() {
        return tagTypeId;
    }

    public void setTagTypeId(Integer tagTypeId) {
        this.tagTypeId = tagTypeId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setTagTypeName(String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
