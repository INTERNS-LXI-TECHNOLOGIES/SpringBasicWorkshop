package com.lxisoft.spring.controller;

import com.lxisoft.spring.entity.Contact;
import com.lxisoft.spring.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String home(Model model) {
        List<Contact> contactList = contactService.listAllContacts();
        model.addAttribute("contactList", contactList);
        return "home";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute Contact contact) throws SQLException {
        contactService.saveContact(contact);
        return "redirect:/";
    }


    @GetMapping("/create")
    public String createContact(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("caption", "ADD NEW CONTACT");
        return "ContactForm";
    }

    @GetMapping("/delete/{contact_id}")
    public String deleteContact(@PathVariable int contact_id){

        contactService.deleteContact(contact_id);
        return "redirect:/";
    }

    @GetMapping("/edit/{contact_id}")
    public String editContact(@PathVariable int contact_id, Model model){
        Contact contact = contactService.getContact(contact_id);
        model.addAttribute("contact", contact);
        model.addAttribute("caption", "UPDATE CONTACT");
        return "ContactForm";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
