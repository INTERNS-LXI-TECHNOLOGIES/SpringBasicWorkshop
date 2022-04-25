package com.lxisoft.carshowroom.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.model.CarUser;

@Repository
public class CarUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CarUser getUser(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";
		CarUser carUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<CarUser>(CarUser.class), new Object[] { username });
		return carUser;
	}
}
