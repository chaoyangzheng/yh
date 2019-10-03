package com.yh.mapper;

import com.yh.entity.Draft;
import com.yh.entity.Type;
import com.yh.entity.VideoCourse;

import java.util.List;


/**
 * 请后来修改者按照这个格式添加备注
 * 示例：为了第一次推送，未添加任何数据
 * @author chaoyang
 * @date 2019/9/29
 */



/**
 * 用户开始画功能
 * 对于草稿画作的添加，修改，删除
 * @author rongjing
 * @date 2019/9/30
 *
 */
public interface DraftMapper {


    /**
     * 开始画，未发表，添加至草稿箱
     * @param  draft
     * @result  void
     * @author rongjing
     */
    //开始画,未发表，添加至草稿
    public void addDraft(Draft draft);




    /**
     * 更新草稿内容，id不变，用户不变
     * @param  draft
     * @result  void
     *@author rongjing
     */
    //更新草稿
    public void updataDraft(Draft draft);



    /**
     * 删除草稿内容
     * @param  draft_id
     * @result  void
     *@author rongjing
     */
    //删除草稿，根据草稿id
    public  void deleteByDraftId(String draft_id);




    /**
     * 按照时间倒序排序
     *查看所有草稿默认
     * @result  List<Draft>
     *@author rongjing
     */

    //按照时间倒序排序
    //查看所有草稿默认
    public List<Draft> findAllDraft();


    /**
     * 按照时间倒序排序
     *查看所有草稿默认
     * @result  List<Draft>
     *@author rongjing
     */
    //根据草稿类型显示草稿
    public List<Draft> findByTypeId(Type type_id);



    /**
     * 点击图片进入课程选择
     *图片来自封面
     * @result  VideoCourse
     *@author rongjing
     */
    //图片视频链接
public VideoCourse findByVideoCourseImgUrl(String video_course_img_url);


}
