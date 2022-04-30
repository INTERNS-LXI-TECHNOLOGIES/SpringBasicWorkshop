package com.lxisoft.carshowroom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.CarUser;

@Repository
public class CarUserDAOImpl implements CarUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CarUser getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		CarUser carUser = currentSession.get(CarUser.class, username);
		return carUser;
	}

}
