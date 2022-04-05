package com.lxisoft.carshowroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lxisoft.carshowroom.model.Car;

@Component
public class CarDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	@PostConstruct
    private void postConstruct() {
		this.jdbcURL = "jdbc:mysql://localhost:3306/carshowroom";
		this.jdbcUsername = "appUser";
		this.jdbcPassword = "123456";
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public boolean insertCar(Car car) throws SQLException {
		String sql = "INSERT INTO CAR (manufacturer, model, variant, year, total_kilometers, expected_price, other_details) VALUES (?,?,?,?,?,?,?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, car.getManufacturer());
		statement.setString(2, car.getModel());
		statement.setString(3, car.getVariant());
		statement.setInt(4, car.getYear());
		statement.setInt(5, car.getTotalKilometers());
		statement.setInt(6, car.getExpectedPrice());
		statement.setString(7, car.getOtherDetails());

		int result = statement.executeUpdate();
		boolean rowInserted = result > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<Car> listAllCars() throws SQLException {
		List<Car> carList = new ArrayList<>();

		String sql = "SELECT * FROM car";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int carId = resultSet.getInt("car_id");
			String manufacturer = resultSet.getString("manufacturer");
			String model = resultSet.getString("model");
			String variant = resultSet.getString("variant");
			int year = resultSet.getInt("year");
			int totalKilometers = resultSet.getInt("total_kilometers");
			int expectedPrice = resultSet.getInt("expected_price");
			String otherDetails = resultSet.getString("other_details");

			Car car = new Car();
			car.setCarId(carId);
			car.setManufacturer(manufacturer);
			car.setModel(model);
			car.setVariant(variant);
			car.setYear(year);
			car.setTotalKilometers(totalKilometers);
			car.setExpectedPrice(expectedPrice);
			car.setOtherDetails(otherDetails);
			carList.add(car);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return carList;
	}

	public boolean deleteCar(Car car) throws SQLException {
		String sql = "DELETE FROM CAR where car_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, car.getCarId());

		int result = statement.executeUpdate();
		boolean rowDeleted = result > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateCar(Car car) throws SQLException {
		String sql = "UPDATE CAR SET manufacturer = ?, model = ?, variant = ?, year = ?, total_kilometers = ?, expected_price = ?, other_details = ? WHERE car_id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, car.getManufacturer());
		statement.setString(2, car.getModel());
		statement.setString(3, car.getVariant());
		statement.setInt(4, car.getYear());
		statement.setInt(5, car.getTotalKilometers());
		statement.setInt(6, car.getExpectedPrice());
		statement.setString(7, car.getOtherDetails());
		statement.setInt(8, car.getCarId());

		int result = statement.executeUpdate();
		boolean rowUpdated = result > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public Car getCar(int carId) throws SQLException {
		Car car = null;
		String sql = "SELECT * FROM CAR WHERE car_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, carId);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String manufacturer = resultSet.getString("manufacturer");
			String model = resultSet.getString("model");
			String variant = resultSet.getString("variant");
			int year = resultSet.getInt("year");
			int totalKilometers = resultSet.getInt("total_kilometers");
			int expectedPrice = resultSet.getInt("expected_price");
			String otherDetails = resultSet.getString("other_details");

			car = new Car();
			car.setCarId(carId);
			car.setManufacturer(manufacturer);
			car.setModel(model);
			car.setVariant(variant);
			car.setYear(year);
			car.setTotalKilometers(totalKilometers);
			car.setExpectedPrice(expectedPrice);
			car.setOtherDetails(otherDetails);
		}

		resultSet.close();
		statement.close();

		return car;
	}
}
