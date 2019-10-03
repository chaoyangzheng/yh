package com.yh.service.impl;

import com.yh.common.JsonResult;
import com.yh.entity.Theme;
import com.yh.mapper.ThemeMapper;
import com.yh.service.ThemeService;
import com.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ThemeServiceImpl implements ThemeService {

    /*@author:zxs
    * @Date:19/10/3*/
    @Autowired(required = false)
    ThemeMapper themeMapper;

    @Autowired
    UserService userService;

    JsonResult jsonResult = null;

    @Override
    public JsonResult findAllTheme() {
        List<Theme> themeList = themeMapper.findAllTheme();
        jsonResult.setCode("0");
        jsonResult.setInfo(themeList);
        return jsonResult;
    }

    @Override
    public JsonResult addTheme(Map<String,Object>map) {

        String userIdFromRedisToken = userService.getUserIdFromRedisToken((String) map.get("token"));
        Theme theme = new Theme();
        theme.setThemeTitle((String) map.get("themeTitle"));
        theme.setTypeId((Integer)map.get("typeId"));
        theme.setThemeInfo((String)map.get("themeInfo"));
        theme.setImgUrl((String)map.get("imgUrl"));
        theme.setThemeUserId(userIdFromRedisToken);
        theme.setUploadTime(new Date());
        int i = themeMapper.addTheme(theme);
        if (i==1){
            jsonResult.setCode("0");
            jsonResult.setInfo("添加成功");
            return jsonResult;
        }
        jsonResult.setCode("1");
        jsonResult.setInfo("添加失败,请重试");
        return jsonResult;
    }




    @Override
    public List<Theme> findThemeById(Integer typeId) {
        List<Theme> themeListById = themeMapper.findThemeById(typeId);
        return themeListById;
    }
}
