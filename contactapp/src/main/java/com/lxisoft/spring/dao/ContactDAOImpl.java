package com.lxisoft.spring.dao;

import com.lxisoft.spring.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDAOImpl implements ContactDAO{

    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate (Contact contact) {
        if (contact.getId() > 0) {
            // update
            String sql = "UPDATE contact SET name=?, email=?, address=?, "
                    + "phone=? WHERE contact_id=?";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
                    contact.getAddress(), contact.getPhone(), contact.getId());
        } else {
            // insert
            String sql = "INSERT INTO contact (name, email, address, phone)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
                    contact.getAddress(), contact.getPhone());
        }
    }

    @Override
    public void delete(int contactId) {
        String sql = "DELETE FROM contact WHERE contact_id=?";
        jdbcTemplate.update(sql, contactId);
    }

    @Override
    public Contact get(int contactId) {
        String sql = "SELECT * FROM contact WHERE id=" + contactId;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Contact.class));
    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT * FROM contact";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contact.class));

    }
}
