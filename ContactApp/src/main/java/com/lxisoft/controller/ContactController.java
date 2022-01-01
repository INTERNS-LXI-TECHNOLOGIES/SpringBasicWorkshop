package com.lxisoft.controller;

//import com.lxisoft.model.Address;
import com.lxisoft.model.Address;
import com.lxisoft.model.Contact;

import com.lxisoft.service.AddressService;
import com.lxisoft.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
   // @Autowired
   // ContactRepository repository;
    @Autowired
   ContactService contactService;

    @Autowired
    AddressService addressService;

    @RequestMapping(value="/view")
    public String viewAllContact(@RequestParam(required = false, value="page") String page, @RequestParam(required = false, value="name") String name, ModelMap model) throws Exception {
        //ContactRepository repository = new ContactRepository();

        int pageNumber = 0;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;
        List<Contact> contactList = null;

        if(page != null){
            try{
                pageNumber = Integer.parseInt(page);
                pageNumber--;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        start = (pageNumber-1)*contactPerPage;
        if (name == null) {
            contactList = contactService.getAllContacts(pageNumber,contactPerPage);
            totalContacts = contactService.getNumberOfContacts();
            System.out.print("Controller  : "+ page);
        }
        else{
            contactList = contactService.searchContactByName(name);
            //totalContacts = contactService.getNumberOfSearchedContacts(name);
            //System.out.println("No Searches");
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
    public void addNewContact(@RequestParam(required = true, value = "name")String name,@RequestParam(required = true, value = "number")String number,@RequestParam(required = true, value = "mail")String mail,@RequestParam(value = "placeName")String placename,@RequestParam(value = "nationality")String nationality, HttpServletResponse response){

        try {
            // ContactRepository repository = new ContactRepository();

            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            Address address = new Address();
            address.setPlaceName(placename);
            address.setNationality(nationality);
            contactService.saveContact(contact,address);
            response.sendRedirect("view");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/addAddress")
    public String addAddress(@RequestParam String id, ModelMap model) throws IOException {
        model.addAttribute(id);
        return "addAddress";
        /*contactService.saveAddress(address);
        response.sendRedirect("view");*/
    }
    @RequestMapping(value = "/addContactAddress")
    public void saveContactAddress(@RequestParam(value = "contactId")String id,@RequestParam(value = "placeName")String placename,@RequestParam(value = "nationality")String nationality, HttpServletResponse response) throws IOException {
        /*model.addAttribute(id);
        return "addAddress";*/
        Address address = new Address();
        address.setPlaceName(placename);
        address.setNationality(nationality);
        addressService.saveAddress(address);
        response.sendRedirect("view");
    }

    @RequestMapping(value = "/showContact")
    public String showContactDetails(@RequestParam String id,ModelMap model){
        //ContactRepository repository = new ContactRepository();
        Contact contactToEdit =  contactService.getContactById(Integer.parseInt(id));

        model.addAttribute("contact",contactToEdit);
        return "editContact";
    }
   /* @RequestMapping(value = "viewContactAddress")
    public String viewAddress(@RequestParam String id,ModelMap model){
        Address contactAddress = contactService.getAddressById(Integer.parseInt(id));
        model.addAttribute("address",contactAddress);
        return "viewAddress";
    }*/

   /* @RequestMapping(value = "/editContact")
    public void editContact(@ModelAttribute("contact") Contact contact, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // ContactRepository repository = new ContactRepository();
/*
         Contact contact = new Contact();

        contact.setId(Integer.parseInt(sno));
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        int id = Integer.parseInt(request.getParameter("sno"));
        contactService.deleteContactById(id);
        contactService.saveContact(contact);
        response.sendRedirect("view");
    }*/

    @RequestMapping(value = "/deleteContact")
    public String deleteContact(@RequestParam int sno){

            //  ContactRepository repository = new ContactRepository();
        contactService.deleteContactById(sno);
        return "deleteContact";

    }

}