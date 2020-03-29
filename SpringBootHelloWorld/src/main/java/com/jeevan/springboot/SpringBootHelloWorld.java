package com.jeevan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorld {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }
}