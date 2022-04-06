package com.lxisoft.carshowroom.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lxisoft.carshowroom.dao.CarDAO;
import com.lxisoft.carshowroom.model.Car;

@Controller
public class CarController {

	@Autowired
	private CarDAO carDAO;

	@GetMapping("/")
	public String home(Model model) throws SQLException {
		List<Car> carList = carDAO.listAllCars();
		model.addAttribute("carList", carList);
		return "home";
	}

	@PostMapping("/insert")
	public String insertCar(@ModelAttribute Car car) throws SQLException {
		carDAO.insertCar(car);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String updateCar(@ModelAttribute Car car) throws SQLException {
		carDAO.updateCar(car);
		return "redirect:/";
	}

	@GetMapping("/create")
	public String createCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("action", "insert");
		return "createOrUpdateCar";
	}

	@GetMapping("/delete/{carId}")
	public String deleteCar(@PathVariable int carId) throws SQLException {
		Car car = new Car();
		car.setCarId(carId);
		carDAO.deleteCar(car);
		return "redirect:/";
	}

	@GetMapping("/edit/{carId}")
	public String editCar(@PathVariable int carId, Model model) throws SQLException {
		Car car = carDAO.getCar(carId);
		model.addAttribute("car", car);
		model.addAttribute("action", "update");
		return "createOrUpdateCar";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
