package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
    AddressBookRepository addressBookRepository=new AddressBookRepository();

//    @Autowired
//    private ProblemService problemService;

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
    addressBookRepository.save(contact);
    return new ModelAndView("redirect:/index.jsp");

    }
    @RequestMapping(value = "/ViewServlet",method=RequestMethod.GET )
    public ModelAndView ViewServlet(@ModelAttribute Contact contact)
    {
        addressBookRepository.read()
    }
}
