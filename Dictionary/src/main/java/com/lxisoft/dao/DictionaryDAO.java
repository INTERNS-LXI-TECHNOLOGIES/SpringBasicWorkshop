package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.entity.Word;

import java.util.List;

public interface DictionaryDAO {

    List<Word> listAllWords();

    void saveWord(Word word);

    void deleteWord(int id);

    Word getWord(int id);

}
