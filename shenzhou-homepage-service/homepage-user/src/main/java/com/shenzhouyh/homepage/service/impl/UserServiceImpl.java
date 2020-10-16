package com.shenzhouyh.homepage.service.impl;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.CourseInfosRequest;
import com.shenzhouyh.homepage.UserInfo;
import com.shenzhouyh.homepage.client.CourseClient;
import com.shenzhouyh.homepage.dao.HomepageCourseUserDao;
import com.shenzhouyh.homepage.dao.HomepageUserDao;
import com.shenzhouyh.homepage.entity.HomepageUser;
import com.shenzhouyh.homepage.entity.HomepageUserCourse;
import com.shenzhouyh.homepage.service.IUserService;
import com.shenzhouyh.homepage.vo.CreateUserRequest;
import com.shenzhouyh.homepage.vo.UserCourseInfo;
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
public class UserServiceImpl implements IUserService {
    private final HomepageUserDao homepageUserDao;
    private final HomepageCourseUserDao homepageUserCourseDao;
    private final CourseClient courseClient;

    @Autowired
    public UserServiceImpl(HomepageUserDao homepageUserDao,
                           HomepageCourseUserDao homepageUserCourseDao,
                           CourseClient courseClient) {
        this.homepageUserDao = homepageUserDao;
        this.homepageUserCourseDao = homepageUserCourseDao;
        this.courseClient = courseClient;
    }

    /**
     * 创建用户
     *
     * @param request
     * @return
     */
    @Override
    public UserInfo createUserInfo(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }
        //根据用户名校验当前用户是否存在
        HomepageUser oldUser = homepageUserDao.findByUsername(
                request.getUsername());
        HomepageUser homepageUser = new HomepageUser();
        homepageUser.setUsername(request.getUsername());
        homepageUser.setEmail(request.getEmail());
        HomepageUser newUser = homepageUserDao.save(homepageUser);
        return new UserInfo(newUser.getId(),
                newUser.getUsername(), newUser.getEmail());
    }

    /**
     * <h2>根据 id 获取用户信息</h2>
     *
     * @param id
     */
    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        HomepageUser curUser = user.get();

        return new UserInfo(curUser.getId(),
                curUser.getUsername(), curUser.getEmail());
    }

    /**
     * <h2>获取用户和课程信息</h2>
     *
     * @param id
     */
    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }

        HomepageUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(),
                homepageUser.getUsername(), homepageUser.getEmail());

        List<HomepageUserCourse> userCourses =
                homepageUserCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseList(
                new CourseInfosRequest(userCourses.stream()
                        .map(HomepageUserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
