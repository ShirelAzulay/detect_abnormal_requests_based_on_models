package com.salt.salt_detect_abnormal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.salt.salt_detect_abnormal.repos"})
public class SaltDetectAbnormalApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SaltDetectAbnormalApplication.class, args);
    }

}
