package com.example.bikeshopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BikeShopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BikeShopApiApplication.class, args);
    }
}
