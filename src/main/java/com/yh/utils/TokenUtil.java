package com.yh.utils;

import java.util.Date;

/**
 * 接受 String 类型的 user_id
 * 返回 token 值
 * （约定：盐「当前时间」、生成的 token 英文全部大写）
 * @author yuanzhe
 * @date 2019/9/30
 */
public class TokenUtil {

    public String TokenProcessor(String user_id){

        String nowTime = new Date().toString();
        String token = MD5Utils.md5(user_id + nowTime).toUpperCase();
        return token;
    }
}
