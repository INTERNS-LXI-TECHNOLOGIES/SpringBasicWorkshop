package com.lxisoft.spring.dao;

import com.lxisoft.spring.model.Contact;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class ContactDAOTest extends TestCase {
 private DriverManagerDataSource dataSource;
 private ContactDAO dao;

    public void testSave() {

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lxisoft");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dao = new ContactDAOImpl(dataSource);
        Contact contact = new Contact("sujith","sujith.k.a@lxisoft.com","hfjhggj","999999999999");
        int result = dao.save(contact);
        assertTrue(result >0);
    }

    public void testReturnContact() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lxisoft");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dao = new ContactDAOImpl(dataSource);
        Integer id = 1;
        Contact contact = dao.returnContact(id);
        assertNotNull(contact);
    }

    public void testUpdate() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lxisoft");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dao = new ContactDAOImpl(dataSource);
        Contact contact = new Contact(1,"sujithaa","sujith.k.a@alxisoft.com","hfjhggj","999999999999");
        int resul = dao.update(contact);
        assertTrue(resul >0);
    }

    public void testDelete() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lxisoft");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dao = new ContactDAOImpl(dataSource);
        Integer id =1;
        int result = dao.delete(id);
        assertTrue(result > 0);
    }

    public void testListContacts() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lxisoft");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dao = new ContactDAOImpl(dataSource);
        List<Contact> listContact = dao.listContacts();
        assertTrue(listContact.isEmpty());
    }
}