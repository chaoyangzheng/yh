package com.yh.service.impl;

import com.yh.common.JsonResult;
import com.yh.entity.VideoCourse;
import com.yh.mapper.DraftMapper;
import com.yh.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请后来修改者按照这个格式添加备注
 *  * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */


/**
 * 开始画功能
 *  点击封面图片转至相关视频链接
 * @author rongjing
 * @date 2019/9/29
 */

@Service
public class DraftServiceImpl implements DraftService {


    @Autowired(required = false)
    private DraftMapper draftMapper;




    /**
     *  选择封面图片转至相关视频链接
     * @author rongjing
     *
     * 需要参数：视频封面地址
     * @param video_course_id
     *
     * 返回视频课程对象
     * @result videoCourse
     *
     * @date 2019/9/30
     */

    @Override
    public VideoCourse findByVideoCourseId(String video_course_id) {

        return draftMapper.findByVideoCourseId(video_course_id);
    }






    /**
     *  查看所有视频课程封面
     * @author rongjing
     *
     * 返回视频课程对象集合
     * 分页显示，每页10个
     * @result string
     *
     * @date 2019/10/03
     */

    @Override
    public List<VideoCourse> findAllVideoCourse() {

        return draftMapper.findAllVideoCourse();

    }












}
