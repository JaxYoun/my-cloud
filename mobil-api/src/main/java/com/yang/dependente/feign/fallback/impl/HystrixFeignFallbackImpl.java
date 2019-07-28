package com.yang.dependente.feign.fallback.impl;

import com.yang.dependente.domain.Point;
import com.yang.dependente.feign.HystrixFeignInterface;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 20:58
 * @description:
 */
@Component
public class HystrixFeignFallbackImpl implements HystrixFeignInterface {

    @Override
    public Point getOrderFallBack() {
        Point point = new Point();
        point.setId("hystrixFeignFallBack");
        point.setName("hystrixFeignFallBack");
        point.setCreateTime(new Date());
        return point;
    }
}
