package com.yang.fileservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: Yang
 * @date: 2019/7/30 23:04
 * @description:
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
    }

}
