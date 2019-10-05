package com.yh;

import com.yh.common.JsonResult;
import com.yh.entity.Theme;
import com.yh.entity.User;
import com.yh.mapper.ThemeMapper;
import com.yh.mapper.UserMapper;
import com.yh.service.ThemeService;
import com.yh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YhApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired(required = false)
    ThemeMapper themeMapper;

    @Autowired
    ThemeService themeService;

    @Test
    public void contextLoads() {

        List<Theme> allTheme = themeMapper.findAllTheme();
        for (Theme t: allTheme
             ) {
            System.out.println(t);
        }
    }

    @Test
    public void contextLoad1() {
        JsonResult allTheme = themeService.findAllTheme();
        List<Theme> info = (List<Theme>)allTheme.getInfo();
        for (Theme t: info
             ) {
            System.out.println(t);
        }
    }
    @Test
    public void contextLoad2() {
        List<User> hotSuperUserId = userMapper.findHotSuperUserId();
        List<User> hotSuperUserById = userMapper.findHotSuperUserById(hotSuperUserId);
        for (User u: hotSuperUserId
             ) {
            System.out.println(u);
        }
    }
    @Test
    public void contextLoad3() {
        List<User> hotSuperUserId = userMapper.findHotSuperUserId();
        for (User u:hotSuperUserId
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void contextLoad4() {
        List<Theme> showImgById = themeService.findHotSuperUserShowImgById();
        for (Theme t:showImgById
             ) {
            System.out.println(t);
        }
    }
    @Test
    public void contextLoad5() {
        List<Theme> themeById = themeMapper.findThemeById(1);
        for (Theme t:themeById
             ) {
            System.out.println(t);
        }
    }
}
