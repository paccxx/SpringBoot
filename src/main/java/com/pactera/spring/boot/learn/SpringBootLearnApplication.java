package com.pactera.spring.boot.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pactera.spring.boot.learn.mapper")
public class SpringBootLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearnApplication.class, args);
    }
}
