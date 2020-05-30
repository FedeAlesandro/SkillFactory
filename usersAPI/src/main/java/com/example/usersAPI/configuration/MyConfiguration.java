package com.example.usersAPI.configuration;

import com.example.usersAPI.models.LogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public static LogService getLog(){
        return new LogService();
    }

}
