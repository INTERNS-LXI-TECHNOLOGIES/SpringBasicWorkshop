package com.lxisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewContacts {
   /* @RequestMapping("/")
    public String root(){
        return "index";
    } */
    @RequestMapping("/view")
    public String view() {
        return "view.jsp";
    }
}