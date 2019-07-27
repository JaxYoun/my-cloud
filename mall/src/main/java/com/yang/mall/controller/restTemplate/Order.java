package com.yang.mall.controller.restTemplate;

import lombok.Data;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 10:17
 * @description:
 */
@Data
public class Order {

    private String id;

    private String name;

    private Date createTime;

}
