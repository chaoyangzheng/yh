package com.yh.service.impl;

import com.yh.mapper.CollectionVideoMapper;
import com.yh.service.CollectionVideoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class CollectionVideoServiceImpl implements CollectionVideoService {


    @Autowired
    private CollectionVideoMapper collectionVideoMapper;


    /**
     *  收藏视频
     * @author rongjing
     *
     * 需要参数：用户id，视频id
     * @param userId
     *@param videoCourseId
     * @date 2019/10/07
     */
    @Override
    public void insertVideoToCollection(String userId, String videoCourseId) {

       String collectionVideoId = UUID.randomUUID().toString().replaceAll("-", "") + new Date().toString();

        collectionVideoMapper.insertVideoToCollection(userId,videoCourseId,collectionVideoId);
    }

    @Override
    public void deleteVideoToCollection(String userId, String videoCourseId) {

        collectionVideoMapper.deleteVideoToCollection(userId,videoCourseId);

    }
}
