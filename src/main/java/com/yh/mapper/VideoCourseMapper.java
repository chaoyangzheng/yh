package com.yh.mapper;

import com.yh.entity.VideoCourse;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface VideoCourseMapper {
    /**
     * @return 最新的10个基础公开课
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询最新的10个基础公开课
     */
    List<VideoCourse> findLatestBasicVideoCourse();

    /**
     * @return 最热门基础公开课
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 查询最热门基础公开课
     */
    VideoCourse findHottestBasicVideoCourse();

    /**
     * @return 默认价格降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 默认价格降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseDefault();

    /**
     * @return 观看数降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseHottest();
}
