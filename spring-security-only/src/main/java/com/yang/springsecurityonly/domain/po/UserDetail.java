package com.yang.springsecurityonly.domain.po;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author: Yang
 * @date: 2019/8/5 00:59
 * @description:
 */
public class UserDetail implements UserDetails {

    private User user;

    public UserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getRoleList().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        Date accountExpireTime = this.user.getAccountExpireTime();
        if (accountExpireTime == null) {
            return true;
        } else {
            return new Date().before(accountExpireTime);
        }
    }

    @Override
    public boolean isAccountNonLocked() {
        Integer unLocked = this.user.getUnLocked();
        if (unLocked == null) {
            return true;
        } else {
            return unLocked == 1;
        }
    }

    @Override
    public boolean isCredentialsNonExpired() {
        Date credentialExpireTime = this.user.getCredentialExpireTime();
        if (credentialExpireTime == null) {
            return true;
        } else {
            return new Date().before(credentialExpireTime);
        }
    }

    @Override
    public boolean isEnabled() {
        Integer enabled = this.user.getEnabled();
        if (enabled == null) {
            return true;
        } else {
            return enabled == 1;
        }
    }
}
