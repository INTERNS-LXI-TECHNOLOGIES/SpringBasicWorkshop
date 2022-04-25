package com.lxisoft.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lxisoft.carshowroom.dao.CarUserDAO;
import com.lxisoft.carshowroom.model.CarUser;

@Service
public class CarUserDetailService implements UserDetailsService {

	@Autowired
	CarUserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final CarUser carUser = userDAO.getUser(username);
		if (carUser == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails user = User.withUsername(carUser.getUsername()).password(carUser.getPassword()).authorities(carUser.getRole()).build();
		return user;
	}
}