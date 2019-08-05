package com.yang.springsecurityonly.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/8/6 22:12
 * @description: 实际的-用户自定义认证管理器
 */
@Configuration
public class MyCustomizedSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 配置用户认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //1.启用自定义认证管理器，设置用户获取途径
                .userDetailsService(this.userDetailsService)
                //2.设置密码加密器
                .passwordEncoder(new Pbkdf2PasswordEncoder("mySalt"));
    }

    /**
     * 用于配置请求权限拦截
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        registry.antMatchers("/admin/**").hasAnyRole("admin");
        registry.antMatchers("/order/**").hasAnyRole("user");
        registry.and().formLogin().and().httpBasic();
    }

    /**
     * 用于配置过滤器链
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET, "/favicon.ico", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js");
    }
}
