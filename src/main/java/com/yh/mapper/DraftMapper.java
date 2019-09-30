package com.yh.mapper;

import com.yh.entity.Draft;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chaoyang
 * @date 2019/9/30
 * 草稿接口
 */
@Repository
public interface DraftMapper {
    /**
     * 功能描述:查看某人所有的草稿
     * @author chaoyang
     * @date 2019/9/30
     * @param  userId  用户id
     * @return java.util.List<com.yh.entity.Draft>
     */
    public List<Draft> findAllDraft(String userId);
}
