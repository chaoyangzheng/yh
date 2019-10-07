package com.yh.service.impl;

import com.yh.common.JsonResult;
import com.yh.entity.Theme;
import com.yh.entity.User;
import com.yh.mapper.ThemeMapper;
import com.yh.mapper.UserMapper;
import com.yh.service.FollowFanService;
import com.yh.service.ThemeService;
import com.yh.service.UserService;
import com.yh.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    FollowFanService followFanService;

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public JsonResult findAllTheme() {
        List<Theme> themeList = themeMapper.findAllTheme();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("0");
        jsonResult.setInfo(themeList);
        return jsonResult;
    }

    @Override
    public JsonResult addTheme(Map<String,Object>map,MultipartFile file) {
        String token = (String)map.get("token");
//        System.out.println("测试"+token);
        String id = userService.getUserIdFromRedisToken(token);
        System.out.println("进来了service:"+id);
        Theme theme = new Theme();
        theme.setThemeTitle((String) map.get("themeTitle"));
        theme.setTypeId((Integer)map.get("typeId"));
        theme.setThemeInfo((String)map.get("themeInfo"));
        UploadUtil uploadUtil = new UploadUtil();
        String imgUrl = uploadUtil.ImgUpload(file);
        theme.setImgUrl(imgUrl);
        theme.setThemeUserId(id);
        theme.setUploadTime(new Date());
        int i = themeMapper.addTheme(theme);
        JsonResult jsonResult = new JsonResult();
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

    @Override
    public List<Theme> findAllFollowUserTheme(List<User> userList) {
        List<Theme> themeList = themeMapper.findAllFollowUserTheme(userList);
        return themeList;
    }

    @Override
    public List<Theme> findHotSuperUserShowImgById() {
        List<User> userList = userMapper.findHotSuperUserId();
        List<Theme> showImgById = themeMapper.findHotSuperUserShowImgById(userList);
        return showImgById;
    }
}
