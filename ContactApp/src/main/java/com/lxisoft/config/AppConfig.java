package com.lxisoft.config;

import com.lxisoft.dao.ContactDAO;
import com.lxisoft.dao.ContactDAOImplementation;
import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.lxisoft.repository")
@ComponentScan({"com.lxisoft"})
//@PropertySource({"application.properties"})

public class AppConfig {
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactApp");
        dataSource.setUsername("root");
        dataSource.setPassword("abi@1003");
        return dataSource;
    }

    @Bean
    public ContactDAO contactDAO(){
        return new ContactDAOImplementation(getDataSource());
    }
}
