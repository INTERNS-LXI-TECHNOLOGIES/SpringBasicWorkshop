package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.controller.UserRowMapper;
import main.java.com.lxisoft.model.DictionaryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DictionaryUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = Logger.getLogger(DictionaryUserDAO.class.getName());

    public DictionaryUser getUser(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        DictionaryUser dictionaryUser = jdbcTemplate.queryForObject(sql, new UserRowMapper(), new Object[] { username });
        LOGGER.info("wordList" + dictionaryUser);
        return dictionaryUser;
    }
}

