package com.example.mikroserwisy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class MikroserwisyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikroserwisyApplication.class, args);
    }

}
