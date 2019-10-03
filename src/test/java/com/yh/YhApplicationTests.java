package com.yh;

import com.yh.entity.VideoCourse;
import com.yh.service.DraftService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YhApplicationTests {
    @Autowired
    private DraftService DraftService;


    /**
     * 测试Draft,有问题，待纠正
     *
     * @author rongjing
     * @date 2019/10/03
     */

    @Test
    public void contextLoads() {


        VideoCourse course = DraftService.findByVideoCourseId("2");

        System.out.println(course.getVideoInfo());


    }

}
