package com.yh.mapper;

import com.yh.entity.Theme;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

public interface ThemeMapper {
    /*author:张栩生
      描述:为社区查询所有的帖子包含如下，四表联查按发布时间降序排列
      作用:  帖   子    表
          |        |         \
    自己属性  帖子类型表     用户表
                                |
                             用户类型
    * */
    public List<Theme> findAllTheme();

    /*author:张栩生
    描述：把获取到的userId当成themeUserId传到数据库，获取到标题，内容，图片，标签，以及当前添加时间
    作用：insert 发布一条帖子，添加到帖子表，
    参数:String themeUserId, String themeTitle, String themeInfo, String imgUrl, Integer typeId, Date uploadTime
    * */
    public void addTheme(Theme theme);

}
