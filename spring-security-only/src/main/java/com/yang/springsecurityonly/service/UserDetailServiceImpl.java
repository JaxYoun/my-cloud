package com.yang.springsecurityonly.service;

import com.yang.springsecurityonly.domain.po.User;
import com.yang.springsecurityonly.domain.po.UserDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author: Yang
 * @date: 2019/8/5 00:54
 * @description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.convertUserToUserDetail(this.getUserByName(s));
    }

    private User getUserByName(String name) {
        User userFromCache = this.getUserFromCacheByName(name);
        if (userFromCache != null) {
            return userFromCache;
        } else {
            User userFromDb = this.getUserFromDbByName(name);
            if (userFromDb != null) {
                this.cacheUser(userFromDb);
                return userFromDb;
            } else {
                throw new UsernameNotFoundException("用户不存在！");
            }
        }
    }

    private User getUserFromCacheByName(String name) {
        User user = new User();
        user.setId("001");
        user.setName("yang");
        user.setPassword("320d8e1b5f86b15dee5c3d7b2b860700c0e980404ea9d2f552696d4e800f700666ef25b117621689");
        ArrayList<String> roleList = new ArrayList<>();
        roleList.add("user");
        user.setRoleList(roleList);
        return user;
    }

    private void cacheUser(User user) {
    }

    private User getUserFromDbByName(String name) {
        return null;
    }

    private UserDetails convertUserToUserDetail(User user) {
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(user, userDetail);
        return userDetail;
    }

}
