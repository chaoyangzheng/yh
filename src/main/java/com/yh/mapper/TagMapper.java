package com.yh.mapper;

import com.yh.entity.Tag;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 */
public interface TagMapper {
    /**
     * @param videoCourseId 视频课程id
     * @return 标签的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 根据视频课程id查询标签列表
     */
    List<Tag> findTagByVideoCourseId(String videoCourseId);

    /**
     * @param tagTypeId 标签类型id
     * @return 标签的list集合
     * @author SHIGUANGYI
     * @date 2019/10/5
     * 根据标签类型id查询标签列表
     */
    List<Tag> findTagByTagTypeId(Integer tagTypeId);
}
