package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.entity.Active;
import com.yh.entity.CourseType;
import com.yh.entity.Type;
import com.yh.entity.VideoCourse;
import com.yh.service.ActiveService;
import com.yh.service.CourseTypeService;
import com.yh.service.TypeService;
import com.yh.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 首页控制器
 */
@RestController
@RequestMapping("/HomePage")
public class HomePageController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private ActiveService activeService;

    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private VideoCourseService videoCourseService;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询所有总类别的list集合，用于展示首页顶部菜单选项，不包括全部，推荐，vip专区
     * @return code=0,info=所有总类别的list集合;code=1,info=错误信息
     */
    @PostMapping("/allTypeList")
    public JsonResult allTypeList() {
        try {
            List<Type> typeList = typeService.findAllType();
            return new JsonResult("0", typeList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "总类别列表查询失败" + e.getMessage());
        }
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询当前最热门4个活动的list集合，用于展示到首页|推荐页面的轮播图
     * @return code=0,info=当前最新4个活动的list集合;code=1,info=错误信息
     */
    @PostMapping("/hotActiveBanner")
    public JsonResult hotActiveBanner() {
        try {
            List<Active> hotActiveList = activeService.findHotActiveList();
            return new JsonResult("0", hotActiveList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "热门活动查询失败" + e.getMessage());
        }
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询所有课程类型的list集合，用于展示到首页|推荐页面的轮播图下方菜单列表，不包括名师课堂
     * @return code=0,info=所有课程类型的list集合;code=1,info=错误信息
     */
    @PostMapping("/allCourseTypeList")
    public JsonResult allCourseTypeList() {
        try {
            List<CourseType> courseTypeList = courseTypeService.findAllCourseType();
            return new JsonResult("0", courseTypeList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "课程类型列表查询失败" + e.getMessage());
        }
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 随机查询1个基础公开课，用于展示到首页|推荐页面的艺听就懂
     * @return code=0,info=视频课程;code=1,info=错误信息
     */
    @PostMapping("/easyUnderstand")
    public JsonResult easyUnderstand() {
        try {
            VideoCourse videoCourse = videoCourseService.findRandomVideoCourse();
            return new JsonResult("0", videoCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "艺听就懂查询失败" + e.getMessage());
        }
    }

}
