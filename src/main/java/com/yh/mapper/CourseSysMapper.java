package com.yh.mapper;

import com.yh.entity.CourseSys;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
public interface CourseSysMapper {
    /**
     * @return 系列课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 综合顺序查询多节课进阶列表
     */
    List<CourseSys> findComprehensiveCourseSys();
}
