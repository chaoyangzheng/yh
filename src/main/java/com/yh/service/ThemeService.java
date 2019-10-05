package com.yh.service;

import com.yh.common.JsonResult;
import com.yh.entity.Theme;
import com.yh.entity.User;

import java.util.List;
import java.util.Map;

public interface ThemeService {
    /*author:zxs
      作用:前台获取到所有帖子信息，遍历在社区的发现页內。*/
    public JsonResult findAllTheme();

    /*author:zxs
    * 作用:社区内关注页面的'今天画了什么'功能。*/
    public JsonResult addTheme(Map<String,Object> map);

    /*author:zxs
    * 作用:社区内发现页按照不同类型的帖子查询*/
    public List<Theme> findThemeById(Integer typeId);

    /*author:zxs
    * 作用:社区内关注页页最新发布*/
    public List<Theme> findAllFollowUserTheme(List<User> userList);


    /*author:zxs
    * 作用:社区内发现页热门达人的作品*/
    public List<Theme> findHotSuperUserShowImgById();
}
