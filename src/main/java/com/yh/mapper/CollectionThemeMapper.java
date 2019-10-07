package com.yh.mapper;

public interface CollectionThemeMapper {
    /**
     * 收藏
     *收藏帖子
     * @param  userId (用户id) string
     * @param  themeId (帖子id) string
     *@author rongjing
     * @date 2019/10/07
     */

    //收藏帖子
    public void  insertThemeToCollection(String userId,String themeId,String collectionThemeId);


    //取消收藏帖子
    public void deleteThemeToCollection(String userId,String themeId);




}
