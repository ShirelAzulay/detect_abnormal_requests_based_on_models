package com.salt.salt_detect_abnormal.repos;

import com.salt.salt_detect_abnormal.model.model_template.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;


@Configuration
public class StatefulMaps {

    @Bean
    public ConcurrentHashMap statefulMapAsDB() {
        return new ConcurrentHashMap<String, Model>();
    }

    @Bean
    public ConcurrentHashMap statefulMapQueryParams() {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Model.QueryParam>> mapOfMapsModelKeyToQueryParams = new ConcurrentHashMap<>();
        return mapOfMapsModelKeyToQueryParams;
    }

    @Bean
    public ConcurrentHashMap statefulMapHeaders() {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Model.Header>> mapOfMapsModelKeyToHeaders = new ConcurrentHashMap<>();
        return mapOfMapsModelKeyToHeaders;
    }


    @Bean
    public ConcurrentHashMap statefulMapBody() {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Model.Header>> mapOfMapsModelKeyToBody = new ConcurrentHashMap<>();
        return mapOfMapsModelKeyToBody;
    }

}
