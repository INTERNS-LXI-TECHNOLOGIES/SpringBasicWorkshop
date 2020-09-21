package com.lxisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.Patient;
import com.lxisoft.repository.DatabaseRepo;

@Controller
public class PatientAction 
{
	@RequestMapping("/savePatient")
	public ModelAndView saveUser(@RequestParam("pname") String name, @RequestParam("pnum") String number , @RequestParam("pdoctor") String doctorName , @RequestParam("paddress") String address)
	{
		Patient p = new Patient();
		DatabaseRepo db = new DatabaseRepo();
		p.setName(name);
		p.setPhoneNumber(number);
		p.setAddress(address);
		p.setDoctorName(doctorName);
		
		db.addPatient(p);
		
		
		return new ModelAndView("redirect:/homepage.jsp");
		
	}

}
