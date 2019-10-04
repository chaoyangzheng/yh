package com.yh.mapper;

import com.yh.entity.TClass;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
public interface TClassMapper {
    /**
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 综合顺序查询小班课列表
     */
    List<TClass> findComprehensiveClass();

    /**
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 热门顺序查询小班课列表
     */
    List<TClass> findHottestClass();

    /**
     * @return 小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 最新顺序查询小班课列表
     */
    List<TClass> findLatestClass();
}
