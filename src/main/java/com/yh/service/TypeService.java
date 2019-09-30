package com.yh.service;

import com.yh.entity.Type;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface TypeService {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查找所有的总类别
     * @return 所有总类别的list集合
     */
    List<Type> findAllType();
}
