package com.shenzhouyh.homepage.vo;

import com.shenzhouyh.homepage.CourseInfo;
import com.shenzhouyh.homepage.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @description :
 * @since : 10.7.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {
    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid() {

        return new UserCourseInfo(
                UserInfo.invalid(),
                Collections.emptyList()
        );
    }
}
