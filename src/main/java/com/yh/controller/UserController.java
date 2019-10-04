package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.entity.User;
import com.yh.service.FollowFanService;
import com.yh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
@Api("我的页面功能模块")
@RestController
@RequestMapping("/mine")
public class UserController {

    @Autowired
    FollowFanService followFanService;

    @Autowired
    UserService userService;
    /**
     * 功能描述
     * @author chaoyang
     * @date 2019/9/30
     * @param  map
     * @return void
     */
    @ApiOperation(value="用户登录", notes="自动登录需要传送token，手机号/邮箱加密码不需要传递token；" +
            "传递的字段应该为'token'或者'password'和'loginCount',其中手机号或邮箱的值都要放到loginCount中")
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public JsonResult userLogin(@RequestBody Map<String,Object> map){
        if (map.get("token")==null&&map.get("password")==null){
            return new JsonResult("1","passwordNull");
        }
        String token = userService.login(map);
        if (token!=null){
            return new JsonResult("0",token);
        }
        return new JsonResult("1","error");
    }

    @ApiOperation(value="检查账户是否存在", notes="传递的数据名称：loginCount")
    @RequestMapping(value = "/checkPhoneOrEmail.do",method = RequestMethod.POST)
    public JsonResult checkPhoneOrEmail(@RequestBody Map<String,Object> map){
        boolean emailOrPhone = userService.findEmailOrPhone(map);
        if (emailOrPhone){
            return new JsonResult("1","error");
        }
        return new JsonResult("0","");
    }
    /**
     * 注册
     * @author chaoyang
     * @date 2019/10/3
     */
    @ApiOperation(value="用户注册", notes="手机号/邮箱加密码不需要传递token，" +
            "传递的字段应该为'password'和'loginCount',其中手机号或邮箱的值都要放到loginCount中")
    @RequestMapping(value = "/regedit.do",method = RequestMethod.POST)
    public JsonResult regedit(@RequestBody Map<String,Object> map){

        String token = userService.regedit(map);
        if (token!=null){
            return new JsonResult("0",token);
        }
        return new JsonResult("1","error");
    }
    /**
     * 查看我的关注数/粉丝数/收藏数（未实现）
     * @author chaoyang
     * @date 2019/10/3
     */
    @ApiOperation(value="查询用户的关注粉丝收藏", notes="只需要传入用户的token，返回该用户的关注粉丝收藏（收藏暂未上线）")
    @RequestMapping(value = "/followFan.do",method = RequestMethod.POST)
    public JsonResult findUserCount(@RequestBody Map<String,Object> map){
        Map countMap = followFanService.getUserFollowAndFanIdCount(map);
        if (countMap==null){
            return new JsonResult("1","用户数据异常");
        }
        List<String> follow = (List<String>) countMap.get("follow");
        countMap.put("follow",follow.size());
        List<String> fan = (List<String>) countMap.get("fan");
        countMap.put("fan",fan.size());
        return new JsonResult("0",countMap);
    }
    /**
     * 查看用户的关注
     * 查看用户的粉丝
     * @author chaoyang
     * @date 2019/10/4
     */
    @ApiOperation(value="查询用户的具体关注", notes="只需要传入用户的token，返回该用户的全部关注的人的全部信息")
    @RequestMapping(value = "/followUser.do",method = RequestMethod.POST)
    public JsonResult findFollowUser(@RequestBody Map<String,Object> map){
        List<User> allFollowUser = followFanService.findAllFollowUser(map);
        return new JsonResult("0",allFollowUser);
    }
    @ApiOperation(value="查询用户的具体粉丝", notes="只需要传入用户的token，返回该用户的全部粉丝的全部信息")
    @RequestMapping(value = "/fanUser.do",method = RequestMethod.POST)
    public JsonResult findFanUser(@RequestBody Map<String,Object> map){
        List<User> allFanUser = followFanService.findAllFanUser(map);
        return new JsonResult("0",allFanUser);
    }



}
