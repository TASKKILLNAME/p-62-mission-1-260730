package com.back.practicejsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PracticeJsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeJsbApplication.class, args);
    }

}
