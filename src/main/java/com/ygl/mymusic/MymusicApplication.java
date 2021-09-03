package com.ygl.mymusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ygl.mymusic.mapper")
@SpringBootApplication
public class MymusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymusicApplication.class, args);
    }

}
