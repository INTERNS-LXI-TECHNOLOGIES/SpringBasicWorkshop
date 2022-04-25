package com.lxisoft.service;

import com.lxisoft.model.Role;
import com.lxisoft.model.User;

public interface UserService {
    void saveUser(User user, Role role);
    User findByUsername(String userName);
}
