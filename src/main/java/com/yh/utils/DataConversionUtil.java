package com.yh.utils;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;

/**
 * 数据转换 工具类
 *  Json <--> Object
 * @author yuanzhe
 * @date 2019-10-03
 */
@Component
public class DataConversionUtil {

    /**
     * 将 object 转换为 Json
     * @param object
     * @return string
     */
    public String objTurnJson(Object object){
        Object json = JSONArray.toJSON(object);
        String string = json.toString();
        return string;
    }

    /**
     * 将 Json 转换为 object
     * 需要传想转的是哪种类型的参数
     * @param string Object
     * @return object
     */
    public Object JsonTurnObj(String string,Object o){

        Object object = JSONArray.parseObject(string, o.getClass());

        return object;
    }
}
