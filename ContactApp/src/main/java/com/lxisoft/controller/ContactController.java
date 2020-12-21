package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;
import com.lxisoft.repository.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ContactController {
    AddressBookRepository addressBookRepository=new AddressBookRepository();
    ContactService contactservice=new ContactService();


    @GetMapping(value = {"/", "/home"})
    public String indexPage() {

        return "index";
    }
    @RequestMapping(value = "/AddContact",method = RequestMethod.GET)
    public ModelAndView AddContact(ModelAndView model)
    {
        Contact contact=new Contact();
        model.addObject("contact",contact);
        model.setViewName("AddContact");
        return model;
    }
    @RequestMapping(value = "/AddServlet",method = RequestMethod.GET)
    public ModelAndView AddContact(@ModelAttribute Contact contact)
    {
        contactservice.add(contact);
        return new ModelAndView("redirect:/ViewServletUser");

    }

    @RequestMapping(value = "/ViewServletUser",method=RequestMethod.GET )
    public ModelAndView ViewServletUser(HttpServletRequest request,ModelAndView model)
    {
       // HttpSession session = request.getSession();
        List<Contact> contactList = contactservice.viewData();
        //ModelAndView model = new ModelAndView();
        //session.setAttribute("contactList",contactList);

        model.addObject("contactList",contactList);
        model.setViewName("ViewContact");
        return model;
    }

    @RequestMapping(value = "/ViewServlet",method = RequestMethod.GET)
    public ModelAndView ViewServletAdmin(HttpServletRequest request, ModelAndView model)
    {

       // HttpSession session = request.getSession();
        List<Contact> contactListAdmin =  contactservice.viewData();
       // ModelAndView model = new ModelAndView();
       //session.setAttribute("contactList",contactListAdmin);
        model.addObject("contactList",contactListAdmin);
        model.setViewName("ViewContact");
        return model;
    }

    @GetMapping (value = "/UpdateContactSelected")
    public ModelAndView UpdateContactSelected(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        Contact contact=new Contact();
        contact=contactservice.getContactById(id);
        ModelAndView model=new ModelAndView();
        model.addObject("contact",contact);
        model.setViewName("UpdateContactSelected");
        return model;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Contact contact)
    {
            contactservice.saveContact(contact);
//        return new ModelAndView("redirect:/ViewContact");
        List<Contact> contactListUpdate=new ArrayList<Contact>();
        ModelAndView model=new ModelAndView();
        contactListUpdate=contactservice.viewData();
        model.addObject("contactList",contactListUpdate);
        model.setViewName("ViewContact");
        return model;
    }

    @GetMapping(value = "/DeleteContact")
    public ModelAndView DeleteContact(HttpServletRequest request)
    {
        ModelAndView model=new ModelAndView();
    int id=Integer.parseInt(request.getParameter("id"));
    contactservice.delete(id);
        return new ModelAndView("redirect:/ViewContact");

    }

}
