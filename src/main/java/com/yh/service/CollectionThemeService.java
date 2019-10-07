package com.yh.service;

public interface CollectionThemeService {

    /**
     *  收藏
     * 社区，收藏帖子
     * @author rongjing
     * @date 2019/10/05
     */



    //帖子收藏
    public void insertThemeToCollection(String userId,String themeId);


    //取消帖子收藏
    public void deleteThemeToCollection(String userId,String themeId);




}
