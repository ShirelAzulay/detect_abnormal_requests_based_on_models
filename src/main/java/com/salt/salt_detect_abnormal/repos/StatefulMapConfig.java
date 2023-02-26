package com.salt.salt_detect_abnormal.repos;

import com.salt.salt_detect_abnormal.model.model_template.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ConcurrentHashMap;


@Configuration
    public class StatefulMapConfig {

        @Bean
        public ConcurrentHashMap myStatefulMap() {
            return new ConcurrentHashMap<String, Model>();
        }
    }
