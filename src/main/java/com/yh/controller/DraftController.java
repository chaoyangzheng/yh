package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.entity.VideoCourse;
import com.yh.service.DraftService;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */



/**
 * 遇见页面功能
 *@author rongjing
 * @date 2019/9/29
 */
@RestController
public class DraftController {

    @Autowired
    private DraftService draftService;

    @RequestMapping("/query.do")
    public JsonResult queryByVideoCourseImgUrl(String video_course_img_url) {


            VideoCourse videoCourse = draftService.findByVideoCourseImgUrl(video_course_img_url);





        /**
         * 返回值没有写，暂定
         * 防报错，先写的返回值为null
         *@author rongjing
         * @date 2019/9/29
         */
            return null;


    }




}
