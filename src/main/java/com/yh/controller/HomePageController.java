package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.entity.*;
import com.yh.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private CourseSysService courseSysService;

    /*-------------------------------首页页面-------------------------------*/

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
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合
     */
    @ApiOperation(value = "按综合排序查询课程", notes = "按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/comprehensiveVideoCourse.do")
    public JsonResult comprehensiveVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门
     */
    @ApiOperation(value = "按热门排序查询课程", notes = "按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/hottestVideoCourse.do")
    public JsonResult hottestVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findHottestVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新
     */
    @ApiOperation(value = "按上传时间排序查询课程", notes = "按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/latestVideoCourse.do")
    public JsonResult latestVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findLatestVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /*-----------------------------单节课体验页面----------------------------*/

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合
     */
    @ApiOperation(value = "按综合排序查询课程", notes = "按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/comprehensiveSingleVideoCourse.do")
    public JsonResult comprehensiveSingleVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门
     */
    @ApiOperation(value = "按热门排序查询课程", notes = "按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/hottestSingleVideoCourse.do")
    public JsonResult hottestSingleVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findHottestSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新
     */
    @ApiOperation(value = "按上传时间排序查询课程", notes = "按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/latestSingleVideoCourse.do")
    public JsonResult latestSingleVideoCourse(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            Integer typeId = (Integer) params.get("typeId");
            List<VideoCourse> videoCourseList = videoCourseService.findLatestSingleVideoCourse(pageNum, pageSize, typeId);
            return new JsonResult("0", videoCourseList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }

    /*------------------------多节课进阶页面--------------------------*/

    /**
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页课程的list集合;code=1,info=错误信息
     * @author SHIGUANGYI
     * @date 2019/10/3
     * 按综合排序查询系列课程，用于展示到多节课进阶页面的综合
     */
    @ApiOperation(value = "按综合排序查询系列课程", notes = "按综合排序查询系列课程，用于展示到多节课进阶页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/comprehensiveCourseSys.do")
    public JsonResult comprehensiveCourseSys(@RequestBody Map params) {
        try {
            Integer pageNum = (Integer) params.get("pageNum");
            Integer pageSize = (Integer) params.get("pageSize");
            List<CourseSys> courseSysList = courseSysService.findComprehensiveCourseSys(pageNum, pageSize);
            return new JsonResult("0", courseSysList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("1", "查询失败" + e.getMessage());
        }
    }
}
