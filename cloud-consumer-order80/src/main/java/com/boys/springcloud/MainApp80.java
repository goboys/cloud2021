package com.boys.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApp80 {

    public static void main(String[] args) {

        SpringApplication.run(MainApp80.class,args);

    }

}