package com.shenzhouyh.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.shenzhouyh.homepage.UserInfo;
import com.shenzhouyh.homepage.service.IUserService;
import com.shenzhouyh.homepage.vo.CreateUserRequest;
import com.shenzhouyh.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description :
 * @since : 10.7.0
 */
@Slf4j
@RestController
public class HomepageUserController {
    private final IUserService userService;

    @Autowired
    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 127.0.0.1:9000/imooc/homepage-user/create/user
     */
    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {
        log.info("<homepage-user>: create user -> {}",
                JSON.toJSONString(request));
        return userService.createUserInfo(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {
        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {
        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
