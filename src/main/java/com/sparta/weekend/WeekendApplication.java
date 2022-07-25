package com.sparta.weekend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WeekendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekendApplication.class, args);
    }

}
