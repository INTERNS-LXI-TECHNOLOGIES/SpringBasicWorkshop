package com.lxisoft.carshowroom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.Car;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CarDaoImpl implements CarDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Car> listAllCars() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Car> root = cq.from(Car.class);
		cq.select(root);
		Query<Car> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveCar(Car car) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(car);
	}

	@Override
	public void deleteCar(int carId) {
		Session session = sessionFactory.getCurrentSession();
		Car car = session.byId(Car.class).load(carId);
        session.delete(car);
	}

	@Override
	public Car getCar(int carId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Car car = currentSession.get(Car.class, carId);
        return car;
	}

}
