package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ViewContacts {
   /* @RequestMapping("/")
    public String root(){
        return "index";
    } */
    @RequestMapping("/view")
    public String view() {
        ContactDatabase contacts = new ContactDatabase();
        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;

        if(request.getParameter("page") != null){
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        //ContactDatabase contacts = new ContactDatabase();
        start = (pageNumber-1)*contactPerPage;
        ArrayList<Contact> list = contacts.viewDatabase(start,contactPerPage);
        totalContacts = contacts.numOfContacts();
        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }
        return "view.jsp";
    }
}