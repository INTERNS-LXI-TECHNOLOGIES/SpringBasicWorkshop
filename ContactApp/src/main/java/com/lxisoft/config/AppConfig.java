package com.lxisoft.config;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.lxisoft.repository")
@ComponentScan({"com.lxisoft"})
//@PropertySource({"application.properties"})

public class AppConfig {

}
