package com.yh.service;

import com.yh.entity.VideoCourse;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
public interface VideoCourseService {
    /**
     * @return 视频课程
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 从redis中随机查询1个单节课体验，如果redis中查不到则从mysql中查询最新的1个基础公开课
     */
    VideoCourse findRandomSingleVideoCourse();

    /**
     * @return 视频课程
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 从redis中查询最热门单节课体验，如果redis中查不到则从mysql中查询观看数最高基础公开课
     */
    VideoCourse findHottestSingleVideoCourse();

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 综合顺序查询视频课程列表
     */
    List<VideoCourse> findComprehensiveVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 热门顺序查询视频课程列表
     */
    List<VideoCourse> findHottestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 热门顺序查询视频课程列表
     */
    List<VideoCourse> findLatestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 综合顺序查询单节课体验列表
     */
    List<VideoCourse> findComprehensiveSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 热门顺序查询单节课体验列表
     */
    List<VideoCourse> findHottestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);

    /**
     * @param pageNum  当前页码，默认1
     * @param pageSize 每页条数，默认10
     * @param typeId   总类别id
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 热门顺序查询单节课体验列表
     */
    List<VideoCourse> findLatestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId);
}
