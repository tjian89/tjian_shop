package com.tjian;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.tjian.dao")
public class Product8011 {

    public static void main(String[] args) {
        new SpringApplication(Product8011.class).run(args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateInit(){
        return new RestTemplate();
    }
}
