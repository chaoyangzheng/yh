package com.yh.mapper;

import com.yh.entity.CourseType;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface CourseTypeMapper {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询所有课程类别
     * @return 所有课程类别的list集合
     */
    List<CourseType> findAllCourseType();
}
