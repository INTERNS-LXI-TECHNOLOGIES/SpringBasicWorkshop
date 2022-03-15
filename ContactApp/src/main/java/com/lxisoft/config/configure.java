package com.lxisoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public interface configure {
    void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception;
}
