package com.shenzhouyh.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description :
 * @since : 10.7.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseInfo {
    private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;

    public static CourseInfo invalid() {

        return new CourseInfo(-1L,
                "", "", "", "");
    }
}
