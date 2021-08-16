package com.lxisoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;

@Configuration
public class AppContext {
    @Autowired
    private Environment environment;

    @Bean
    public LocalStatelessSessionProxyFactoryBean sessionProxyFactoryBean(){
        LocalStatelessSessionProxyFactoryBean sessionProxyFactoryBean = new LocalStatelessSessionProxyFactoryBean();
        return sessionProxyFactoryBean;
    }
}
