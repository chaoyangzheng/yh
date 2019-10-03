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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("首页及其相关页面")
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
     * @return code=0,info=所有总类别的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询所有总类别的list集合，用于展示首页顶部菜单选项，不包括全部，推荐，vip专区
     */
    @ApiOperation(value = "查询所有总类别", notes = "查询所有总类别的list集合，用于展示首页顶部菜单选项，例如水彩/素描/彩铅/油画，但不包括全部，推荐，vip专区")
    @PostMapping("/allTypeList.do")
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
     * @return code=0,info=当前最新4个活动的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询当前最热门4个活动的list集合，用于展示到首页|推荐页面的轮播图
     */
    @ApiOperation(value = "查询当前最热门4个活动", notes = "查询当前最热门4个活动的list集合，用于展示到首页|推荐页面的轮播图")
    @PostMapping("/hotActiveBanner.do")
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
     * @return code=0,info=所有课程类型的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 查询所有课程类型的list集合，用于展示到首页|推荐页面的轮播图下方菜单列表，不包括名师课堂
     */
    @ApiOperation(value = "查询所有课程类型", notes = "查询所有课程类型的list集合，用于展示到首页|推荐页面的轮播图下方菜单列表，例如单节课体验，多节课进阶，小班课，直播视频课，但不包括名师讲堂")
    @PostMapping("/allCourseTypeList.do")
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
     * @return code=0,info=视频课程;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/9/30
     * 随机查询艺听就懂课程，用于展示到首页|推荐页面的艺听就懂
     */
    @ApiOperation(value = "随机查询艺听就懂课程", notes = "随机查询1个单节课体验，用于展示到首页|推荐页面的艺听就懂")
    @PostMapping("/easyUnderstandVideoCourse.do")
    public JsonResult easyUnderstandVideoCourse() {
        try {
            VideoCourse videoCourse = videoCourseService.findRandomSingleVideoCourse();
            return new JsonResult("0", videoCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "艺听就懂查询失败" + e.getMessage());
        }
    }

    /**
     * @return code=0,info=视频课程;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 查询今日推荐课程，用于展示到首页|推荐页面的今日推荐
     */
    @ApiOperation(value = "查询今日推荐课程", notes = "查询今日最热门的1个单节课体验，用于展示到首页|推荐页面的今日推荐")
    @PostMapping("/todayRecommendVideoCourse.do")
    public JsonResult todayRecommendVideoCourse() {
        try {
            VideoCourse videoCourse = videoCourseService.findHottestSingleVideoCourse();
            return new JsonResult("0", videoCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "今日推荐查询失败" + e.getMessage());
        }
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合
     */
    @ApiOperation(value = "按综合排序查询课程", notes = "按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/comprehensiveVideoCourse.do")
    public JsonResult comprehensiveVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门
     */
    @ApiOperation(value = "按热门排序查询课程", notes = "按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/hottestVideoCourse.do")
    public JsonResult hottestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findHottestVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新
     */
    @ApiOperation(value = "按上传时间排序查询课程", notes = "按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/latestVideoCourse.do")
    public JsonResult latestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findLatestVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }



    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合
     */
    @ApiOperation(value = "按综合排序查询课程", notes = "按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/comprehensiveSingleVideoCourse.do")
    public JsonResult comprehensiveSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门
     */
    @ApiOperation(value = "按热门排序查询课程", notes = "按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/hottestSingleVideoCourse.do")
    public JsonResult hottestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findHottestSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId   总类别id
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新
     */
    @ApiOperation(value = "按上传时间排序查询课程", notes = "按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "typeId", value = "总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画", dataType = "Integer", defaultValue = "0")
    })
    @PostMapping("/latestSingleVideoCourse.do")
    public JsonResult latestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        try {
            List<VideoCourse> videoCourseList = videoCourseService.findLatestSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }
}
