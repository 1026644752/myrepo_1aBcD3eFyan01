package com.yanchang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yanchang.mapper")
public class Yanchang03Application {

    public static void main(String[] args) {
        SpringApplication.run(Yanchang03Application.class, args);
    }

}
