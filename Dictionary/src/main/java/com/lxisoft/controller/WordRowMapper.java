package main.java.com.lxisoft.controller;

import main.java.com.lxisoft.entity.Word;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordRowMapper implements RowMapper<Word> {

    @Override
    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {

        Word word = new Word();
        word.setId(rs.getInt("id"));
        word.setName(rs.getString("Words"));
        word.setMeaning(rs.getString("Meanings"));


        return word;

    }
}


