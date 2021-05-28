package com.devandy.studypedia;

import com.devandy.studypedia.utils.InitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudyPediaApplication { // implements CommandLineRunner

//    @Autowired
//    private InitData initData;
//
//    @Override
//    public void run(String... args) throws Exception {
//        initData.injection();
//    }

    public static void main(String[] args) {
        SpringApplication.run(StudyPediaApplication.class, args);
    }

}
