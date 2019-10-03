package com.yh.controller;


import com.yh.common.JsonResult;
import com.yh.entity.Active;
import com.yh.entity.Theme;
import com.yh.entity.Type;
import com.yh.service.ActiveService;
import com.yh.service.ThemeService;
import com.yh.service.TypeService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
* author:zxs
* Date:19/10/3
* description:社区内的帖子*/
@RestController
@RequestMapping("/Theme")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @Autowired
    TypeService typeService;

    @Autowired
    ActiveService activeService;
        /*begin:发现页
        *author:zxs
        * Date:19/10/3
        * description:发现页包含5个jsonResult
        * 1.未登录前默认显示最新，返回findAllTheme方法中的帖子默认是按最新时间排列
        * 2.最上方的活动图片
        * 3.热门达人，一天换一个
        * 4.默认是Type类型的typeName集合
        * 5.获取到当前typeName集合的值，按名字查看帖子
        * */
    @ApiOperation(value = "社区发现",notes = "查看社区发现页面默认的最新展示栏")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findAll.do",method = RequestMethod.POST)
    public JsonResult findAllTheme(){
        JsonResult themeList = themeService.findAllTheme();
        return themeList;
    }

    @ApiOperation(value = "社区发现",notes = "查看社区发现页面水彩，彩铅，油画等")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findTypeName.do",method = RequestMethod.POST)
    public JsonResult findTypeName(){
        List<Type> typeList = typeService.findAllType();
        return new JsonResult("0",typeList);
    }

    @ApiOperation(value = "社区发现",notes = "查看社区发现页面水彩，彩铅，油画等具体帖子内容")
    @ApiModelProperty(value = "需要Integer类型的typeId")
    @RequestMapping(value = "/findTypeContext.do",method = RequestMethod.POST)
    public JsonResult findTypeContext(Integer typeId){
        List<Theme> themeListById = themeService.findThemeById(typeId);
        return new JsonResult("0",themeListById);
    }

    @ApiOperation(value = "社区发现",notes = "查看社区发现页面上面活动图片")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findActiveImg.do",method = RequestMethod.POST)
    public JsonResult findActiveImg(){
        List<Active> hotActiveList = activeService.findHotActiveList();
        return new JsonResult("0",hotActiveList);
    }

    /*end:发现页,还差一个热门达人
    * Date:19*/








    @ApiOperation(value = "发布帖子",notes = "用户必须已经登录过且themeUserId存在token中")
    @ApiModelProperty(value = "传递的字段应该为帖子标题，描述，图片地址，标签，以及当前时间和themeUserId")
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public JsonResult addTheme(@RequestBody Map<String,Object>map){
        if (map.get("token") == null){
            return new JsonResult("1","还未登录，请先登录再查看我的关注列表");
        }
        JsonResult jsonResult = themeService.addTheme(map);
        return jsonResult;
    }



}
