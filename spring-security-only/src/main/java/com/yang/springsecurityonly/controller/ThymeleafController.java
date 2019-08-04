package com.yang.springsecurityonly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Yang
 * @date: 2019/8/4 22:03
 * @description: 只要Controller中方法的请求
 */
@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public void thymeleaf() {
    }
}
