package com.yh.service;




/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */


import com.yh.entity.VideoCourse;

/**
 *  用户开始画功能
 * 点击图片进入相关课程视频
 * @author rongjing
 * @date 2019/9/30
 *
 */
public interface DraftService {



    /**
     *  用户开始画功能
     * 点击图片进入相关课程视频
     * @param video_course_img_url
     * @result VideoCourse
     *
     */
    public VideoCourse findByVideoCourseImgUrl(String video_course_img_url);


}
