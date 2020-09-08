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

import com.lxisoft.model.User;
import com.lxisoft.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home"})
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/add" ,method=RequestMethod.GET)
    public ModelAndView addUser(ModelAndView model)
    {
        User user = new User();
        model.addObject("user",user);
        model.setViewName("add");
        return model;
    }

    @RequestMapping(value = "/addQuestion",method = RequestMethod.GET)
    public ModelAndView saveQuestion(@ModelAttribute User user)
    {
        userService.saveUser(user);
        return new ModelAndView("redirect:/home");
    }
}
