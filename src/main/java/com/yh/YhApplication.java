package com.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yh.mapper")
public class YhApplication {

    public static void main (String[] args) {
        SpringApplication.run(YhApplication.class, args);
    }

}
