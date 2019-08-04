package com.yang.springsecurityonly.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Yang
 * @date: 2019/8/4 18:08
 * @description: 内存式认证管理器，用户及认证信息缓存于jvm内存中
 */
//@Configuration
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_PASSWORD = "$2a$11$nJN7uKnqFkKet5Fx6QfoZOTvAZYtvKTTb1pflMpl1tBDSMWHKAY1G";
    private static final String YANG_PASSWORD = "$2a$11$hNAzzGi6I4H5NHvKUP2V1ePGlr9mP6t7tASy2wbE.arMBu67tWv6a";

    /**
     * 配置认证管理器，主要包括用户-密码-角色
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //1.启用内存缓存式认证管理器
                .inMemoryAuthentication()
                //2.给认证管理器设置密码加密器
                .passwordEncoder(new BCryptPasswordEncoder(11))
                //3.注册一个用户[admin]
                .withUser("admin")
                .password(ADMIN_PASSWORD)
                .roles("ADMIN")
                //4.结束一个注册动作,再注册一个用户[yang]
                .and().withUser("yang")
                .password(YANG_PASSWORD)
                .roles("USER")
                .disabled(false)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false);
    }

}
