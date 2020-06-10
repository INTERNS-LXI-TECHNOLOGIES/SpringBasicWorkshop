package com.lxisoft.mockexamjavaconfig.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.mockexamjavaconfig.model.Exam;
import com.lxisoft.mockexamjavaconfig.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;
	
	private ArrayList<String> answerList = new  ArrayList<String>();
	

	@RequestMapping(value= "/introduction")
	public String introductionPage()
	{
		
		return "introduction";
		
	}
	@GetMapping(value = {"/","/home"})
	public String getAdminstration()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
								.anyMatch(r -> r.getAuthority().equals("ADMIN"));
		System.out.print(hasUserRole);
		if(hasUserRole)
		{
			return "admin";
		}
		else
		{
			return "introduction";
		}
		
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false)String logout)
	{
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username Or password!");
		}

		if (logout != null) {
			model.addObject("logout", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public ModelAndView adminView(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		List<Exam> questList = examService.getExamData();
		session.setAttribute("qList",questList);
		ModelAndView model = new ModelAndView();
		model.addObject("questList",questList);
		model.setViewName("admin");
		return model;
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
	
	@RequestMapping(value = "/add" ,method=RequestMethod.GET)
	public ModelAndView addQuestion(ModelAndView model)
	{
		Exam exam = new Exam();
		model.addObject("exam",exam);
		model.setViewName("add");
		return model;
	}
	
	@RequestMapping(value = "/addQuestion",method = RequestMethod.GET)
	public ModelAndView saveQuestion(@ModelAttribute Exam exam)
	{
		examService.addQuestion(exam);
		return new ModelAndView("redirect:/admin");
	}
	
	
	@RequestMapping(value = "/updateQuestion",method=RequestMethod.GET)
	public ModelAndView updateQuestion(HttpServletRequest request)
	{
		int qno = Integer.parseInt(request.getParameter("id"));
		Exam exam = examService.getExamById(qno);
		ModelAndView model = new ModelAndView();
		model.addObject("questById", exam);
		model.setViewName("update");
		return model;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Exam exam)
	{
		examService.updQuestion(exam);
		return new ModelAndView("redirect:/admin");
		
	}
	
	
	@RequestMapping(value="/deleteQuestion")
	public String deleteQuestion(HttpServletRequest request)
	{
		int qno = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("qId", qno);
		return "delete";
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request)
	{
		int qno = Integer.parseInt(request.getParameter("id"));
		examService.delQuestion(qno);
		return new ModelAndView("redirect:/admin");
		
	}
	
	
	@RequestMapping(value = "/checkAnswer" ,method = RequestMethod.GET)
	public ModelAndView getAnswer(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		if(answerList.size()==10)
		{
			answerList.clear();
			HttpSession session = request.getSession();		
			String answers = request.getParameter("ans");
			answerList.add(answers);
			System.out.println("answer ="+answerList.size());
			session.setAttribute("ansSelected",answerList);
		}
		else
		{
		HttpSession session = request.getSession();		
		String answers = request.getParameter("ans");
		answerList.add(answers);
		System.out.println("answer ="+answerList.size());
		session.setAttribute("ansSelected",answerList);
		}
		return new ModelAndView("questions");
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/validateResult" ,method = RequestMethod.GET)
	public String viewResult(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		int mark = 0;
		HttpSession session = request.getSession();
		ArrayList<String> anslist = new ArrayList<String>();
		System.out.println("before clear = "+anslist.size());
		
		anslist.clear();
		
		anslist	= (ArrayList<String>)session.getAttribute("ansSelected");
		
		ArrayList<Exam> data = new  ArrayList<Exam>();
		data = (ArrayList<Exam>)session.getAttribute("examdatas");
		
		System.out.println("examdata = "+data.size());
		
		System.out.println("After Clear = "+anslist.size());
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
		mark=0;
		return "result";
	}
	

	
		
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletRequest response)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/register")
	public String register()
	{
		return "register";
	}
}