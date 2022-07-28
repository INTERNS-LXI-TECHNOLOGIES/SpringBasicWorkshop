package main.java.com.lxisoft.controller;

import main.java.com.lxisoft.entity.DictionaryUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<DictionaryUser> {

    @Override
    public DictionaryUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        DictionaryUser user = new DictionaryUser();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));


        return user;

    }
}



