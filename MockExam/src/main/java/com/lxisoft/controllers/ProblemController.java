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
    public String adminView()
    {
        return "view";
    }

    @RequestMapping(value = "/add")
    public String addquestion()
    {
        return "add";
    }




}
