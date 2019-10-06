package com.yh.controller;


import com.yh.common.JsonResult;

import com.yh.service.CollectionThemeService;
import com.yh.service.CollectionVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(description = "收藏功能")
@RestController
@RequestMapping("/Collection")
public class CollectionController {





    /**
     * 收藏功能
     * 提交方式：post
     *@author rongjing
     * @param map<>
     * @return code=0,info=对应视频课程;code=1,info=错误信息
     * @date 2019/10/06
     */


    @Autowired(required = false)
    private CollectionVideoService collectionVideoService;


    @Autowired
    private CollectionThemeService collectionThemeService;




    @ApiOperation(value = "收藏帖子或者视频功能", notes = "需要传用户的id，收藏内容的id，还有收藏内容类型：视频或者帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "收藏类型，视频或者帖子",dataType = "String"),
            @ApiImplicitParam( name = "userId",value = "用户id",dataType = "String"),
            @ApiImplicitParam( name = "collectionId",value = "收藏内容的id",dataType = "String")
    })
    @PostMapping(value = "/collection.do")
    public JsonResult judgeType(@RequestBody Map<String,String>map){

        String userId = map.get("userId");

        String type = map.get("type");

        String collectionId = map.get("collectionId");

        if("".equals(userId) || userId == null){

           return new JsonResult("1","没有用户id");
        }
        if ("".equals(collectionId) || collectionId == null) {
            return new JsonResult("1","没有收藏的东西的id");
        }

        if("".equals(type) || type == null){
            return new JsonResult("1","没有类型，不知道收藏的是哪种类型，是帖子还是视频呢");
        }

        if ("视频".equals(type)) {
            collectionVideoService.insertVideoToCollection(userId,collectionId);
            return new JsonResult("0","已成功收藏该视频");

        } else if ("帖子".equals(type)) {
            collectionThemeService.insertThemeToCollection(userId,collectionId);
            return new JsonResult("0","已成功收藏该帖子");
        }

        return new JsonResult("1","收藏失败,原因未知");
    }



}
