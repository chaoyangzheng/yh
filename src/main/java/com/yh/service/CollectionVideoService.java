package com.yh.service;



/**
 *  收藏
 * 遇见页面，收藏视频课程封面（间接收藏视频）
 * @author rongjing
 * @date 2019/10/05
 */
public interface CollectionVideoService {



    //视频收藏
    public void insertVideoToCollection(String useId,String videoCourseId);
}
