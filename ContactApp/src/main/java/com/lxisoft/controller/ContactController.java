package com.lxisoft.controller;

//import com.lxisoft.model.Address;
import com.lxisoft.model.Address;
import com.lxisoft.model.Contact;

import com.lxisoft.service.AddressService;
import com.lxisoft.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//import static com.sun.tools.javac.jvm.ByteCodes.ret;

@Controller
public class ContactController {
   // @Autowired
   // ContactRepository repository;
    @Autowired
    ContactService contactService;

    @Autowired
    AddressService addressService;

    //View Contacts
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
            //System.out.print("Controller  : "+ page);
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

    //Redirect to AddContact
    @RequestMapping(value = "/addNewContact")
    public String addNewContact(ModelMap model){
        Contact contact = new Contact();
        Address address = new Address();
        model.addAttribute("contact",contact);
        model.addAttribute("address",address);
        return "addContact";
    }

    //Adding Contact
    @RequestMapping(value = "/addContact")
    public String addNewContact(@RequestParam(required = false, value = "name")String name,@RequestParam(required = false,value = "number")String number,@RequestParam(required = false, value = "mail")String mail,@RequestParam(required = false,value = "placeName")String placeName,@RequestParam(required = false,value = "nationality")String nationality,ModelMap model, HttpServletResponse response){
        if(name==null&&number==null&&mail==null&&placeName==null&&nationality==null){
            return "addContact";
        }
        else {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setNumber(number);
            contact.setEmail(mail);
            Address address = new Address();
            address.setPlaceName(placeName);
            address.setNationality(nationality);
            contactService.saveContact(contact,address);
            return "addingContactMessage";
        }
    }


    //Get Contact and Address by Id
    @RequestMapping(value = "/showContact")
    public String showContactDetails(@RequestParam String id,ModelMap model){
        //ContactRepository repository = new ContactRepository();
        Contact contactToEdit =  contactService.getContactById(Integer.parseInt(id));
        Address addressToEdit = addressService.getAddressById(Integer.parseInt(id));
        model.addAttribute("contact",contactToEdit);
        model.addAttribute("address",addressToEdit);
        return "editContact";
    }


    //Get Address by Id
    @RequestMapping(value = "viewContactAddress")
    public String viewAddress(@RequestParam String id,ModelMap model){
        Address contactAddress = addressService.getAddressById(Integer.parseInt(id));
        model.addAttribute("address",contactAddress);
        return "viewAddress";
    }


    //Edit Contact and Address
    @RequestMapping(value = "/editContact")
    public String editContact( @RequestParam(value = "sno")String id,@RequestParam(value = "name")String name,@RequestParam(value = "number")String number,@RequestParam(value = "email")String email,@RequestParam(value = "placeName")String placeName,@RequestParam(value = "nationality")String nationality, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // ContactRepository repository = new ContactRepository();

        Contact contact = new Contact();


        contact.setId(Integer.parseInt(id));
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);

        Address address = new Address();
        address.setPlaceName(placeName);
        address.setNationality(nationality);
        //int id = Integer.parseInt(request.getParameter("sno"));
       // contactService.deleteContactById(id);
        contactService.saveContact(contact, address);
        return "editingContactMessage";
    }


    //Delete Contact and Address
    @RequestMapping(value = "/deleteContact")
    public String deleteContact(@RequestParam int sno){

            //  ContactRepository repository = new ContactRepository();
        contactService.deleteContactById(sno);
        return "deleteContact";

    }

}