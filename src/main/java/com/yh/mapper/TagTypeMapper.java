package com.yh.mapper;

import com.yh.entity.TagType;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/5
 */
public interface TagTypeMapper {
    /**
     * @return 标签列表，并按标签类型分组
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 查询标签列表，并按标签类型分组
     */
    List<TagType> findAllTagType();
}
