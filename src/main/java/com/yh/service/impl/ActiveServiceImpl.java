package com.yh.service.impl;

import com.yh.entity.Active;
import com.yh.mapper.ActiveMapper;
import com.yh.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private ActiveMapper activeMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @Override
    public List<Active> findHotActiveList() {
        //redis工具类暂无，暂时返回mysql中最新的4个活动
        return activeMapper.findLatestActive();
    }
}
