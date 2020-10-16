package com.shenzhouyh.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @description :
 * @since : 10.7.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String username;
    private String email;

    /**
     * <h2>请求有效性验证</h2>
     */
    public boolean validate() {

        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(email);
    }
}
