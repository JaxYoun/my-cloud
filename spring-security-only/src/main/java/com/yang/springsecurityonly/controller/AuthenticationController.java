package com.yang.springsecurityonly.controller;

import com.yang.springsecurityonly.domain.dto.AuthenticateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Yang
 * @date: 2019/8/5 22:46
 * @description:
 */
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController extends BaseController {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录，此过程涉及以下几个步骤：
     * 1.验证码对比
     * 2.认证
     * 3.权限获取，用户认证信息、权限缓存
     * 4.jwtToken生成
     *
     * @param dto
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticateDTO dto) {
        //1.验证码对比
        //2.认证
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
        //3.权限获取，用户登录信息缓存
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(dto.getName());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //4.jwtToken生成
        return null;
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        super.doLogout(request, response);
        return new ResponseEntity<>("logout success", HttpStatus.OK);
    }

    /**
     * 获取验证码
     *
     * @return
     */
    @PostMapping("/getCaptcha")
    public ResponseEntity<String> getCaptcha() {
        //cache the captcha
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
