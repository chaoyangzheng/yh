package com.yh.service.impl;

import com.yh.entity.VideoCourse;
import com.yh.mapper.DraftMapper;
import com.yh.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 请后来修改者按照这个格式添加备注
 *  * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */


/**
 * 开始画功能
 *  点击封面图片转至相关视频链接
 * @author chaoyang
 * @date 2019/9/29
 */

@Service
public class DraftServiceImpl implements DraftService {


    @Autowired
    private DraftMapper draftMapper;


    /**
     *  选择封面图片转至相关视频链接
     * @author chaoyang
     *
     * 需要参数：视频封面地址
     * @param video_course_img_url
     *
     * 返回视频课程对象
     * @result videoCourse
     *
     * @date 2019/9/29
     */
    @Override
    public VideoCourse findByVideoCourseImgUrl(String video_course_img_url) {

        return draftMapper.findByVideoCourseImgUrl(video_course_img_url);
    }

}
