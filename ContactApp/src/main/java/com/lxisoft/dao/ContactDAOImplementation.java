package com.lxisoft.dao;

import com.lxisoft.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImplementation implements ContactDAO{
    @Autowired
    SessionFactory sessionFactory;

    //private final JdbcTemplate jdbcTemplate;
    /*public  ContactDAOImplementation(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
    @Override
    public void saveContact(Contact contact) {
       /* try
        {
            jdbcTemplate.update("insert into contacts(name,number,email) values('"+contact.getName()+"','"+contact.getNumber()+"','"+contact.getEmail()+"')");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }

    @Override
    public List<Contact> getAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Contact> contactCriteriaQuery = criteriaBuilder.createQuery(Contact.class);
        Root<Contact> root = contactCriteriaQuery.from(Contact.class);
        contactCriteriaQuery.select(root);
        Query query = session.createQuery(contactCriteriaQuery);
        return query.getResultList();
    }

    @Override
    public int getNumberOfContacts() throws Exception {
    /*    int total = 0;
        String sql = "select count(*) from contacts";
        total = jdbcTemplate.queryForObject(sql,Integer.class);
        return total; */
        return 0;
    }

    @Override
    public void deleteContactByName(String name) {
        /*String sql = "delete from contacts where name=?";
        jdbcTemplate.update(sql,name);*/
    }

    @Override
    public List<Contact> getContactById(int sno) {
        /*List<Contact> contactDetails;
        String sql = "select * from contacts where sno = '"+sno+"'";
        contactDetails = jdbcTemplate.query(sql, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                Contact contact = new Contact();
                contact.setId(rs.getInt("sno"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                contact.setEmail(rs.getString("email"));
                return contact;
            }
        });
        return contactDetails; */
        return null;
    }

    @Override
    public void editContact(Contact contact) {
      /*  String sql = "update contacts set name = '"+contact.getName()+"', number ='"+contact.getNumber()+"', email='"+contact.getEmail()+"' where sno='"+contact.getId()+"'";
        jdbcTemplate.update(sql);*/
    }

    @Override
    public List<Contact> searchContactByName(String name,int start,int contactPerPage) {
        /*List<Contact> searchedList;
        String sql = "select SQL_CALC_FOUND_ROWS * from contacts where name like '%"+name+"%' order by name limit "+start+","+contactPerPage;
        searchedList = jdbcTemplate.query(sql, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                Contact contact = new Contact();
                contact.setId(rs.getInt("sno"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                contact.setEmail(rs.getString("email"));
                return contact;
            }
        });
        return searchedList;*/
        return null;
    }

    @Override
    public int getNumberOfSearchedContacts(String name) {
       /* int total = 0;
        String sql = "select count(*) from contacts where name like '%"+name+"%'";
        total = jdbcTemplate.queryForObject(sql,Integer.class);
        return total;*/
        return 0;
    }
}
