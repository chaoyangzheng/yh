package com.yh.service.impl;


import com.yh.mapper.CollectionThemeMapper;
import com.yh.service.CollectionThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionThemeServiceImpl implements CollectionThemeService {


    @Autowired(required = false)
    private CollectionThemeMapper collectionThemeMapper;



    @Override
    public void insertThemeToCollection(String userId, String themeId) {

        collectionThemeMapper.insertThemeToCollection(userId,themeId);

    }




}
