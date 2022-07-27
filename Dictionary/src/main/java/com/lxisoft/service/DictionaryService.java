package main.java.com.lxisoft.service;

import main.java.com.lxisoft.entity.Word;

import java.util.List;

public interface DictionaryService {

    List<Word> listAllWords();

    void saveWord(Word word);

    void deleteWord(int id);

    Word getWord(int id);

}
