package com.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.yh.mapper")
public class YhApplication {

    public static void main (String[] args) {
        SpringApplication.run(YhApplication.class, args);
    }

}
