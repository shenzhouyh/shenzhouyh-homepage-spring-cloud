package com.shenzhouyh.homepage.service;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.CourseInfosRequest;
import com.shenzhouyh.homepage.entity.HomepageCourse;

import java.util.List;

/**
 * @description :
 * @since : 10.7.0
 */
public interface ICourseService {
    /**
     * 通过课程ID获取课程信息
     *
     * @param id
     * @return
     */
    CourseInfo getById(Long id);

    /**
     * 根据课程ID的集合获取课程列表信息
     *
     * @param request
     * @return
     */
    List<HomepageCourse> getListByIds(CourseInfosRequest request);
}
