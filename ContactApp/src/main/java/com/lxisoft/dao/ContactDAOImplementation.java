package com.lxisoft.dao;

import com.lxisoft.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImplementation implements ContactDAO{
    private final JdbcTemplate jdbcTemplate;
    public  ContactDAOImplementation(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveContact(Contact contact) {
        try
        {
            jdbcTemplate.update("insert into contacts(name,number,email) values('"+contact.getName()+"','"+contact.getNumber()+"','"+contact.getEmail()+"')");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> getAllContacts(int start,int contactPerPage) {
        List<Contact> contactList;
        String sql = "select * from contacts order by name";
        contactList = jdbcTemplate.query(sql, new RowMapper<Contact>() {
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
        return contactList;
    }

    @Override
    public int getNumberOfContacts() {
        int total = 0;
        String sql = "select count(*) from contacts";

        return total;
    }

    @Override
    public void deleteContactByName(String name) {
        String sql = "delete from contact where name=?";
        jdbcTemplate.update(sql,name);
    }

    @Override
    public List<Contact> getContactById(int sno) {
        List<Contact> contactDetails;
        String sql = "select * from contacts order where sno = '"+sno+"'";
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
        return contactDetails;
    }

    @Override
    public void editContact(Contact contact) {
        String sql = "update contacts set name = '"+contact.getName()+"', number ='"+contact.getNumber()+"', email='"+contact.getEmail()+"' where sno='"+contact.getId()+"'";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Contact> searchContactByName(String name) {
        List<Contact> searchedList;
        String sql = "select * from contacts where name like '%"+name+"%' order by name";
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
        return searchedList;

    }

    @Override
    public int getNumberOfSearchedContacts() {
        return 0;
    }
}
