package com.example.backblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackblogApplication.class, args);
    }

}
