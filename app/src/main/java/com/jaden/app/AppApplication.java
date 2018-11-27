package com.jaden.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

@EnableDiscoveryClient
@SpringBootApplication
public class AppApplication {

    @GetMapping("/")
    public String index(){
        return "static/index.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
