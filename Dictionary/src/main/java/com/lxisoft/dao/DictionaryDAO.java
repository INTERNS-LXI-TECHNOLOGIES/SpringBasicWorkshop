package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DictionaryDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean insertWord(Word word) throws SQLException {
        String sql = "INSERT INTO dictionary (Words, Meanings) VALUES (?,?)";
        int result = jdbcTemplate.update(sql, new Object[] { word.getName(),word.getMeaning() });
        boolean rowInserted = result > 0;
        return rowInserted;
    }

    public List<Word> listAllWords() throws SQLException {


        String sql = "SELECT * FROM dictionary";


        List<Word> wordList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Word>(Word.class));

        return wordList;
    }


    public boolean deleteWord(Word word) throws SQLException {
        String sql = "DELETE FROM dictionary where id = ?";

        int result = jdbcTemplate.update(sql, new Object[] { word.getId() });
        boolean rowDeleted = result > 0;
        return rowDeleted;
    }

    public boolean updateWord(Word word) throws SQLException {
        String sql = "UPDATE dictionary SET Words = ?, Meanings= ? WHERE id = ?";

        int result = jdbcTemplate.update(sql, new Object[] {word.getName(), word.getMeaning() });
        boolean rowUpdated = result > 0;
        return rowUpdated;
    }


    public Word getWord(int id) throws SQLException {

        String sql = "SELECT * FROM dictionary WHERE id = ?";

       Word word = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Word>(Word.class), new Object[] {id });

        return word;
    }
}

