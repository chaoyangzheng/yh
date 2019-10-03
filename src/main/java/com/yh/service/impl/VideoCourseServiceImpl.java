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
    public VideoCourse findRandomSingleVideoCourse() {
        //redis工具类暂无，暂时从mysql中查询最新10个视频课程
        List<VideoCourse> videoCourseList = videoCourseMapper.findLatestSingleVideoCourse();

        Random random = new Random();
        int index = random.nextInt(videoCourseList.size());
        return videoCourseList.get(index);
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public VideoCourse findHottestSingleVideoCourse() {
        //redis工具类暂无，暂时从mysql中查询最热门视频课程
        VideoCourse videoCourse = videoCourseMapper.findHottestSingleVideoCourse();
        return videoCourse;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findComprehensiveVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findVideoCourseComprehensive(typeId);
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findHottestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findVideoCourseHottest(typeId);
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findLatestVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findVideoCourseLatest(typeId);
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findComprehensiveSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findSingleVideoCourseComprehensive(typeId);
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findHottestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findSingleVideoCourseHottest(typeId);
        return videoCourseList;
    }

    /**
     * @author SHIGUANGYI
     * @date 2019/10/3
     */
    @Override
    public List<VideoCourse> findLatestSingleVideoCourse(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<VideoCourse> videoCourseList = videoCourseMapper.findSingleVideoCourseLatest(typeId);
        return videoCourseList;
    }
}
