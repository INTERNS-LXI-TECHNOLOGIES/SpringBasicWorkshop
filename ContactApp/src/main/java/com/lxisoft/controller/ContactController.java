package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
public class ContactController {
    AddressBookRepository addressBookRepository=new AddressBookRepository();


    @GetMapping(value = {"/", "/home"})
    public String indexPage() {

        return "index";
    }

    @RequestMapping(value = "/AddContact" , method=RequestMethod.GET)
    public ModelAndView AddContact(ModelAndView model)
    {
        Contact contact = new Contact();
        model.addObject("contact",contact);
        model.setViewName("AddContact");
        return model;
    }
    @RequestMapping(value = "/AddServlet",method=RequestMethod.GET)
    public ModelAndView AddServlet(@ModelAttribute Contact contact)
    {
        ModelAndView model =new ModelAndView();
        addressBookRepository.save(contact);
        //model.setViewName("ViewContactUser");
        //return model;
        return new ModelAndView("redirect:/ViewServletUser");

    }

    @RequestMapping(value = "/ViewServletUser",method=RequestMethod.GET )
    public ModelAndView ViewServletUser(ModelAndView model)
    {
        ArrayList<Contact> contactList=new ArrayList<Contact>();
        contactList=addressBookRepository.read();
        model.addObject("contactList",contactList);
        model.setViewName("ViewContactUser");
        return model;
        //return new ModelAndView("redirect:/ViewContactUser"); this goes to a new page.
    }

    @RequestMapping(value = "/ViewServlet",method = RequestMethod.GET)
    public ModelAndView ViewServletAdmin(ModelAndView model)
    {
        ArrayList<Contact> contactListAdmin=new ArrayList<Contact>();
        contactListAdmin=addressBookRepository.read();
        model.addObject("contactList",contactListAdmin);
        model.setViewName("ViewContact");
        return model;

    }

    @GetMapping (value = "/UpdateContactSelected")
    public String UpdateContactSelected()
    {
        return "UpdateContactSelected";
    }
    @RequestMapping(value = "/UpdateServlet",method = RequestMethod.GET)
    public ModelAndView UpdateServlet(HttpServletRequest request,ModelAndView model)
    {
        String id=request.getParameter("id");
        String name= request.getParameter("name");
        String number=request.getParameter("number");
        String email=request.getParameter("email");
        addressBookRepository.edit(id,name,number,email);
        ArrayList<Contact> contactListUpdate=new ArrayList<Contact>();
        contactListUpdate=addressBookRepository.read();
        model.addObject("contactList",contactListUpdate);
        model.setViewName("ViewContact");
        return model;

    }
    @GetMapping(value = "/DeleteContact")
    public String DeleteContact()
    {
        return "DeleteContact";
    }
    @RequestMapping(value = "/DeleteContactServlet",method = RequestMethod.GET)
    public ModelAndView DeleteContactServlet(HttpServletRequest request,ModelAndView model)
    {
        String name=request.getParameter("name");
        String id=request.getParameter("id");
        addressBookRepository.deleteName(name);
        ArrayList<Contact> contactDelete=new ArrayList<Contact>();
        contactDelete=addressBookRepository.read();
        model.addObject("contactList",contactDelete);
        model.setViewName("ViewContact");
        return model;
    }
}
