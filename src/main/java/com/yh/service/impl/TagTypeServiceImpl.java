package com.yh.service.impl;

import com.yh.entity.TagType;
import com.yh.mapper.TagTypeMapper;
import com.yh.service.TagTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/5
 */
@Service
public class TagTypeServiceImpl implements TagTypeService {
    @Autowired
    private TagTypeMapper tagTypeMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/5
     */
    @Override
    public List<TagType> findAllTagType() {
        List<TagType> tagTypeList = tagTypeMapper.findAllTagType();
        return tagTypeList;
    }
}
