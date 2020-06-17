package com.lxisoft.controller;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.jboss.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.entity.*;
import com.lxisoft.service.*;

@Controller
public class MockController 
{


	@Autowired
	private MockService mockService;


	@RequestMapping(value= "/")
	public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
		
	}
	
	/*private static final Logger logger = Logger.getLogger(MockController.class);
   
    public MockController() {
        System.out.println("MockController()");
    }*/
	
	
	
	@RequestMapping(value = "/home")
    public String getAdmin()
	{
		return "Admin";
    }

    @RequestMapping(value = "/introduction")
    public String getUser()
	{
		return "introduction";
    }


	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }
	 
	 @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
        MockEntity mockModel = new MockEntity();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	 
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String addQuestion(@ModelAttribute MockEntity mockModel) {
		
	 		if (mockModel.getId() == 0)
	 		{
	            mockService.saveQuestion(mockModel);
	            return "AddSuccess";
	        } else 
	        {
	            mockService.saveQuestion(mockModel);
	            return "EditSuccess";
	        }   
	 }
	 
	 @RequestMapping(value = "/deleteQuestion")
     public ModelAndView questionsForDelete(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
	 }
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	    public String deleteQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuestion(questionId);
	        return "DeleteConfirmation";
	    }

	 @RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
    	public ModelAndView editQuestion(HttpServletRequest request) 
    	{
        int questionId = Integer.parseInt(request.getParameter("id"));
        Optional<MockEntity> mockEntity = mockService.getQuestionId(questionId);
        ModelAndView model = new ModelAndView("Edit");
        model.addObject("mockEntity", mockEntity);
        return model;
    	}


 	@RequestMapping(value = "/selectOption", method = RequestMethod.GET)
	  public ModelAndView seletedOption(HttpServletRequest request,HttpServletResponse res)
	  {

	  	ModelAndView model=null;
		  HttpSession sessions = request.getSession(true);
		  //int selected =  Integer.parseInt(request.getParameter("option"));
		  String quest=request.getParameter("option");
		  int count = Integer.parseInt(request.getParameter("count"));
		  @SuppressWarnings("unchecked")
		  int mark=0;
		  List<MockEntity> listQuestions = (List<MockEntity>)sessions.getAttribute("listQuestions");


			

				if(quest.equals(listQuestions.get(count).getAnswer()));
				{
					mark=mark+1;
					
				}

				//model = new ModelAndView("Exam");
				count++;
				sessions.setAttribute("count", count);
				sessions.setAttribute("Mrk", mark);
				model = new ModelAndView("Exam");

	
			
		  	sessions.setAttribute("listQuestions", listQuestions);
		  	
		  	return model;
	  }


     @RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showResult(HttpServletRequest request)
	  {
		 
		HttpSession sessions = request.getSession(true);
		int mark = Integer.parseInt(sessions.getAttribute("Mrk").toString());
		sessions.setAttribute("Mark", mark);
		@SuppressWarnings("unchecked")
		List<MockEntity> listQuestions = (List<MockEntity>)sessions.getAttribute("listQuestions");

		return "Result";




}
}