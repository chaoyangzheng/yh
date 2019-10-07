package com.yh.service.impl;

import com.yh.mapper.CollectionVideoMapper;
import com.yh.service.CollectionVideoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CollectionVideoServiceImpl implements CollectionVideoService {


    @Autowired
    private CollectionVideoMapper collectionVideoMapper;

    @Override
    public void insertVideoToCollection(String userId, String videoCourseId) {
        collectionVideoMapper.insertVideoToCollection(userId,videoCourseId);
    }
}
