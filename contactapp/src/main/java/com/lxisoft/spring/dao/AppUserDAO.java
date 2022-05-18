package com.lxisoft.spring.dao;

import com.lxisoft.spring.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class AppUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AppUser getUser(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        AppUser appUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AppUser>(AppUser.class), new Object[] { username });
        return appUser;
    }
}
