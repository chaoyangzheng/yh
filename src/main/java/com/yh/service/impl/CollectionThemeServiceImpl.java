package com.yh.service.impl;


import com.yh.mapper.CollectionThemeMapper;
import com.yh.service.CollectionThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class CollectionThemeServiceImpl implements CollectionThemeService {


    @Autowired(required = false)
    private CollectionThemeMapper collectionThemeMapper;

    /**
     *  收藏帖子
     * @author rongjing
     *
     * 需要参数：用户id，帖子id
     * @param userId
     *@param themeId
     * @date 2019/10/07
     */

    @Override
    public void insertThemeToCollection(String userId, String themeId) {


       String collectionThemeId = UUID.randomUUID().toString().replaceAll("-", "") + new Date().toString();


        collectionThemeMapper.insertThemeToCollection(userId,themeId,collectionThemeId);




    }

    @Override
    public void deleteThemeToCollection(String userId, String themeId) {

        collectionThemeMapper.deleteThemeToCollection(userId,themeId);
    }


}
