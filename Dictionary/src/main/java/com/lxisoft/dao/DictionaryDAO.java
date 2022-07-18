package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.controller.WordRowMapper;
import main.java.com.lxisoft.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class DictionaryDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger LOGGER = Logger.getLogger(DictionaryDAO.class.getName());


    public List<Word> listAllWords() {


        String sql = "SELECT * FROM dictionary";


        List<Word> wordList = jdbcTemplate.query(sql, new WordRowMapper());
        LOGGER.info("wordList" + wordList);

        return wordList;
    }
    public boolean insertWord(Word word) throws SQLException {
        String sql = "INSERT INTO dictionary (Words, Meanings) VALUES (?,?)";
        int result = jdbcTemplate.update(sql, new Object[] { word.getName(),word.getMeaning() });

        boolean rowInserted = result > 0;
        return rowInserted;
    }




    public boolean deleteWord(Word word) throws SQLException {
        String sql = "DELETE FROM dictionary where id = ?";

        int result = jdbcTemplate.update(sql, new Object[] { word.getId() });
        boolean rowDeleted = result > 0;
        return rowDeleted;
    }

    public boolean updateWord(Word word) throws SQLException {
        String sql = "UPDATE dictionary SET Words = ?, Meanings= ? WHERE id = ?";

        int result = jdbcTemplate.update(sql, new Object[] {word.getName(), word.getMeaning(),word.getId() });
        boolean rowUpdated = result > 0;
        return rowUpdated;
    }


    public Word getWord(int id) throws SQLException {

        String sql = "SELECT * FROM dictionary WHERE id = ?";

       Word word = jdbcTemplate.queryForObject(sql, new  WordRowMapper(), new Object[] {id });

        return word;
    }

}

