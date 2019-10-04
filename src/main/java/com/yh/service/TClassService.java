package com.yh.service;

import com.yh.entity.TClass;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
public interface TClassService {
    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 综合顺序查询小班课列表
     */
    List<TClass> findComprehensiveClass(Integer pageNum, Integer pageSize);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 热门顺序查询小班课列表
     */
    List<TClass> findHottestClass(Integer pageNum, Integer pageSize);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 最新顺序查询小班课列表
     */
    List<TClass> findLatestClass(Integer pageNum, Integer pageSize);
}
