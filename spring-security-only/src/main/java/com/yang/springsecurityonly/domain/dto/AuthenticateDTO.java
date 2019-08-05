package com.yang.springsecurityonly.domain.dto;

import lombok.Data;

/**
 * @author: Yang
 * @date: 2019/8/5 22:47
 * @description:
 */
@Data
public class AuthenticateDTO {

    private String name;

    private String password;

    private String code;

}
