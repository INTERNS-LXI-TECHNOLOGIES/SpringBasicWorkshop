package com.lxisoft.carshowroom.dao;

import java.util.List;

import com.lxisoft.carshowroom.entity.Car;

public interface CarDAO {

	List<Car> listAllCars();

	void saveCar(Car car);

	void deleteCar(int carId);

	Car getCar(int carId);

}
