package com.yh.controller;


import com.yh.common.JsonResult;
import com.yh.entity.Active;
import com.yh.entity.Theme;
import com.yh.entity.Type;
import com.yh.entity.User;
import com.yh.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* author:zxs
* Date:19/10/3
* description:社区内的帖子*/
@Api(description = "社区内的功能")
@RestController
@RequestMapping("/Bbs")
public class BbsController {
    @Autowired
    ThemeService themeService;

    @Autowired
    TypeService typeService;

    @Autowired
    ActiveService activeService;

    @Autowired
    UserService userService;

    @Autowired
    FollowFanService followFanService;
        /*@begin:发现页
        *@author:zxs
        *@Date:19/10/3
        *@description:发现页包含6个jsonResult
        * 1.未登录前默认显示最新，返回findAllTheme方法中的帖子默认是按最新时间排列
        * 2.最上方的活动图片
        * 3.热门达人，一天换一个，一共7个
        * 4.默认是Type类型的typeName集合
        * 5.获取到当前typeName集合的值，按名字查看帖子
        * 6.关注热门达人
        * */
    @ApiOperation(value = "社区发现-默认最新的内容，不需要参数,postman已测",notes = "查看社区发现页面默认的最新展示栏")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findAll.do",method = RequestMethod.POST)
    public JsonResult findAllTheme(){
        JsonResult themeList = themeService.findAllTheme();
        return themeList;
    }

    @ApiOperation(value = "社区发现-标签栏-不需要参数，postman已测",notes = "查看社区发现页面水彩，彩铅，油画等")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findTypeName.do",method = RequestMethod.POST)
    public JsonResult findTypeName(){
        List<Type> typeList = typeService.findAllType();
        return new JsonResult("0",typeList);
    }

    @ApiOperation(value = "社区发现-查看标签栏内容-需要参数，postman已测",notes = "查看社区发现页面水彩，彩铅，油画等具体帖子内容")
    @ApiModelProperty(value = "需要Integer类型的typeId")
    @RequestMapping(value = "/findTypeContext.do",method = RequestMethod.POST)
    public JsonResult findTypeContext(@RequestBody Map<String,Object>map){
        Integer typeId = (Integer)map.get("typeId");
        List<Theme> themeListById = themeService.findThemeById(typeId);
        return new JsonResult("0",themeListById);
    }

    @ApiOperation(value = "社区发现-活动图片，不需要参数，postman已测",notes = "查看社区发现页面上面活动图片")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findActiveImg.do",method = RequestMethod.POST)
    public JsonResult findActiveImg(){
        List<Active> hotActiveList = activeService.findHotActiveList();
        return new JsonResult("0",hotActiveList);
    }


    @ApiOperation(value = "社区发现-查看热门达人，不需要参数-postman已测，但内部仍需更改",notes = "查看社区发现热门达人,hotUserList是粉丝量前7user用户集合，HotUserShowNumList是对应的作品数集合,hotSuperUserShowImg里面包含了热门达人的id和作品图片")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findHotUser.do",method = RequestMethod.POST)
    public JsonResult findHotUser(){
        List<User> hotUserList = userService.findHotSuperUserById();
        List<Integer> hotUserShowNumList = userService.findHotSuperUserShowNumById();
        List<Theme> hotSuperUserShowImg = themeService.findHotSuperUserShowImgById();
        HashMap<Object, Object> hotUser = new HashMap<>();
        hotUser.put("hotUserList",hotUserList);
        hotUser.put("hotUserShowNumList",hotUserShowNumList);
        hotUser.put("hotSuperUserShowImg",hotSuperUserShowImg);
        return new JsonResult("0",hotUser);
    }

    @ApiOperation(value = "社区发现-关注热门达人，需要参数-postman已测可用，但代码逻辑仍需完善",notes = "关注社区发现热门达人，需要用户的userId传token,以及要加关注用户的userId命名为followId")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/followHotUser.do",method = RequestMethod.POST)
    public JsonResult followHotUser(@RequestBody Map<String,Object> map){
        if (map.get("token")==null){
            return new JsonResult("1","还未登录，请先登录");
        }
        int i = followFanService.addFollowUser(map);
        if (i == 0){
            return new JsonResult("1","关注失败，服务器异常，请重试");
        }
        return new JsonResult("0","关注成功");
    }

    @ApiOperation(value = "社区发现-取消关注热门达人，需要参数",notes = "关注社区发现热门达人，需要用户的userId传token,以及要取消关注用户的userId命名为followId")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/unfollowHotUser.do",method = RequestMethod.POST)
    public JsonResult unfollowHotUser(@RequestBody Map<String,Object> map){
        if (map.get("token")==null){
            return new JsonResult("1","还未登录，请先登录");
        }
        int i = followFanService.unfollowUser(map);
        if (i == 0){
            return new JsonResult("1","取消关注失败，服务器异常，请重试");
        }
        return new JsonResult("0","取消关注成功");
    }
    /*@end:关注热门达人未实现
    *@Date:19/10/4*/







    /*@关注页
    *@author:zxs
    *@Date:19/10/4
    * @Date:19/10/5
    *@description:社区关注页,
    * 1.发布帖子，图片上传尚未完善
    * 2.登录就展示金牌讲师，没登录就展示所有用户信息
    * 3.关注页面的最新发布，先从粉丝表查出所有关注的用户，再展示所有关注的用户的所有帖子按时间倒序排列。
    * */
    @ApiOperation(value = "社区关注-发布帖子-需要参数",notes = "用户必须已经登录过且themeUserId存在token中")
    @ApiModelProperty(value = "传递的字段应该为帖子标题，描述，图片地址，标签，以及当前时间和themeUserId")
    @RequestMapping(value = "/addTheme.do",method = RequestMethod.POST)
    public JsonResult addTheme(@RequestBody Map<String,Object>map){
        if (map.get("token") == null){
            return new JsonResult("1","还未登录，请先登录再查看我的关注列表");
        }
        JsonResult jsonResult = themeService.addTheme(map);
        return jsonResult;
    }

    @ApiOperation(value = "社区关注-推荐老师-需要参数",notes = "登录过就把themeUserId存token中我展示金牌讲师，没登录我给展示所有用户信息")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findGoldenUserForTch.do",method = RequestMethod.POST)
    public JsonResult findGoldenUserForTch(@RequestBody Map<String,Object>map){
        if (map.get("token") == null){
            List<User> allUserList = userService.findAllUser();
            return new JsonResult("0",allUserList);
        }
        List<User> goldenUserList = userService.getGoldenUserForTch();
        return new JsonResult("0",goldenUserList);
    }

    @ApiOperation(value = "社区关注-关注用户的最新发布-需要参数，",notes = "社区关注页面的，需要传入用户的token")
    @ApiModelProperty(value = "")
    @RequestMapping(value = "/findFollowUserTheme.do",method = RequestMethod.POST)
    public JsonResult findFollowUserTheme(@RequestBody Map<String,Object> map){
        List<User> userList = followFanService.findAllFollowUser(map);
        List<Theme> themeList = themeService.findAllFollowUserTheme(userList);
        return new JsonResult("0",themeList);
    }
    /*@end
    * */
}
