package com.yang.mall.controller;

import com.yang.mall.domain.Order;
import com.yang.mall.feign.FeignInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/7/27 16:15
 * @description:
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private FeignInterface feignInterface;

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable("id") String id) {
        return this.feignInterface.getOrder(id);
    }

}
