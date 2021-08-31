package com.lxisoft.configuration;

import com.lxisoft.repository.ContactRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ContactRepository getRepository(){
        return new ContactRepository();
    }
}
