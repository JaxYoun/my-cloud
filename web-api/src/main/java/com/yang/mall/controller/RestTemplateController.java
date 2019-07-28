package com.yang.mall.controller;

import com.yang.mall.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/7/27 10:10
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getOrder")
    public Order getOrder() {
        return this.restTemplate.getForObject("http://localhost:9090/order/get/99", Order.class);
    }

}
