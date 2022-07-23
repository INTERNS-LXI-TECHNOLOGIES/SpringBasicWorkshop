package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.model.DictionaryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DictionaryUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DictionaryUser getUser(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        DictionaryUser dictionaryUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<DictionaryUser>(DictionaryUser.class), new Object[] { username });
        return dictionaryUser;
    }
}

