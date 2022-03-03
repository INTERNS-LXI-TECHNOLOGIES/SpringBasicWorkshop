package com.lxisoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class applicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception{
        authBuilder.inMemoryAuthentication()
                .withUser("user1").password("{noop}user").authorities("user")
                .and()
                .withUser("admin1").password("{noop}admin").authorities("admin")
                .and()
                .withUser("controller").password("{noop}controller").authorities("admin","user")
        ;
    /*jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name,password from user where user_name = ?")
                .authoritiesByUsernameQuery("select user_name,user_role from user where user_name=?");*/
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/index.jsp").permitAll()
                .antMatchers("/view").authenticated()
                .antMatchers("/addNewContact").hasAuthority("admin")
                .antMatchers("/addContact").hasAuthority("admin")
                .antMatchers("/showContact").hasAuthority("admin")
                .antMatchers("/editContact").hasAuthority("admin")
                .antMatchers("/deleteContact").hasAuthority("admin")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
