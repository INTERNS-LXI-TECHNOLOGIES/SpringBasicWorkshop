package main.java.com.lxisoft.service;

import main.java.com.lxisoft.dao.DictionaryDAO;
import main.java.com.lxisoft.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DictionaryServiceImpl  implements DictionaryService {

    @Autowired
    private DictionaryDAO dictionaryDAO;

    @Override
    @Transactional
    public List<Word> listAllWords() {
        return dictionaryDAO.listAllWords();
    }

    @Override
    @Transactional
    public void saveWord(Word word) {
        dictionaryDAO.saveWord(word);
    }

    @Override
    @Transactional
    public void deleteWord(int id) {
        dictionaryDAO.deleteWord(id);
    }

    @Override
    @Transactional
    public Word getWord(int id) {
        return dictionaryDAO.getWord(id);
    }

}
