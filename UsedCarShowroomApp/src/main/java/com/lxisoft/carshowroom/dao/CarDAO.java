package com.lxisoft.carshowroom.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.model.Car;

@Repository
public class CarDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertCar(Car car) throws SQLException {
		String sql = "INSERT INTO CAR (manufacturer, model, variant, year, total_kilometers, expected_price, other_details) VALUES (?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { car.getManufacturer(), car.getModel(), car.getVariant(),
				car.getYear(), car.getTotalKilometers(), car.getExpectedPrice(), car.getOtherDetails() });
		boolean rowInserted = result > 0;
		return rowInserted;
	}

	public List<Car> listAllCars() throws SQLException {
		String sql = "SELECT * FROM car";
		List<Car> carList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
		return carList;
	}

	public boolean deleteCar(Car car) throws SQLException {
		String sql = "DELETE FROM CAR where car_id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { car.getCarId() });
		boolean rowDeleted = result > 0;
		return rowDeleted;
	}

	public boolean updateCar(Car car) throws SQLException {
		String sql = "UPDATE CAR SET manufacturer = ?, model = ?, variant = ?, year = ?, total_kilometers = ?, expected_price = ?, other_details = ? WHERE car_id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { car.getManufacturer(), car.getModel(), car.getVariant(),
				car.getYear(), car.getTotalKilometers(), car.getExpectedPrice(), car.getOtherDetails(), car.getCarId() });
		boolean rowUpdated = result > 0;
		return rowUpdated;
	}

	public Car getCar(int carId) throws SQLException {
		String sql = "SELECT * FROM CAR WHERE car_id = ?";
		Car car = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class), new Object[] { carId });
		return car;
	}
}