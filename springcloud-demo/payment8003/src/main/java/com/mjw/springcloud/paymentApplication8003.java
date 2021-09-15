package com.mjw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class paymentApplication8003 {
    public static void main(String[] args){
        SpringApplication.run(paymentApplication8003.class,args);
    }
}
