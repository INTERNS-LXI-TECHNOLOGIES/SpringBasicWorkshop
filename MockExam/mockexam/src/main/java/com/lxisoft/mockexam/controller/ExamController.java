package com.lxisoft.mockexam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.mockexam.model.Exam;
import com.lxisoft.mockexam.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@GetMapping(value = {"/","/home"})
	public String indexPage()
	{
		return "index";
	}
	
	@RequestMapping(value = "/admin")
	public String adminView()
	{
		return "admin";
	}
	
	@RequestMapping(value= "/introduction")
	public String introductionPage()
	{
		return "introduction";
		
	}
	
	@RequestMapping(value = "/getExamData", method = RequestMethod.GET)
	public ModelAndView startExam(HttpServletRequest request,HttpServletRequest response) 
	{
		HttpSession session = request.getSession();
		List<Exam> questionList = examService.getExamData();
		session.setAttribute("examdatas",questionList);
		ModelAndView model = new ModelAndView();
		model.addObject("examData",questionList);
		model.setViewName("questions");
		return model;
		
	}
	
	@RequestMapping(value = "/checkAnswer" ,method = RequestMethod.GET)
	public ModelAndView getAnswer(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession();
		ArrayList<String> answerList = new  ArrayList<String>();
		String answers = request.getParameter("ans");
		answerList.add(answers);
		ArrayList<String> aList = answerList;
		session.setAttribute("ansSelected",aList);
		return new ModelAndView("questions");
		
	}
	
	@RequestMapping(value = "/validateResult" ,method = RequestMethod.GET)
	public String viewResult(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		int mark = 0;
		HttpSession session = request.getSession();
		ArrayList<String> anslist = (ArrayList<String>)session.getAttribute("ansSelected");
		ArrayList<Exam> data = new  ArrayList<Exam>();
		data = (ArrayList<Exam>)session.getAttribute("examdatas");
		System.out.println(data.size());
		System.out.println(anslist.size());
		for (int x=0;x<data.size();x++) 
		{
			for (int y=0;y<anslist.size();y++) 
			{
				if(data.get(x).getAnswer().equals(anslist.get(y)))
				{
					mark ++;
				}				
			}		
		}
		System.out.println(mark);
		request.setAttribute("totalScore",mark);
		return "result";
	}
}
