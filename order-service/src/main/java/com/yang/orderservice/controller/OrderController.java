package com.yang.orderservice.controller;

import com.yang.orderservice.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 09:52
 * @description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Integer id) {
        Order order = new Order();
        order.setId("XXXXXXXXX");
        order.setName("kill bill");
        order.setCreateTime(new Date());
        return order;
    }

}
