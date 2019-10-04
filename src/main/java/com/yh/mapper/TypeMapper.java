package com.yh.mapper;

import com.yh.entity.Type;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface TypeMapper {
    /**
     * @return 所有总类别的list集合
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查找所有的总类别
     */
    List<Type> findAllType();

    /**
     * @param typeId 总类别id
     * @return 总类别对象
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 根据总类别id查询总类别
     */
    Type findTypeByTypeId(Integer typeId);
}
