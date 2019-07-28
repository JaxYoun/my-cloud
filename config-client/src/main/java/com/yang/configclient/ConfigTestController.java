package com.yang.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yang
 * @date: 2019/7/29 00:03
 * @description:
 */
@RestController
@RequestMapping("/config")
public class ConfigTestController {

    @Value("${ftp.server.host}")
    private String ftpServerHost;

    @GetMapping("/getFtpServerHost")
    public String getFtpServerHost() {
        return this.ftpServerHost;
    }

}
