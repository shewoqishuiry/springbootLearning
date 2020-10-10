package com.example.builddream.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryMyself {

    @Bean
    @ConfigurationProperties(prefix = "personinfo")
    public GetPersonInfoProperties getPersonInfoProperties(){
        return new GetPersonInfoProperties();
    }

}
