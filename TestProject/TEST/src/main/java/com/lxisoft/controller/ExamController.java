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











/*package com.lxisoft.controller;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.entity.Exam;
import com.lxisoft.service.ExamService;

@Controller

public class ExamController {
	private static final Logger logger = Logger
            .getLogger(ExamController.class);
 
    public ExamController() {
        System.out.println("ExamController()");
    }
    @RequestMapping(value="/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
 
    @Autowired
    private ExamService examService;
 
    @RequestMapping(value = "/home")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Exam> listExam = examService.getAllExam();
        model.addObject("listExam", listExam);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newExam", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Exam exam = new Exam();
        model.addObject("exam", exam);
        model.setViewName("Add");
        return model;
    }
    @RequestMapping(value = "/addsucc", method = RequestMethod.POST)
	 public String addQuestion(@ModelAttribute Exam exam) {
		        if (exam.getId() == 0) {
	            examService.saveExam(exam);
	            return "AddSuccess";
	        } else {
	            examService.saveExam(exam);
	            return "EditSuccess";
	        }    
	        
	    }
   
    @RequestMapping(value = "/deleteExam")
    public ModelAndView questionsForDelete(ModelAndView model) throws IOException {
       List<Exam> listExam = examService.getAllExam();
       model.addObject("listExam", listExam);
       model.setViewName("home");
       return model;
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteQuest(HttpServletRequest request) {
        int examId = Integer.parseInt(request.getParameter("id"));
        examService.deleteExam(examId);
        return "DeleteConfirm";
        
    }
 
    
    @RequestMapping(value = "/editExam", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int examId = Integer.parseInt(request.getParameter("id"));
        Optional<Exam> exam = examService.getExamId(examId);
        ModelAndView model = new ModelAndView("Edit");
        model.addObject("exam", exam);
        return model;
    }
    
    @RequestMapping(value = "/questions")
    public String userQuestionDisplay(HttpServletRequest request) throws IOException {
       List<Exam> listExam = examService.getAllExam();
       HttpSession sessions = request.getSession(true);
       sessions.setAttribute("listExam", listExam);
      return "ExamQuestion";
	 }
    
    @RequestMapping(value = "/option", method = RequestMethod.GET)
	  public ModelAndView option(HttpServletRequest request)
	  {
		  HttpSession session = request.getSession(true);
		  int option =  Integer.parseInt(request.getParameter("opt"));
		  int i = Integer.parseInt(request.getParameter("indexValue"));
		  @SuppressWarnings("unchecked")
		  List<Exam> listExam = (List<Exam>)session.getAttribute("listExam");
		  
		  if(option == 1)
		  {
			  listExam.get(i-1).setOption(listExam.get(i-1).getOption1());  
		  }
		  else if(option == 2)
		  {
			  listExam.get(i-1).setOption(listExam.get(i-1).getOption2());  
		  }
		  else if(option == 3)
		  {
			  listExam.get(i-1).setOption(listExam.get(i-1).getOption3());  
		  }
		  else if(option == 4)
		  {
			  listExam.get(i-1).setOption(listExam.get(i-1).getOption4());  
		  }
		  session.setAttribute("listExam", listExam);
		  ModelAndView model = new ModelAndView("ExamQuestion");
		  return model;
	  }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
	public String resultView(HttpServletRequest request)
	  {
		  int mark = 0;
		  HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<Exam> listExam = (List<Exam>)session.getAttribute("listExam");
		  for(int i =0;i<listExam.size();i++)
		  {
			if(listExam.get(i).getAnswer().equals(listExam.get(i).getOption()))
			{
				mark++;
			}
		  }
		  session.setAttribute("mark",mark);		  
		  return "Result";
}
    
}*/