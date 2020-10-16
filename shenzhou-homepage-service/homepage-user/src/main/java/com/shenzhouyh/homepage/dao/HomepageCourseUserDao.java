package com.shenzhouyh.homepage.dao;

import com.shenzhouyh.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description :
 * @since : 10.7.0
 */
public interface HomepageCourseUserDao extends JpaRepository<HomepageUserCourse, Long> {
    List<HomepageUserCourse> findAllByUserId(Long id);
}
