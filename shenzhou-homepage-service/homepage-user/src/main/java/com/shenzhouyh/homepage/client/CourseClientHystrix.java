package com.shenzhouyh.homepage.client;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @description : 熔断降级策略，当feign调用失败的时候，
 * 会调用Hystrix中的同名方法作为兜底方案
 * @since : 10.7.0
 */
@Component
public class CourseClientHystrix implements CourseClient {
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseList(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
