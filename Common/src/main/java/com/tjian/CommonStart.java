package com.tjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonStart {

    public static void main(String[] args) {
        new SpringApplication(CommonStart.class).run(args);
    }
}
