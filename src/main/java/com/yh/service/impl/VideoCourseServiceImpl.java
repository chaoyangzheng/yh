package com.yh.service.impl;

import com.github.pagehelper.PageHelper;
import com.yh.entity.VideoCourse;
import com.yh.mapper.VideoCourseMapper;
import com.yh.service.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author SHIGUANGYI
 * @date 2019/9/30
 */
@Service
public class VideoCourseServiceImpl implements VideoCourseService {
    @Autowired
    private VideoCourseMapper videoCourseMapper;

    /**
     * @author SHIGUANGYI
     * @date 2019/9/30
     */
    @Override
    public VideoCourse findRandomVideoCourse() {
        //redis工具类暂无，暂时从mysql中查询最新10个视频课程
        List<VideoCourse> videoCourseList = videoCourseMapper.findLatestBasicVideoCourse();

        Random random = new Random();
        int index = random.nextInt(videoCourseList.size());
        return videoCourseList.get(index);
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public VideoCourse findHottestVideoCourse() {
        //redis工具类暂无，暂时从mysql中查询最热门视频课程
        VideoCourse videoCourse = videoCourseMapper.findHottestBasicVideoCourse();
        return videoCourse;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findComprehensiveVideoCourse(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findVideoCourseDefault();
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findHottestVideoCourse(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findVideoCourseHottest();
        return videoCourseList;
    }


}
