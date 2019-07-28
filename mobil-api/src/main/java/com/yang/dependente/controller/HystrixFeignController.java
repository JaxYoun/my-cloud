package com.yang.dependente.controller;

import com.yang.dependente.domain.Point;
import com.yang.dependente.feign.HystrixFeignInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/7/27 20:07
 * @description:
 */
@RestController
@RequestMapping("/hystrixFeign")
public class HystrixFeignController {

    @Resource
    private HystrixFeignInterface hystrixFeignInterface;

    @GetMapping("/getPoint")
    public Point getPoint() {
        return this.hystrixFeignInterface.getOrderFallBack();
    }

}
