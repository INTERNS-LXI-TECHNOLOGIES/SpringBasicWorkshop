package com.lxisoft.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.Doctor;
import com.lxisoft.repository.DatabaseRepo;

@Controller
public class DoctorController {


	@RequestMapping("/saveDoctor")
	public ModelAndView saveDoctor(@RequestParam("dname") String name, @RequestParam("departments") String department) 
	{
		 Doctor d = new Doctor();
		 DatabaseRepo db = new DatabaseRepo();

		d.setName(name);
		d.setDepartment(department);

		db.addDoctor(d);
		return new ModelAndView("redirect:/adminaction.jsp");

	}
	@RequestMapping("/updateDoctor")
	public ModelAndView updateDoctor(@RequestParam("dname") String name, @RequestParam("departments") String department, @RequestParam("id") int id)
	{
		Doctor d = new Doctor();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		DatabaseRepo db = new DatabaseRepo();
		doctors=db.getDoctorRecords();
		d.setName(name);
		d.setDepartment(department);		
		doctors.remove(id);
		doctors.add(id, d);
		db.updateDatabase(doctors);
		return new ModelAndView("redirect:/adminaction.jsp");
	}
	@RequestMapping("/deleteDoctor")
	public ModelAndView deleteDoctor(@RequestParam("id")int id)
	{
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		DatabaseRepo db = new DatabaseRepo();
		doctors=db.getDoctorRecords();
		doctors.remove(id);
		db.updateDatabase(doctors);
		return new ModelAndView("redirect:/adminaction.jsp");
	}

}