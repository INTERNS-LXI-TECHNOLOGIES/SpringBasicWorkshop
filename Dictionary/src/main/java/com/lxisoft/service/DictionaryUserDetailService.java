package main.java.com.lxisoft.service;

import main.java.com.lxisoft.dao.DictionaryUserDAO;
import main.java.com.lxisoft.model.DictionaryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DictionaryUserDetailService implements UserDetailsService {

    @Autowired
    DictionaryUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final DictionaryUser dictionaryUser = userDAO.getUser(username);
        if (dictionaryUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(dictionaryUser.getUsername()).password(dictionaryUser.getPassword()).authorities(dictionaryUser.getRole()).build();
        return user;
    }
}
