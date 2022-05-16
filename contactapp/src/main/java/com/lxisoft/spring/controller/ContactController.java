package com.lxisoft.spring.controller;

import com.lxisoft.spring.dao.ContactDAO;
import com.lxisoft.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactDAO contactDAO;

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        List<Contact> contactList = contactDAO.listAllContact();
        model.addAttribute("contactList", contactList);
        return "home";
    }

    @PostMapping("/insert")
    public String insertContact(@ModelAttribute Contact contact) throws SQLException {
        contactDAO.insertContact(contact);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute Contact contact) throws SQLException {
        contactDAO.updateContact(contact);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createContact(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("action", "insert");
        return "ContactForm";
    }

    @GetMapping("/delete/{contact_id}")
    public String deleteContact(@PathVariable int contact_id) throws SQLException {
        Contact contact = new Contact();
        contact.setContact_id(contact_id);
        contactDAO.deleteContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{contact_id}")
    public String editContact(@PathVariable int contact_id, Model model) throws SQLException {
        Contact contact = contactDAO.getContact(contact_id);
        model.addAttribute("contact", contact);
        model.addAttribute("action", "update");
        return "ContactUp";
    }

}
