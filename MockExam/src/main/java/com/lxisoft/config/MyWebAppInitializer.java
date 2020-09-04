package com.lxisoft.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.context.annotation.Bean;





import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]
                {
                       AppConfig.class
                };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]
                {
                        WebConfig.class
                };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]
                {
                        "/"
                };
    }
}