package com.lxisoft.spring.dao;

import com.lxisoft.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ContactDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertContact(Contact contact ) {
        String sql = "INSERT INTO contact (name, email, address, phone) VALUES (?,?,?,?)";
        int result = jdbcTemplate.update(sql, new Object[] { contact .getName(), contact .getEmail(), contact .getAddress(),
                contact .getPhone()});
        boolean rowInserted = result > 0;
        return rowInserted;
    }

    public List<Contact > listAllContact() {
        String sql = "SELECT * FROM contact ";
        List<Contact > contactList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contact >(Contact .class));
        return contactList;
    }

    public boolean deleteContact(Contact  contact ) {
        String sql = "DELETE FROM contact  where contact_id = ?";
        int result = jdbcTemplate.update(sql, new Object[] {contact.getContact_id()});
        boolean rowDeleted = result > 0;
        return rowDeleted;
    }

    public boolean updateContact (Contact  contact ) {
        String sql = "UPDATE contact  SET name = ?, email = ?, address = ?, phone = ? WHERE contact_id = ?";
        int result = jdbcTemplate.update(sql, new Object[] { contact .getName(), contact .getEmail(), contact .getAddress(),
                contact .getPhone(), contact .getContact_id() });
        boolean rowUpdated = result > 0;
        return rowUpdated;
    }

    public Contact  getContact (int contact_id) {
        String sql = "SELECT * FROM contact  WHERE contact_id = ?";
        Contact  contact  = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), new Object[] {contact_id});
        return contact ;
    }
}
