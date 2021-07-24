package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

}