package com.lxisoft.mockexamjavaconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception
	{
		auth.inMemoryAuthentication().withUser("rahul").password(passwordEncoder.encode("user")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("s3cr3t")).roles("USER","ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/","introduction").access("hasRole('ADMIN') or hasRole('USER')")
			.antMatchers("/admin").access("hasRole('ADMIN')")
			.antMatchers("/introduction").access("hasRole('ADMIN') or hasRole('USER')")
			.and().formLogin().loginPage("/login")
			.and()
			.httpBasic()
			.and()
			.logout()
			.logoutUrl("/j_spring_security_logout")
			.logoutSuccessUrl("/");
	}
}
