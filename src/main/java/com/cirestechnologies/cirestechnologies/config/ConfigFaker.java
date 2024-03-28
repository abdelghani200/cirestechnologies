package com.cirestechnologies.cirestechnologies.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFaker {
    @Bean
    public Faker faker(){
        return new Faker();
    }
}
