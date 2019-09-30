package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
@Api("我的页面功能模块")
@RestController
@RequestMapping("/mine/")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 功能描述
     * @author chaoyang
     * @date 2019/9/30
     * @param  map
     * @return void
     */
    @ApiOperation(value="用户登录", notes="自动登录需要传送token，手机号/邮箱加密码不需要传递token")
    @ApiModelProperty(value = "传递的字段应该为'token'或者'password'和'loginCount',其中手机号或邮箱的值都要放到loginCount中")
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
            return new JsonResult("1","已存在");
        }
        return new JsonResult("0","可用");
    }


}
