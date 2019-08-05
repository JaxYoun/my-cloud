package com.yang.springsecurityonly.config.security;

import com.yang.springsecurityonly.domain.po.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: Yang
 * @date: 2019/8/5 22:21
 * @description:
 */
public class SecurityUserUtil {

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static void clearContext() {
        SecurityContextHolder.clearContext();
    }

    public static UserDetail getCurrentUser() {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            return (UserDetail) authentication.getPrincipal();
        } else {
            return null;
        }
    }

    public static boolean isAuthenticated() {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            return getAuthentication().isAuthenticated();
        } else {
            return false;
        }
    }

}
