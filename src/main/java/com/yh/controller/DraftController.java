package com.yh.controller;

import com.yh.common.JsonResult;

import com.yh.entity.VideoCourse;
import com.yh.service.DraftService;

import com.yh.utils.DataConversionUtil;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 遇见页面功能
 *@author rongjing
 * @date 2019/10/03
 */


@Api("遇见模块功能")
@RestController
@RequestMapping("/Draft")
public class DraftController {

    @Autowired
    private DraftService draftService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;





    /**
     * 遇见页面开始画功能细节更改
     * 更改提交方式：post
     * 更改返回值类型为：JsonResult
     * 完善返回值
     *@author rongjing
     * @return code=0,info=对应视频课程;code=1,info=错误信息
     * @date 2019/10/03
     */
    @ApiOperation(value = "开始画功能",notes = "根据所给的视频封面选择相应视频课程页面")
    @RequestMapping(value = "/queryOne.do",method = RequestMethod.POST)

    public JsonResult queryByVideoCourseId( @ApiParam(value = "视频封面图片对应的视频id",required = true)@RequestBody Map<String,String> map) {

        System.out.println(map.get("videoCourseId"));

            VideoCourse videoCourse = draftService.findByVideoCourseId(map.get("videoCourseId"));

            if(videoCourse != null){
                return new JsonResult("0",videoCourse);
            }else {
                return new JsonResult("1","没有相应视频课程信息");
            }

    }





    /**
     * 遇见页面
     * 提交方式：post
     * 返回值类型为：JsonResult
     *@author rongjing
     * @param currentPage 当前页 （Integer 类型）
     * @param  pageSize 每页显示个数 （Integer 类型）
     * @return code=0,info=对应视频课程;code=1,info=错误信息
     * @date 2019/10/04
     */
    @ApiOperation(value = "展示所有视频课程封面，", notes = "返回对象是个list集合分页显示，每页显示10个，不喜欢是下一页的功能")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" ,name = "currentPage",value = "当前页页码",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize",value = "每页显示个数",dataType = "Integer",defaultValue = "10")
    })

    @PostMapping(value = "/queryAll.do")
    public JsonResult queryAllVideoCourse(Integer currentPage ,Integer pageSize){


            List<VideoCourse> allVideoCourse = draftService.findAllVideoCourse(currentPage,pageSize);

            if(allVideoCourse != null){
                return new JsonResult("0",allVideoCourse);
            }else {
                return new JsonResult("1","没有视频课程信息");
            }

    }


}
