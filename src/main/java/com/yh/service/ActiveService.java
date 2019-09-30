package com.yh.service;

import com.yh.entity.Active;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface ActiveService {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询当前最热门4个活动的list集合
     * @return 当前最热门4个活动的list集合
     */
    List<Active> findHotActiveList();
}
