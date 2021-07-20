package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ViewContacts {
   /* @RequestMapping("/")
    public String root(){
        return "index";
    } */
    @RequestMapping(value="/view")
    public String view(ModelMap model) {
        ContactDatabase contacts = new ContactDatabase();
        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;


        start = (pageNumber-1)*contactPerPage;
        ArrayList<Contact> list = contacts.viewDatabase(start,contactPerPage);
        totalContacts = contacts.numOfContacts();
        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }
        model.addAttribute("contactList",list);
        model.addAttribute("numofPage",numOfPage);
        model.addAttribute("currentPage",pageNumber);

        return "view.jsp";
    }
}