package com.yang.springsecurityonly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Yang
 * @date: 2019/8/4 22:55
 * @description: 单/多级页面跳转
 * 下面的两个方法负责本业务模块下的页面跳转工作，即只要上级目录是/login，且没有匹配到其他方法，都会直接。
 * 1.首先，请求到来后，使用请求中的uri去匹配其他明确声明url的方法。
 * 2.如果所有明确声明uri的方法都无法成功匹配，就匹配到这个通配符方法。
 * 3.此通配符方法会将请求引导到请求uri对应的页面路径下。
 * 4.通配符分单级和多级，由于多级通配服从最左前缀原则，原则上不要重叠使用，否则达不到访问控制的目的。
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    /**
     * 【单级通配】：本模块下，error子模块下所有一级页面。
     */
    @GetMapping("/error/*")
    public void toErrorPage() {
    }

    /**
     * 【多级通配】：本模块下，error子模块下所有页面。
     */
    @GetMapping("/error/**")
    public void toAllErrorPage() {
    }

    /**
     * 【单级通配】：本模块下所有一级页面。
     */
    @GetMapping("/*")
    public void toAllSonPage() {
    }

    /**
     * 【多级通配】：本模块下所有页面。
     */
    @GetMapping("/**")
    public void toAllPage() {
    }

}
