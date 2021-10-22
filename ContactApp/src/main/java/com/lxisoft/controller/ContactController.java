package com.lxisoft.controller;

import com.lxisoft.dao.ContactDAO;
import com.lxisoft.dao.ContactDAOImplementation;
import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;
//import com.lxisoft.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
   // @Autowired
   // ContactRepository repository;

    @Autowired
    ContactDAO contactDAO;



    @RequestMapping(value="/view")
    public String viewAllContact(@RequestParam(required = false, value="page") String page, @RequestParam(required = false, value="name") String name, ModelMap model) throws Exception {
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
            contactList = contactDAO.getAllContacts(start,contactPerPage);
            totalContacts = contactDAO.getNumberOfContacts();
        }
        else{
            contactList = contactDAO.searchContactByName(name,start,contactPerPage);
            totalContacts = contactDAO.getNumberOfSearchedContacts(name);
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
    public void addNewContact(@RequestParam(required = false) String name, String number, String mail , HttpServletResponse response){

        try {
            // ContactRepository repository = new ContactRepository();
            List<Contact> contactList = new ArrayList<Contact>();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            contactDAO.saveContact(contact);

            response.sendRedirect("view");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/showContact")
    public String showContactDetails(@RequestParam String id,ModelMap model) throws SQLException{
        //ContactRepository repository = new ContactRepository();
        List<Contact> editList =  contactDAO.getContactById(Integer.parseInt(id));

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
        contactDAO.editContact(contact);
        response.sendRedirect("view");
    }

    @RequestMapping(value = "/deleteContact")
    public String deleteContact(@RequestParam String name){

            //  ContactRepository repository = new ContactRepository();
        contactDAO.deleteContactByName(name);
        return "deleteContact";

    }

}
