package com.tjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Order8033 {

    public static void main(String[] args) {
        new SpringApplication(Order8033.class).run(args);
    }
}
