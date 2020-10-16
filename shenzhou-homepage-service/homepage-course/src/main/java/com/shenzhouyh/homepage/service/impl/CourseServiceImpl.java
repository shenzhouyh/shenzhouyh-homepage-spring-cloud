package com.shenzhouyh.homepage.service.impl;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.CourseInfosRequest;
import com.shenzhouyh.homepage.dao.HomepageCourseDao;
import com.shenzhouyh.homepage.entity.HomepageCourse;
import com.shenzhouyh.homepage.service.ICourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description :
 * @since : 10.7.0
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private HomepageCourseDao courseDao;

    /**
     * 通过课程ID获取课程信息
     *
     * @param id
     * @return
     */
    @Override
    public CourseInfo getById(Long id) {
        Optional<HomepageCourse> course = courseDao.findById(id);
        HomepageCourse homepageCourse = course.orElse(HomepageCourse.invalid());
        CourseInfo courseInfo = new CourseInfo();
        BeanUtils.copyProperties(homepageCourse, courseInfo);
        return courseInfo;
    }

    /**
     * 根据课程ID的集合获取课程列表信息
     *
     * @param request
     * @return
     */
    @Override
    public List<HomepageCourse> getListByIds(CourseInfosRequest request) {
        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }
        List<HomepageCourse> allCourse = courseDao.findAllById(request.getIds());
        return allCourse.stream().map(course -> {
            HomepageCourse homepageCourse = new HomepageCourse();
            BeanUtils.copyProperties(course, homepageCourse);
            return homepageCourse;
        }).collect(Collectors.toList());
    }
}
