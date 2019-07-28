package com.yang.dependente.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 20:26
 * @description:
 */
@Data
public class Point {

    private String id;

    private String name;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
