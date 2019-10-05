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
@Api(description = "首页及其相关页面")
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

    @Autowired
    private TClassService tClassService;

    @Autowired
    private TagTypeService tagTypeService;

    /**
     * 将Object（String或数字）转换为Integer
     *
     * @param obj 待转换对象
     * @return 转换成功返回Integer对象，失败返回null
     * @author SHIGUANGYI
     * @date 2019/10/5
     */
    private Integer objToInt(Object obj) {
        if (null == obj || "".equals(obj)) {
            return null;
        } else if (obj instanceof Integer) {
            return (Integer) obj;
        } else if (obj instanceof Double) {
            return ((Double) obj).intValue();
        } else if (obj instanceof String && ((String) obj).replace(" ", "").matches("^-?\\d+(\\.\\d+)?$")) {
            String num = ((String) obj).replace(" ", "");
            if (num.contains(".")) {
                num = num.substring(0, num.indexOf('.'));
            }
            return Integer.valueOf(num);
        } else {
            return null;
        }
    }

    /*-------------------------------首页页面-------------------------------*/

    /**
     * 查询所有总类别的list集合，用于展示首页顶部菜单选项，不包括全部，推荐，vip专区
     *
     * @return code=0,info=所有总类别的list集合
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @ApiOperation("查询所有总类别的list集合，用于展示首页顶部菜单选项，例如水彩/素描/彩铅/油画，但不包括全部，推荐，vip专区")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/allTypeList.do")
    public JsonResult allTypeList() {
        List<Type> typeList = typeService.findAllType();
        return new JsonResult("0", typeList);
    }

    /**
     * 查询当前最热门4个活动的list集合，用于展示到首页|推荐页面的轮播图
     *
     * @return code=0,info=当前最新4个活动的list集合
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @ApiOperation("查询当前最热门4个活动的list集合，用于展示到首页|推荐页面的轮播图")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/hotActiveBanner.do")
    public JsonResult hotActiveBanner() {
        List<Active> hotActiveList = activeService.findHotActiveList();
        return new JsonResult("0", hotActiveList);
    }

    /**
     * 查询所有课程类型的list集合，用于展示到首页|推荐页面的轮播图下方菜单列表，不包括名师课堂
     *
     * @return code=0,info=所有课程类型的list集合
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @ApiOperation("查询所有课程类型的list集合，用于展示到首页|推荐页面的轮播图下方菜单列表，例如单节课体验，多节课进阶，小班课，直播视频课，但不包括名师讲堂")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/allCourseTypeList.do")
    public JsonResult allCourseTypeList() {
        List<CourseType> courseTypeList = courseTypeService.findAllCourseType();
        return new JsonResult("0", courseTypeList);
    }

    /**
     * 随机查询艺听就懂课程，用于展示到首页|推荐页面的艺听就懂
     *
     * @return code=0,info=视频课程
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @ApiOperation("随机查询1个单节课体验，用于展示到首页|推荐页面的艺听就懂")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/easyUnderstandVideoCourse.do")
    public JsonResult easyUnderstandVideoCourse() {
        VideoCourse videoCourse = videoCourseService.findRandomSingleVideoCourse();
        return new JsonResult("0", videoCourse);
    }

    /**
     * 查询今日推荐课程，用于展示到首页|推荐页面的今日推荐
     *
     * @return code=0,info=视频课程
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("查询今日最热门的1个单节课体验，用于展示到首页|推荐页面的今日推荐")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/todayRecommendVideoCourse.do")
    public JsonResult todayRecommendVideoCourse() {
        VideoCourse videoCourse = videoCourseService.findHottestSingleVideoCourse();
        return new JsonResult("0", videoCourse);
    }

    /**
     * 按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按综合排序查询课程，用于展示到首页|全部/水彩/素描等页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/comprehensiveVideoCourse.do")
    public JsonResult comprehensiveVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /**
     * 按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按热门排序查询课程，用于展示到首页|全部/水彩/素描等页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/hottestVideoCourse.do")
    public JsonResult hottestVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findHottestVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /**
     * 按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按上传时间排序查询课程，用于展示到首页|全部/水彩/素描等页面的最新")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/latestVideoCourse.do")
    public JsonResult latestVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findLatestVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /*-----------------------------单节课体验页面----------------------------*/

    /**
     * 按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按综合排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/comprehensiveSingleVideoCourse.do")
    public JsonResult comprehensiveSingleVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findComprehensiveSingleVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /**
     * 按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按热门排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/hottestSingleVideoCourse.do")
    public JsonResult hottestSingleVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findHottestSingleVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /**
     * 按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     *               总类别id，typeId，默认0，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return code=0,info=当前页课程的list集合
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @ApiOperation("按上传时间排序查询课程，用于展示到单节课体验|全部/水彩/素描等页面的最新")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10, //每页条数，默认10,\n\"typeId\":0 //总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画\n}")
    @PostMapping("/latestSingleVideoCourse.do")
    public JsonResult latestSingleVideoCourse(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        Integer typeId = objToInt(params.get("typeId"));
        List<VideoCourse> videoCourseList = videoCourseService.findLatestSingleVideoCourse(pageNum, pageSize, typeId);
        return new JsonResult("0", videoCourseList);
    }

    /*------------------------多节课进阶页面--------------------------*/

    /**
     * 按综合排序查询系列课程，用于展示到多节课进阶页面的综合
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页课程系列的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按综合排序查询系列课程，用于展示到多节课进阶页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/comprehensiveCourseSys.do")
    public JsonResult comprehensiveCourseSys(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<CourseSys> courseSysList = courseSysService.findComprehensiveCourseSys(pageNum, pageSize);
        return new JsonResult("0", courseSysList);
    }

    /**
     * 按观看数排序查询系列课程，用于展示到多节课进阶页面的热门
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页课程系列的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按观看数排序查询系列课程，用于展示到多节课进阶页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/hottestCourseSys.do")
    public JsonResult hottestCourseSys(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<CourseSys> courseSysList = courseSysService.findHottestCourseSys(pageNum, pageSize);
        return new JsonResult("0", courseSysList);
    }

    /**
     * 按更新时间排序查询系列课程，用于展示到多节课进阶页面的新增
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页课程系列的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按更新时间排序查询系列课程，用于展示到多节课进阶页面的新增")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/latestCourseSys.do")
    public JsonResult latestCourseSys(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<CourseSys> courseSysList = courseSysService.findLatestCourseSys(pageNum, pageSize);
        return new JsonResult("0", courseSysList);
    }

    /*------------------------小班课页面--------------------------*/

    /**
     * 按综合排序查询小班课，用于展示到小班课页面的综合
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按综合排序查询小班课，用于展示到小班课页面的综合")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/comprehensiveClass.do")
    public JsonResult comprehensiveClass(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<TClass> tClassList = tClassService.findComprehensiveClass(pageNum, pageSize);
        return new JsonResult("0", tClassList);
    }

    /**
     * 按观看数排序查询小班课，用于展示到小班课页面的热门
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按观看数排序查询小班课，用于展示到小班课页面的热门")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/hottestClass.do")
    public JsonResult hottestClass(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<TClass> tClassList = tClassService.findHottestClass(pageNum, pageSize);
        return new JsonResult("0", tClassList);
    }

    /**
     * 按更新时间排序查询小班课，用于展示到小班课页面的最新
     *
     * @param params 参数map，包含：
     *               当前页码，pageNum，默认1
     *               每页条数，pageSize，默认10
     * @return code=0,info=当前页小班课的list集合
     * @author SHIGUANGYI
     * @date 2019/10/4
     */
    @ApiOperation("按更新时间排序查询小班课，用于展示到小班课页面的最新")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\", //用户token\n\"pageNum\":1, //当前页码，默认1\n\"pageSize\":10 //每页条数，默认10\n}")
    @PostMapping("/latestClass.do")
    public JsonResult latestClass(@RequestBody Map params) {
        Integer pageNum = objToInt(params.get("pageNum"));
        Integer pageSize = objToInt(params.get("pageSize"));
        List<TClass> tClassList = tClassService.findLatestClass(pageNum, pageSize);
        return new JsonResult("0", tClassList);
    }

    /*------------------------搜索页面--------------------------*/

    /**
     * 查询所有的标签，并按标签类型分类，用于展示到搜索页面
     *
     * @return code=0,info=所有标签的list集合
     * @author SHIGUANGYI
     * @date 2019/10/5
     */
    @ApiOperation("查询所有的标签，并按标签类型分类，用于展示到搜索页面")
    @ApiImplicitParam(name = "params", value = "{\n\"token\":\"token\" //用户token\n}")
    @PostMapping("/tagList.do")
    public JsonResult tagList() {
        List<TagType> tagTypeList = tagTypeService.findAllTagType();
        return new JsonResult("0", tagTypeList);
    }
}
