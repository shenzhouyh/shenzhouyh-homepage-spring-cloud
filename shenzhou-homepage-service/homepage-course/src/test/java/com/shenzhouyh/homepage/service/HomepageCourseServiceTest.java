package com.shenzhouyh.homepage.service;

import com.alibaba.fastjson.JSON;
import com.shenzhouyh.homepage.Application;
import com.shenzhouyh.homepage.dao.HomepageCourseDao;
import com.shenzhouyh.homepage.entity.HomepageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @description :
 * @since : 10.7.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {
    @Autowired
    private HomepageCourseDao courseDao;

    @Autowired
    private ICourseService courseService;

    @Test
    public void testCreateCourseInfo() {

        HomepageCourse course1 = new HomepageCourse(
                "JDK11&12 新特性解读",
                0,
                "https://www.imooc.com",
                "解读 JDK11 和 JDK12 的新版本特性"
        );
        HomepageCourse course2 = new HomepageCourse(
                "基于 SpringCloud 微服务架构 广告系统设计与实现",
                1,
                "https://www.imooc.com",
                "广告系统的设计与实现"
        );
        System.out.println(courseDao.saveAll(
                Arrays.asList(course1, course2)
        ).size());
    }

    //@Test
    public void testGetCourseInfo() {

        System.out.println(JSON.toJSONString(
                courseService.getById(6L)
        ));
        System.out.println(JSON.toJSONString(
                courseService.getById(8L)
        ));
    }

}
