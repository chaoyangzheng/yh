package com.yh.service.impl;

import com.yh.entity.CourseType;
import com.yh.mapper.CourseTypeMapper;
import com.yh.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @Override
    public List<CourseType> findAllCourseType() {
        return courseTypeMapper.findAllCourseType();
    }
}
