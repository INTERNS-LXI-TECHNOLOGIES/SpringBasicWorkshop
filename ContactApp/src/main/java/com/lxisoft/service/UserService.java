package com.lxisoft.service;

import com.lxisoft.model.User;

public interface UserService {
    void saveUser(User user);
    User findByUserName(String userName);
}
