package com.shenzhouyh.homepage.service;

import com.shenzhouyh.homepage.UserInfo;
import com.shenzhouyh.homepage.vo.CreateUserRequest;
import com.shenzhouyh.homepage.vo.UserCourseInfo;

/**
 * @description :
 * @since : 10.7.0
 */
public interface IUserService {
    /**
     * 创建用户
     *
     * @return
     */
    UserInfo createUserInfo(CreateUserRequest request);

    /**
     * <h2>根据 id 获取用户信息</h2>
     */
    UserInfo getUserInfo(Long id);

    /**
     * <h2>获取用户和课程信息</h2>
     */
    UserCourseInfo getUserCourseInfo(Long id);
}
