package com.yang.springsecurityonly.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/8/5 00:52
 * @description: 用户自定义认证管理器
 */
@Configuration
public class CustomizedSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //1.启用自定义认证管理器，设置用户获取途径
                .userDetailsService(this.userDetailsService)
                //2.设置密码加密器
                .passwordEncoder(new Pbkdf2PasswordEncoder("mySalt"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //1.开启对请求的权限验证器
                .authorizeRequests()
                //2.对所有请求
                .anyRequest()
                //3.需要通过认证才可访问
                .authenticated()
                //4.使用Spring-Security内置的登录页面
                .and().formLogin()
                //5.启用浏览器的http基础认证
                .and().httpBasic();
    }

}
