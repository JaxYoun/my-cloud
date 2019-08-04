package com.yang.springsecurityonly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: Yang
 * @date: 2019/8/4 19:07
 * @description: 内存式
 */
@Slf4j
@RestController
@RequestMapping("/memory")
public class InMemoryController {

    /**
     * 这是三种获取当前用户信息最优雅的一种
     *
     * @param principal
     * @return
     */
    @GetMapping("/principal")
    public ResponseEntity<String> principal(Principal principal) {
        return new ResponseEntity<>(principal.getName(), HttpStatus.OK);
    }

    /**
     * getAuthentication()方法可能会出现NPE
     *
     * @return
     */
    @GetMapping("/holder")
    public ResponseEntity<Object> holder() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }

    /**
     * getAuthentication()方法可能会出现NPE
     *
     * @return
     */
    @GetMapping("/auth")
    public ResponseEntity<Object> auth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(authentication, HttpStatus.OK);
    }

    @GetMapping("/log")
    public void log() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.error(authentication.getName());
        log.error(authentication.getAuthorities().toString());
    }


}
