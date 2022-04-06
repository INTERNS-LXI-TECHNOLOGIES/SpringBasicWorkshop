package com.lxisoft.carshowroom.model;

public class Car {
	private Integer carId;
	private String manufacturer;
	private String model;
	private String variant;
	private Integer year;
	private Integer totalKilometers;
	private Integer expectedPrice;
	private String otherDetails;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getTotalKilometers() {
		return totalKilometers;
	}

	public void setTotalKilometers(Integer totalKilometers) {
		this.totalKilometers = totalKilometers;
	}

	public Integer getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Integer expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
}
