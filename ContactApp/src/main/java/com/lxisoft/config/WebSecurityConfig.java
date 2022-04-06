package com.lxisoft.config;

import com.lxisoft.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception{
        return  authenticationManager();
    }
    /*@Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception{
        authBuilder.inMemoryAuthentication()
                .withUser("user1").password("{noop}user").authorities("user")
                .and()
                .withUser("admin1").password("{noop}admin").authorities("admin")
                .and()
                .withUser("controller").password("{noop}controller").authorities("admin","user")
        ;
       // authBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/index.jsp").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/view").authenticated()
                .antMatchers("/addNewContact").hasAuthority("ADMIN")
                .antMatchers("/addContact").hasAuthority("ADMIN")
                .antMatchers("/showContact").hasAuthority("ADMIN")
                .antMatchers("/editContact").hasAuthority("ADMIN")
                .antMatchers("/deleteContact").hasAuthority("ADMIN")
                .and()
                .formLogin().permitAll()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}
