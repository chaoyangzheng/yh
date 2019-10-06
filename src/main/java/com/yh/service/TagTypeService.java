package com.yh.service;

import com.yh.entity.TagType;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/5
 */
public interface TagTypeService {
    /**
     * @return 标签列表，并按标签类型分组
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 从redis中查询标签列表，如果redis中查不到则从mysql中标签列表
     */
    List<TagType> findAllTagType();
}
