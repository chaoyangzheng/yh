package com.yh.service.impl;

import com.github.pagehelper.PageHelper;
import com.yh.entity.CourseSys;
import com.yh.mapper.CourseSysMapper;
import com.yh.service.CourseSysService;
import com.yh.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
@Service
public class CourseSysServiceImpl implements CourseSysService {
    @Autowired
    private CourseSysMapper courseSysMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @Override
    public List<CourseSys> findComprehensiveCourseSys(Integer pageNum, Integer pageSize) {
        PageHelperUtil pageHelperUtil = PageHelperUtil.initPageHelperParam(pageNum, pageSize);
        PageHelper.startPage(pageHelperUtil.getPageNum(), pageHelperUtil.getPageSize());
        List<CourseSys> courseSysList = courseSysMapper.findComprehensiveCourseSys();
        return courseSysList;
    }
}
