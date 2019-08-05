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
public class UserDetail extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRoleList().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        Date accountExpireTime = super.getAccountExpireTime();
        if (accountExpireTime == null) {
            return true;
        } else {
            return new Date().before(accountExpireTime);
        }
    }

    @Override
    public boolean isAccountNonLocked() {
        Integer unLocked = super.getUnLocked();
        if (unLocked == null) {
            return true;
        } else {
            return unLocked == 1;
        }
    }

    @Override
    public boolean isCredentialsNonExpired() {
        Date credentialExpireTime = super.getCredentialExpireTime();
        if (credentialExpireTime == null) {
            return true;
        } else {
            return new Date().before(credentialExpireTime);
        }
    }

    @Override
    public boolean isEnabled() {
        Integer enabled = super.getEnabled();
        if (enabled == null) {
            return true;
        } else {
            return enabled == 1;
        }
    }
}
