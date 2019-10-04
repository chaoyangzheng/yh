package com.yh.service.impl;

import com.github.pagehelper.PageHelper;

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
     * @param currentPage 当前页（integer类型）
     * @param  pageSize 每页显示条数 （integer类型）
     * @result List集合，VideoCourse
     * @date 2019/10/04
     */

    @Override
    public List<VideoCourse> findAllVideoCourse(Integer currentPage,Integer pageSize) {

        //判断当前页是否为空，或者小于1
        //当前页默认为第一页
        if(null == currentPage || currentPage <1){
            currentPage =1;
        }

        //判断每页显示个数是否为空，或小于1
        // 默认显示个数默认值为10
        if(null == pageSize || pageSize <1){
            pageSize = 10;
        }

        //分页工具，传的参数为当前页，每页显示个数
        PageHelper.startPage(currentPage,pageSize);

        List<VideoCourse> allVideoCourse = draftMapper.findAllVideoCourse();

        return allVideoCourse;

    }












}
