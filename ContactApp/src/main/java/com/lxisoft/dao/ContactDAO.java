package main.java.com.lxisoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import main.java.com.lxisoft.model.Contact;

@Repository
public class ContactDAO {
     
     @Autowired
	private JdbcTemplate jdbcTemplate;


     public boolean insertContact(Contact contact) {
		String sql = "INSERT INTO CONTACT (id, fname, lname, email, phn) VALUES (?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { contact.getId(), contact.getFirstName(), contact.getLastName(),
			contact.getEmail(), contact.getPhNumber() });
		boolean rowInserted = result > 0;
		return rowInserted;
	} 


	public Contact returnContact(int contactId) {
		String sql = "SELECT * FROM CONTACT WHERE id = ?";
		Contact contact = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), new Object[] { contactId });
		return contact;
	}
	public boolean updateContact(Contact contact) {
		String sql = "UPDATE CONTACT SET id = ?, fname = ?, lname = ?, email = ?, phn = ? WHERE id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { contact.getId(), contact.getFirstName(), contact.getLastName(),
			contact.getEmail(), contact.getPhNumber() });
		boolean rowUpdated = result > 0;
		return rowUpdated;
	}

	public boolean deleteContact(Contact contact) {
		String sql = "DELETE FROM CONTACT where id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { contact.getId() });
		boolean rowDeleted = result > 0;
		return rowDeleted;
	}


	public List<Contact> listAllContact() {
		String sql = "SELECT * FROM CONTACT";
		List<Contact> carList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
		return carList;
	}

}
