package com.yh.controller;

import com.yh.common.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
