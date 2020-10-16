package com.shenzhouyh.homepage.client;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description : 通过 Feign 访问课程微服务
 * @since : 10.7.0
 */
@FeignClient(value = "eureka-client-homepage-course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {
    @RequestMapping(value = "/homepage-course/get/course",
            method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    @RequestMapping(value = "/homepage-course/get/courses")
    List<CourseInfo> getCourseList(@RequestBody CourseInfosRequest request);


}
