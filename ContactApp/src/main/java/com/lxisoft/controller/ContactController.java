package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
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


    private ContactRepository repository;
    @Autowired
    public ContactController(ContactRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value="/view", method = RequestMethod.POST)

    public String viewContact(@RequestParam(required = false, value="page") String page,@RequestParam(required = false, value="name") String name,ModelMap model) throws SQLException {
        //ContactRepository repository = new ContactRepository();

        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;
        List<Contact> contactList = null;

        if(page != null){
            try{
                pageNumber = Integer.parseInt(page);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        start = (pageNumber-1)*contactPerPage;
        if (name == null) {
            contactList = repository.viewContactList(start, contactPerPage);
            totalContacts = repository.numOfContacts();
        }
        else{
            contactList = repository.searchInContactList(name,start,contactPerPage);
            totalContacts = repository.numOfSearchedContacts(name);
        }

        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }
        model.addAttribute("name",name);
        model.addAttribute("numOfPage",numOfPage);
        model.addAttribute("currentPage",pageNumber);
        model.addAttribute("contactList",contactList);

        return "viewContact";
    }

    @RequestMapping(value = "/addContact")
    public void addContact(@RequestParam(required = false) String name, String number, String mail , HttpServletResponse response){

        try {
           // ContactRepository repository = new ContactRepository();
            List<Contact> contactList = new ArrayList<Contact>();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            repository.addToContactList(contact);

            response.sendRedirect("view");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/showContact")
    public String showContactDetails(@RequestParam String id,ModelMap model) throws SQLException{
        //ContactRepository repository = new ContactRepository();
        List<Contact> editList =  repository.getContactDetails(id);

        model.addAttribute("list",editList);
        return "editContact";
    }

    @RequestMapping(value = "/editContact")
    public void editContact(@RequestParam String sno,String name,String number,String email, HttpServletResponse response) throws IOException {
       // ContactRepository repository = new ContactRepository();

        Contact contact = new Contact();

        contact.setId(Integer.parseInt(sno));
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        repository.editContact(contact);
        response.sendRedirect("view");
    }

    @RequestMapping(value = "/deleteContact")
    public void deleteContact(@RequestParam String name, HttpServletResponse response){
        try
        {
          //  ContactRepository repository = new ContactRepository();
            repository.deleteContact(name);
            response.sendRedirect("deleteContact");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}