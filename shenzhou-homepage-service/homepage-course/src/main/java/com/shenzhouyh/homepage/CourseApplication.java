package com.shenzhouyh.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @description :
 * @since : 10.7.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class CourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }
}
