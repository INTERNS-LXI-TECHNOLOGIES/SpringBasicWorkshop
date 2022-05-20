package com.lxisoft.spring.dao;

import com.lxisoft.spring.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDAOImpl implements AppUserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public AppUser getUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        AppUser appUser = currentSession.get(AppUser.class, username);
        return appUser;
    }
}
