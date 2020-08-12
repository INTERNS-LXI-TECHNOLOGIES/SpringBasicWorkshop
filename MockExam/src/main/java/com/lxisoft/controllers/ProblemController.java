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

    @RequestMapping(value = "/editQuestion",method=RequestMethod.GET)
    public ModelAndView editQuestion(HttpServletRequest request)
    {
        int qno = Integer.parseInt(request.getParameter("id"));
        Problem exam = problemService.getQuestionById(qno);
        ModelAndView model = new ModelAndView();
        model.addObject("questById", exam);
        model.setViewName("edit");
        return model;
    }

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Problem problem)
    {
        problemService.editProblem(problem);
        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value="/deleteQuestion")
    public String deleteQuestion(HttpServletRequest request)
    {
        int qid = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("qId", qid);
        return "delete";
    }

    @RequestMapping(value="/delete")
    public ModelAndView delete(HttpServletRequest request)
    {
        int qid = Integer.parseInt(request.getParameter("id"));
        problemService.deleteProblem(qid);
        return new ModelAndView("redirect:/admin");

    }

}
