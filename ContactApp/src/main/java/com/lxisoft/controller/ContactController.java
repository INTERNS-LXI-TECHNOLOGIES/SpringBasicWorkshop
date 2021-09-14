package com.lxisoft.controller;

import com.lxisoft.entity.Contact;
import com.lxisoft.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/")
    public ModelAndView viewContacts(ModelAndView model) {
        List<Contact> contactList = contactService.getAllContacts();
        model.addObject("contactList",contactList);
        model.setViewName("viewContacts");
        return model;
    }

    @RequestMapping(value = "/addContact",method = RequestMethod.GET)
    public ModelAndView addContact(ModelAndView model) {
        Contact contact = new Contact();
        model.addObject("contacts",contact);
        model.setViewName("addContacts");
        return model;
    }

    @RequestMapping(value = "saveContact",method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        if(contact.getId() == 0){
            contactService.addContact(contact);
        }
        else {
            contactService.updateContact(contact);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "editContact",method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request){
        int sno = Integer.parseInt(request.getParameter("sno"));
        Contact contact = contactService.getContact(sno);
        ModelAndView model = new ModelAndView("addContacts");
        model.addObject("contact",contact);
        return model;
    }

    @RequestMapping(value = "deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request){
        int sno = Integer.parseInt(request.getParameter("sno"));
        contactService.deleteContact(sno);
        return new ModelAndView("redirect:/");
    }
}
