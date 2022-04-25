package com.lxisoft.controller;

import com.lxisoft.model.Role;
import com.lxisoft.model.User;
import com.lxisoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register")
    public String userRegister(){
        return "registration";
    }

    @RequestMapping(value = "/userRegistration",method = RequestMethod.POST)
    public String userRegistration(Model model, @ModelAttribute("user") User user, @ModelAttribute("roles")Role role){
        System.out.println("Reached Registration");
        userService.saveUser(user,role);
        return "userAddedMessage";
    }
}
