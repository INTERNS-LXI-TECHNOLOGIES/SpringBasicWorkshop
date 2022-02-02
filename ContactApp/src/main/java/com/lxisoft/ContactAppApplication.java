package com.lxisoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ContactAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactAppApplication.class,args);
    }
}
