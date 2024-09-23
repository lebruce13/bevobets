package com.lebruce.bevobets.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lebruce.bevobets")
public class BevobetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BevobetsApplication.class, args);
    }

}
