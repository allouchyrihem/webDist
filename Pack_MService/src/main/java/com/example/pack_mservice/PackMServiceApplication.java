package com.example.pack_mservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PackMServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackMServiceApplication.class, args);
    }

}
