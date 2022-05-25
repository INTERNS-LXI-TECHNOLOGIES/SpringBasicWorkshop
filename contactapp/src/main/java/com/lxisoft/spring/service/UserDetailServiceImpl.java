package com.lxisoft.spring.service;

import com.lxisoft.spring.entity.AppUser;
import com.lxisoft.spring.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUser appUser = appRepo.findById(username).orElse(null);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(appUser.getUsername()).password(appUser.getPassword()).authorities(appUser.getRole()).build();
        return user;
    }
}
