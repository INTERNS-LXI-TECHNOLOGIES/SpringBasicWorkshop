package com.lxisoft.carshowroom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan(basePackages = "com.lxisoft.carshowroom")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}
