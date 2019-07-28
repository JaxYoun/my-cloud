package com.yang.dependente.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yang.dependente.domain.Order;
import com.yang.dependente.feign.FeignInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 19:16
 * @description:
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Resource
    private FeignInterface feignInterface;

    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "4"),
            @HystrixProperty(name = "maxQueueSize", value = "10")})
    @GetMapping("/getOrder")
    public Order getOrder() {
        return this.feignInterface.getOrder("9");
    }

    public Order fallBack() {
        Order order = new Order();
        order.setId("hystrixFallBack");
        order.setName("hystrixFallBack");
        order.setCreateTime(new Date());
        return order;
    }

}
