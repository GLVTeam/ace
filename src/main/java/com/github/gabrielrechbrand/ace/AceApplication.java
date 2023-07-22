package com.github.gabrielrechbrand.ace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AceApplication.class, args);
    }

}
