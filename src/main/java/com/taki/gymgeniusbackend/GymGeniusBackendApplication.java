package com.taki.gymgeniusbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GymGeniusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymGeniusBackendApplication.class, args);
    }

    @GetMapping("/")
    public String sayHello() {
        return "server init";
    }
}
