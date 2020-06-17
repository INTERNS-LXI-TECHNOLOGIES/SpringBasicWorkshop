package com.lxisoft.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.entity.ExamModel;
import com.lxisoft.service.ExamServiceImpl;


@Controller
public class ExamController {
	
	
	@Autowired
	private ExamServiceImpl examService;

	
	@RequestMapping(value = "/",method = RequestMethod.GET)
 	public String indexPage(){
 	return "Instruction";
 	}
	
	@RequestMapping(value = "/firstpage")
	public ModelAndView listExam(ModelAndView model) throws IOException {
		List<ExamModel> listExam = examService.getAllExams();
		model.addObject("listExam", listExam);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newQuestion(ModelAndView model) {
		ExamModel examModel = new ExamModel();
		model.addObject("examModel", examModel);
		model.setViewName("ExamForm");
		return model;
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public String saveExam(@ModelAttribute ExamModel examModel) {
		if (examModel.getId() == 0) { 
			examService.addExam(examModel);
		} else {
			//examService.updateExam(examModel);
		}
		return ("Succes");
	}
	
	
	
	
	 @RequestMapping(value = "/deleteExam", method = RequestMethod.GET) public
	 String deleteExam(HttpServletRequest request) { int examId =
	 Integer.parseInt(request.getParameter("id")); examService.deleteExam(examId);
	 return ("DeleteSucces"); }
	
	 
	 
	/* @RequestMapping(value = "/deleteConfirmation", method = RequestMethod.GET)
	 * public String deletePage(HttpServletRequest request) { int examId =
	 * Integer.parseInt(request.getParameter("id")); examService.deleteExam(examId);
	 * return ("DeleteConfirmation"); }
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/userPage", method = RequestMethod.GET) public
	 * ModelAndView displayInstruction(HttpServletRequest request) { return new
	 * ModelAndView("Instruction"); }
	 * 
	 * 
	 * @RequestMapping(value = "/startExam", method = RequestMethod.GET) public
	 * String startExam(HttpServletRequest request) throws IOException {
	 * List<ExamModel> listExam = examService.getAllExams(); HttpSession session=
	 * request.getSession(true); session.setAttribute("exam",listExam ); return
	 * "QuestionView"; }
	 * 
	 * 
	 * @RequestMapping(value = "/result", method = RequestMethod.GET) public
	 * ModelAndView displayResult(HttpServletRequest request) { int totalMark=0;
	 * HttpSession session1 = request.getSession(true);
	 * 
	 * @SuppressWarnings("unchecked") List<ExamModel> listExam =
	 * (List<ExamModel>)session1.getAttribute("exam"); int option
	 * =Integer.parseInt(request.getParameter("option")); int count =
	 * Integer.parseInt(request.getParameter("count")); count=count-1; if(option ==
	 * 1) { if((listExam.get(count).getAns()).equals(listExam.get(count).getOpt1()))
	 * {
	 * 
	 * totalMark++; } } else if(option ==2) {
	 * if((listExam.get(count).getAns()).equals(listExam.get(count).getOpt2())) {
	 * totalMark++; } } else if(option ==3) {
	 * if((listExam.get(count).getAns()).equals(listExam.get(count).getOpt3())) {
	 * 
	 * totalMark++; } } else if(option ==4) {
	 * if((listExam.get(count).getAns()).equals(listExam.get(count).getOpt4())) {
	 * totalMark++; } } HttpSession session = request.getSession(true);
	 * session.setAttribute("Mark",totalMark); int x = (listExam.size()-1);
	 * if(x==count) { totalMark = 0; } return new ModelAndView("QuestionView");
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/resultPage", method = RequestMethod.GET) public
	 * ModelAndView resultDisplay(HttpServletRequest request) { return new
	 * ModelAndView("Result"); }
	 */	  
}