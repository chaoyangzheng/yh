package com.yh.common;

import org.springframework.stereotype.Component;

/**
 * 请后来修改者按照这个格式添加备注
 * 示例：第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */
@Component
public class JsonResult {
    /**
     * 属性描述
     * @author chaoyang
     * @date 2019/9/29
     * @param code 状态 0表示成功，其他表示异常，可自己定义
     * @param info 数据
     */
    private String code;
    private Object info;

    @Override
    public String toString () {
        return "JsonResult{" +
                "code='" + code + '\'' +
                ", info=" + info +
                '}';
    }

    public JsonResult () {
    }

    public JsonResult (String code, Object info) {
        this.code = code;
        this.info = info;
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public Object getInfo () {
        return info;
    }

    public void setInfo (Object info) {
        this.info = info;
    }
}
