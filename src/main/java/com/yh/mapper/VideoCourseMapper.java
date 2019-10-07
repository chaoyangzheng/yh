package com.yh.mapper;

import com.yh.entity.VideoCourse;
import org.apache.ibatis.annotations.Param;

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
     * @param typeId 总类别id
     * @return 默认价格降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 默认价格降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseComprehensive(Integer typeId);

    /**
     * @param typeId 总类别id
     * @return 观看数降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseHottest(Integer typeId);

    /**
     * @param typeId 总类别id
     * @return 观看数降序视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询视频课程列表
     */
    List<VideoCourse> findVideoCourseLatest(Integer typeId);

    /**
     * @param typeId 总类别id
     * @return 默认价格降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 默认价格降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseComprehensive(Integer typeId);

    /**
     * @param typeId 总类别id
     * @return 观看数降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 观看数降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseHottest(Integer typeId);

    /**
     * @param typeId 总类别id
     * @return 上传时间降序单节课体验列表
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 上传时间降序查询单节课体验列表
     */
    List<VideoCourse> findSingleVideoCourseLatest(Integer typeId);

    /**
     * @param courseSysId 课程系列id
     * @return 课程系列的视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 根据课程系列id查询视频课程列表
     */
    List<VideoCourse> findVideoCourseByCourseSysId(Integer courseSysId);

    /**
     * @param tagIdList     标签id的list集合
     * @param conditionList 搜索条件的list集合
     * @return 视频课程列表
     * @author SHIGUANGYI
     * @date 2019/10/6
     * 根据搜索条件查询视频课程列表
     */
    List<VideoCourse> findVideoCourseByCondition(@Param("tagIdList") List<String> tagIdList, @Param("conditionList") List<String> conditionList);
}
