package main.java.com.lxisoft.dao;

import main.java.com.lxisoft.entity.DictionaryUser;
import org.springframework.stereotype.Component;

@Component
public interface DictionaryUserDAO {

    DictionaryUser getUser(String username);
}



