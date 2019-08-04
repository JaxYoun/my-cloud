package com.yang.springsecurityonly.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author: Yang
 * @date: 2019/8/5 00:35
 * @description: jdbc认证管理器，利用Spring-Security内置机制自动访问DB
 */
//@Configuration
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private DataSource dataSource;

    private static final String USER_SQL = "";
    private static final String ROLE_SQL = "";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //1.启用jdbc认证管理器
                .jdbcAuthentication()
                //2.设置密码加密器
                .passwordEncoder(new Pbkdf2PasswordEncoder("mySalt"))
                //3.设置数据源
                .dataSource(this.dataSource)
                //4.设置根据用户名查询用户sql
                .usersByUsernameQuery(USER_SQL)
                //5.设置根据用户名查询权限sql
                .authoritiesByUsernameQuery(ROLE_SQL);

    }

}
