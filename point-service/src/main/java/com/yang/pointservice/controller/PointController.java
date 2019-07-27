package com.yang.pointservice.controller;

import com.yang.pointservice.domain.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 20:30
 * @description:
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @GetMapping("/getPoint")
    public Point getPoint() {
        Point point = new Point();
        point.setId("XXXXXXX");
        point.setName("OOOOOO");
        point.setCreateTime(new Date());
        return point;
    }

}
