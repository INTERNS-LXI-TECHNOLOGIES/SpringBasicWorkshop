package com.lxisoft.spring.dao;

import com.lxisoft.spring.entity.AppUser;

public interface AppUserDAO {
    AppUser getUser(String username);
    }

