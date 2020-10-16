package com.shenzhouyh.homepage.dao;

import com.shenzhouyh.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description :
 * @since : 10.7.0
 */
public interface HomepageUserDao extends JpaRepository<HomepageUser, Long> {
    HomepageUser findByUsername(String username);
}
