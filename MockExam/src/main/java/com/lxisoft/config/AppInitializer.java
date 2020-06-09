package com.lxisoft.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
            PersistenceJPAConfig.class
        };
        //return null;
    }

    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
            WebMvcConfigurer.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }
}