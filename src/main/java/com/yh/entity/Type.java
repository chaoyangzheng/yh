package com.yh.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 * 资源总类别
 */
@Component
public class Type implements Serializable {
    /**
     * 类别id
     */
    private Integer typeId;
    /**
     * 类别名称
     * 水彩，素描，彩铅，油画
     */
    private String typeName;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
