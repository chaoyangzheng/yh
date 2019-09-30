package com.yh.service.impl;

import com.yh.entity.Type;
import com.yh.mapper.TypeMapper;
import com.yh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @Override
    public List<Type> findAllType() {
        //redis工具类暂无，暂时返回mysql中所有总类别
        return typeMapper.findAllType();
    }
}
