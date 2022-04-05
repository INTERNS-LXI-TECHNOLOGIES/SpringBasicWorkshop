package com.lxisoft.carshowroom.model;

public class Car {
	private int carId;
	private String manufacturer;
	private String model;
	private String variant;
	private int year;
	private int totalKilometers;
	private int expectedPrice;
	private String otherDetails;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTotalKilometers() {
		return totalKilometers;
	}

	public void setTotalKilometers(int totalKilometers) {
		this.totalKilometers = totalKilometers;
	}

	public int getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
}
