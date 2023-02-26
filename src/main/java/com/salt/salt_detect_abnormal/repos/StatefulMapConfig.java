package com.salt.salt_detect_abnormal.repos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


    @Configuration
    public class StatefulMapConfig {

        @Bean
        public ConcurrentMap<String, String> myStatefulMap() {
            return new ConcurrentHashMap<>();
        }
    }
