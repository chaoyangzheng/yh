package com.yh.service;

import com.yh.entity.VideoCourse;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface VideoCourseService {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 从redis中随机查询1个基础公开课，如果redis中查不到则从mysql中查询最新的1个基础公开课
     * @return 视频课程
     */
    VideoCourse findRandomVideoCourse();
}
