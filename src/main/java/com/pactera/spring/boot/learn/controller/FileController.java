package com.pactera.spring.boot.learn.controller;

import com.pactera.spring.boot.learn.common.MinioTemplate;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Resource
    MinioTemplate minioTemplate;

    /**
     * 长传头像
     *
     * @return {@link String} 图片链接
     */
    @PostMapping("uploadAvatar")
    public String uploadAvatar(@RequestParam("file") MultipartFile file) throws Exception {
        return minioTemplate.putObject(file.getInputStream(), file.getContentType());
    }

}