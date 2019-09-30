package com.yh.mapper;

import com.yh.entity.VideoCourse;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface VideoCourseMapper {
    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询最新的基础公开课
     * @return 最新的基础公开课
     */
    VideoCourse findLatestVideoCourse();
}
