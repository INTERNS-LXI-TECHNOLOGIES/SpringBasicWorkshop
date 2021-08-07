package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    @RequestMapping(value="/viewContact")
    public String viewContact(@RequestParam(required = false) String page,String name,ModelMap model) throws SQLException {
        ContactRepository database = new ContactRepository();

        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;
        List<Contact> list = null;

        if(page != null){
            pageNumber = Integer.parseInt(page);
        }
        start = (pageNumber-1)*contactPerPage;
        if (name == null) {
            list = database.viewDatabase(start, contactPerPage);
            totalContacts = database.numOfContacts();
        }
        else{
            list = database.searchDatabase(name,start,contactPerPage);
            totalContacts = database.numOfSearchedContacts(name);
        }

        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }
        model.addAttribute("name",name);
        model.addAttribute("numOfPage",numOfPage);
        model.addAttribute("currentPage",pageNumber);
        model.addAttribute("contactList",list);

        return "viewContact.jsp";
    }

    @RequestMapping(value = "/addContact")
    public void addContact(@RequestParam(required = false) String name, String number, String mail , HttpServletResponse response){

        try {
            ContactRepository db = new ContactRepository();
            List<Contact> contactList = new ArrayList<Contact>();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            db.addToDatabase(contact);

            response.sendRedirect("viewContact");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/editingContact")
    public String editingContact(@RequestParam String id,ModelMap model) throws SQLException{
        ContactRepository database = new ContactRepository();
        List<Contact> editList =  database.getEditingDetails(id);

        model.addAttribute("list",editList);
        return "editContact.jsp";
    }

    @RequestMapping(value = "/editContact")
    public void editContact(@RequestParam String sno,String name,String number,String email, HttpServletResponse response) throws IOException {
        ContactRepository database = new ContactRepository();

        Contact contact = new Contact();

        contact.setId(Integer.parseInt(sno));
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        database.editList(contact);
        response.sendRedirect("viewContact");
    }

    @RequestMapping(value = "/deleteContact")
    public void deleteContact(@RequestParam String name, HttpServletResponse response){
        try
        {
            ContactRepository db = new ContactRepository();
            db.deleteRecord(name);
            response.sendRedirect("deleteContact.jsp");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}