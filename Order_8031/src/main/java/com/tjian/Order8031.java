package com.tjian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.tjian.dao")
public class Order8031 {

    public static void main(String[] args) {
        new SpringApplication(Order8031.class).run(args);
    }
}
