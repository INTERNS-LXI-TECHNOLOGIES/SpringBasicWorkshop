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
public class ContactController {

    @RequestMapping(value="/viewContact")
    public String viewContact(ModelMap model) {
        ContactDatabase contacts = new ContactDatabase();


        List<Contact> list = contacts.viewDatabase();

        model.addAttribute("contactList",list);

        return "view.jsp";
    }

    @RequestMapping(value = "/addContact")
    public void addContact(@RequestParam(required = false) String name, String number, String mail , HttpServletResponse response){

        try {
            ContactDatabase db = new ContactDatabase();
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
        ContactDatabase database = new ContactDatabase();
        List<Contact> editList =  database.getEditingDetails(id);
        for(Contact contact : editList){
            System.out.println(contact.getId());
            System.out.println(contact.getName());
            System.out.println(contact.getNumber());
            System.out.println(contact.getEmail());
        }
        model.addAttribute("list",editList);
        return "editContact.jsp";
    }

    @RequestMapping(value = "/editContact")
    public void editContact(@RequestParam String sno,String name,String number,String email, HttpServletResponse response) throws IOException {
        ContactDatabase database = new ContactDatabase();

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