package com.yang.mall.feign;

import com.yang.mall.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Yang
 * @date: 2019/7/27 16:07
 * @description:
 */
@FeignClient(name = "order-service")
public interface FeignInterface {

    /**
     * 根据id获取订单，此处声明的请求url描述的是【生产方】的url
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/order/get/{id}")
    Order getOrder(@PathVariable("id") String id);

}
