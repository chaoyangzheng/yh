package com.yh.controller;

import com.yh.common.JsonResult;
import com.yh.service.UserService;
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
@RestController
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 功能描述
     * @author chaoyang
     * @date 2019/9/30
     * @param  * @param map
     * @return void
     */
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
    /**
     * 功能描述
     * @author chaoyang
     * @date 2019/9/30
     * 我的模块：
     */
    @RequestMapping("/myDraft.do")
    public JsonResult findMyDraft(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return new JsonResult("0",null);
    }


}
