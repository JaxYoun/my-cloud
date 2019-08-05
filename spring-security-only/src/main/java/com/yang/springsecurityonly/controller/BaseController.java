package com.yang.springsecurityonly.controller;

import com.yang.springsecurityonly.config.security.SecurityUserUtil;
import com.yang.springsecurityonly.domain.po.UserDetail;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Yang
 * @date: 2019/8/5 22:25
 * @description:
 */
@Component
public class BaseController {

    /**
     * 获取当前用户
     *
     * @return
     */
    protected UserDetail getCurrentUser() {
        return SecurityUserUtil.getCurrentUser();
    }

    /**
     * 获取当前用户id
     *
     * @return
     */
    protected String getCurrentUserId() {
        UserDetail currentUser = this.getCurrentUser();
        if (currentUser != null) {
            return currentUser.getId();
        } else {
            return null;
        }
    }

    /**
     * 获取当前用户名
     *
     * @return
     */
    protected String getCurrentUserName() {
        UserDetail currentUser = this.getCurrentUser();
        if (currentUser != null) {
            return this.getCurrentUser().getName();
        } else {
            return null;
        }
    }

    /**
     * 判断当前用户是否登录
     *
     * @return
     */
    protected boolean isAuthenticated() {
        return SecurityUserUtil.isAuthenticated();
    }

    protected void doLogout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityUserUtil.getAuthentication());
        SecurityUserUtil.clearContext();
    }

}