package com.lxisoft.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.Problem;
import com.lxisoft.service.ProblemService;

@Controller
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping(value = {"/","/home"})
    public String indexPage()
    {
        return "index";
    }

    @RequestMapping(value = "/view")
//    public String adminView()
//    {
//        return "view";
//    }

    public ModelAndView adminView(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        List<Problem> questList = problemService.getProblemData();
        session.setAttribute("qList",questList);
        ModelAndView model = new ModelAndView();
        model.addObject("questList",questList);
        model.setViewName("view");
        return model;
    }

//    @RequestMapping(value = "/add")
//    public ModelAndView addProblem()
//    {
//        return "add";
//    }

    @RequestMapping(value = "/add" ,method=RequestMethod.GET)
    public ModelAndView addQuestion(ModelAndView model)
    {
        Problem problem = new Problem();
        model.addObject("problem",problem);
        model.setViewName("add");
        return model;
    }

    @RequestMapping(value = "/addQuestion",method = RequestMethod.GET)
    public ModelAndView saveQuestion(@ModelAttribute Problem problem)
    {
        problemService.addProblem(problem);
        return new ModelAndView("redirect:/home");
    }


}
