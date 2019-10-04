package com.yh.service.impl;

import com.github.pagehelper.PageHelper;
import com.yh.entity.TClass;
import com.yh.mapper.TClassMapper;
import com.yh.service.TClassService;
import com.yh.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
@Service
public class TClassServiceImpl implements TClassService {
    @Autowired
    private TClassMapper tClassMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @Override
    public List<TClass> findComprehensiveClass(Integer pageNum, Integer pageSize) {
        PageHelperUtil pageHelperUtil = PageHelperUtil.initPageHelperParam(pageNum, pageSize);
        PageHelper.startPage(pageHelperUtil.getPageNum(), pageHelperUtil.getPageSize());
        List<TClass> tClassList = tClassMapper.findComprehensiveClass();
        return tClassList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @Override
    public List<TClass> findHottestClass(Integer pageNum, Integer pageSize) {
        PageHelperUtil pageHelperUtil = PageHelperUtil.initPageHelperParam(pageNum, pageSize);
        PageHelper.startPage(pageHelperUtil.getPageNum(), pageHelperUtil.getPageSize());
        List<TClass> tClassList = tClassMapper.findHottestClass();
        return tClassList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @Override
    public List<TClass> findLatestClass(Integer pageNum, Integer pageSize) {
        PageHelperUtil pageHelperUtil = PageHelperUtil.initPageHelperParam(pageNum, pageSize);
        PageHelper.startPage(pageHelperUtil.getPageNum(), pageHelperUtil.getPageSize());
        List<TClass> tClassList = tClassMapper.findLatestClass();
        return tClassList;
    }
}
