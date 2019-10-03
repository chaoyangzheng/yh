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
     * 从redis中随机查询1个基础公开课，如果redis中查不到则从mysql中查询最新的1个基础公开课
     */
    VideoCourse findRandomVideoCourse();

    /**
     * @return 视频课程
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 从redis中查询最热门基础公开课，如果redis中查不到则从mysql中查询观看数最高基础公开课
     */
    VideoCourse findHottestVideoCourse();

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 综合顺序查询视频课程列表
     */
    List<VideoCourse> findComprehensiveVideoCourse(Integer pageNum, Integer pageSize);

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return 视频课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 热门顺序查询视频课程列表
     */
    List<VideoCourse> findHottestVideoCourse(Integer pageNum, Integer pageSize);
}
