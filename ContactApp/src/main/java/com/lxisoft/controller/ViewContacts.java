package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewContacts {

    @RequestMapping(value="/view")
    public String view(ModelMap model) {
        ContactDatabase contacts = new ContactDatabase();


        List<Contact> list = contacts.viewDatabase();

        for(Contact contact : list){
            System.out.println(contact.getName());
            System.out.println(contact.getNumber());
            System.out.println(contact.getEmail());
        }
        model.addAttribute("contactList",list);


        return "view.jsp";
    }

    @RequestMapping(value = "/contactAdd")
    public String contactAdd(@RequestParam(required = false) String name,String number,String mail){

        try {
            ContactDatabase db = new ContactDatabase();
            List<Contact> contactList = new ArrayList<Contact>();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            db.addToDatabase(contact);

            this.view("list",contactList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}