package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerClass {

    @RequestMapping(value="/view")
    public String view(@RequestParam String page,ModelMap model) {
        ContactDatabase contacts = new ContactDatabase();

        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;

        if(page != null){
            pageNumber = Integer.parseInt(page);
        }
        start = (pageNumber-1)*contactPerPage;

        List<Contact> list = contacts.viewDatabase(start,contactPerPage);

        totalContacts = contacts.numOfContacts();
        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }

        model.addAttribute("contactList",list);
        model.addAttribute("numOfPage",numOfPage);
        model.addAttribute("currentPage",pageNumber);


        return "view.jsp";
    }

    @RequestMapping(value = "/contactAdd")
    public void contactAdd(@RequestParam(required = false) String name, String number, String mail , HttpServletResponse response){

        try {
            ContactDatabase db = new ContactDatabase();
            List<Contact> contactList = new ArrayList<Contact>();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            db.addToDatabase(contact);

            response.sendRedirect("view");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/contactEdit")
    public void editContact(@RequestParam String sno,String name,String number,String email, HttpServletResponse response) throws IOException {
        ContactDatabase database = new ContactDatabase();

        Contact contact = new Contact();

        contact.setId(Integer.parseInt(sno));
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        database.editList(contact);
        response.sendRedirect("view");
    }

    @RequestMapping(value = "/contactDelete")
    public void deleteContact(@RequestParam String name, HttpServletResponse response){
        try
        {
            ContactDatabase db = new ContactDatabase();
            db.deleteRecord(name);
            response.sendRedirect("deleteContact.jsp");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/search")
    public String searchContact(@RequestParam String name, ModelMap model){
        try {
            ContactDatabase contacts = new ContactDatabase();


            List<Contact> list = contacts.searchDatabase(name);

            model.addAttribute("contactList",list);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "search.jsp";
    }
}