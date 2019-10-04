package com.yh.service;

import com.yh.entity.CourseSys;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
public interface CourseSysService {
    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @return 系列课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 综合顺序查询多节课进阶列表
     */
    List<CourseSys> findComprehensiveCourseSys(Integer pageNum, Integer pageSize);
}
