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
    private JdbcTemplate jdbcTemplate;
    public  ContactDAOImplementation(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
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
        List<Contact> list = new ArrayList<Contact>();
        try {
            String sql = "select SQL_CALC_FOUND_ROWS * from contacts order by name limit " + start + "," + contactPerPage;
            list = jdbcTemplate.query(sql, new RowMapper<Contact>() {
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
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        return list;
    }

    @Override
    public void deleteContact(int sno) {

    }

    @Override
    public void getContactById(int sno) {

    }

    @Override
    public void editContact(int sno) {

    }
}
