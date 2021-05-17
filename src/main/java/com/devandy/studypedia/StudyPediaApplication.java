package com.devandy.studypedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudyPediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyPediaApplication.class, args);
    }

}
