package com.lxisoft.config;

import com.lxisoft.dao.ContactDAO;
import com.lxisoft.dao.ContactDAOImplementation;
import com.lxisoft.service.ContactService;
import com.lxisoft.service.ContactServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.lxisoft.repository")
@ComponentScan({"com.lxisoft"})
@PropertySource({"classpath:application.properties"})

public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"com.lxisoft.model"});
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
        dataSource.setUrl(environment.getRequiredProperty("database.url"));
        dataSource.setUsername(environment.getRequiredProperty("database.user"));
        dataSource.setPassword(environment.getRequiredProperty("database.password"));
        return dataSource;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public ContactDAO contactDAO(){
        return new ContactDAOImplementation();
    }

    @Bean
    public ContactService contactService(){
        return new ContactServiceImplementation();
    }

}

