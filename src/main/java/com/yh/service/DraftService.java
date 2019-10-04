package com.yh.service;




/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */




/**
 * 错误待纠正
 *
 * @author rongjing
 * @date 2019/10/03
 */

import com.yh.entity.VideoCourse;
import io.swagger.models.auth.In;

import java.util.List;

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
     * @author rongjing
     * @param videoCourseId
     *
     * @result VideoCourse
     * @date 2019/9/30
     */

    public VideoCourse findByVideoCourseId(String videoCourseId);





    /**
     *  用户查看课程视频封面
     * 分页展示，每页显示10个
     * @author rongjing
     * @param currentPage 当前页（integer类型）
     * @param  pageSize 每页显示条数 （integer类型）
     * @result List集合，VideoCourse
     * @date 2019/10/04
     */
    public  List<VideoCourse> findAllVideoCourse(Integer currentPage, Integer pageSize);



}
