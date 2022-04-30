package com.lxisoft.carshowroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.carshowroom.dao.CarDAO;
import com.lxisoft.carshowroom.entity.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDAO carDao;

	@Override
	@Transactional
	public List<Car> listAllCars() {
		return carDao.listAllCars();
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		carDao.saveCar(car);
	}

	@Override
	@Transactional
	public void deleteCar(int carId) {
		carDao.deleteCar(carId);
	}

	@Override
	@Transactional
	public Car getCar(int carId) {
		return carDao.getCar(carId);
	}

}
