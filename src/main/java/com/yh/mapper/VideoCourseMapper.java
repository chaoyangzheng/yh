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
    List<VideoCourse> findLatestSingleVideoCourse();

    /**
     * @return 最热门基础公开课
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 查询最热门基础公开课
     */
    VideoCourse findHottestSingleVideoCourse();

    /**
     * @return 默认价格降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 默认价格降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseComprehensive(Integer typeId);

    /**
     * @return 观看数降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseHottest(Integer typeId);

    /**
     * @return 观看数降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseLatest(Integer typeId);

    /**
     * @return 默认价格降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 默认价格降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseComprehensive(Integer typeId);

    /**
     * @return 观看数降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseHottest(Integer typeId);

    /**
     * @return 上传时间降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 上传时间降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseLatest(Integer typeId);
}
