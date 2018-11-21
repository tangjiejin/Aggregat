package com.jaden.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

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
