package com.yh.mapper;





public interface CollectionVideoMapper {


    /**
     * 收藏
     *收藏视频
     * @param userId (用户id) string
     * @param  videoCourseId (视频id) string
     *  @param  collectionVideoId (视频id) string
     *@author rongjing
     * @date 2019/10/07
     */


    //收藏视频
    public void  insertVideoToCollection(String userId,String videoCourseId,String collectionVideoId);



    //取消收藏视频
    public void  deleteVideoToCollection(String userId,String videoCourseId);
}
