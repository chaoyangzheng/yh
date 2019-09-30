package com.yh.mapper;

import com.yh.entity.Active;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface ActiveMapper {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询最新的4个活动
     * @return 最新的4个活动的list集合
     */
    List<Active> findLatestActive();
}
