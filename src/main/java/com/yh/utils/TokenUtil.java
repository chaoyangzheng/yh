package com.yh.utils;

import sun.tools.jstat.Token;

import java.util.Date;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
public class TokenUtil {

    public String TokenProcessor(String user_id){

        String nowTime = new Date().toString();
        String token = MD5Utils.md5(user_id + nowTime).toUpperCase();
        return token;
    }








}
