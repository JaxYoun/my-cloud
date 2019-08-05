package com.yang.springsecurityonly.domain.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/8/5 01:00
 * @description: user po类
 */
@Data
public class User {

    private String id;

    private String name;

    private String password;

    private List<String> roleList;

    private List<String> permissionList;

    private List<String> menuList;

    private Date accountExpireTime;

    private Date credentialExpireTime;

    private Integer unLocked;

    private Integer enabled;

}
