package main.java.com.lxisoft.controller;

import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutController {

@GetMapping("log-out")
    public String logOut(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.invalidate();
      return "redirect:/";



    }

}