package com.yh.service.impl;

import com.yh.entity.VideoCourse;
import com.yh.mapper.VideoCourseMapper;
import com.yh.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
@Service
public class VideoCourseServiceImpl implements VideoCourseService {
    @Autowired
    private VideoCourseMapper videoCourseMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @Override
    public VideoCourse findRandomVideoCourse() {
        //redis工具类暂无，暂时从mysql中查询最新视频课程
        return videoCourseMapper.findLatestVideoCourse();
    }
}
