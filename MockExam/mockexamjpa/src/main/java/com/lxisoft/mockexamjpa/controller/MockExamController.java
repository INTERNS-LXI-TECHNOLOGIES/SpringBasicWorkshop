package com.lxisoft.mockexamjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MockExamController 
{
	@RequestMapping(value="/")
	public String index()
	{
		return "index";
	}
}
