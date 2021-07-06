package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class ViewContacts {
    @RequestMapping("/viewServlet")
    public void view(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ContactDatabase contacts = new ContactDatabase();
        int pageNumber = 1;
        int totalContacts = 0;
        int contactPerPage = 5;
        int start = 0;
        int numOfPage = 0;

        if(request.getParameter("page") != null){
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        //ContactDatabase contacts = new ContactDatabase();
        start = (pageNumber-1)*contactPerPage;
        ArrayList<Contact> list = contacts.viewDatabase(start,contactPerPage);
        totalContacts = contacts.numOfContacts();
        numOfPage = totalContacts/contactPerPage;
        if(totalContacts > numOfPage * contactPerPage){
            numOfPage = numOfPage+1;
        }
        request.setAttribute("contactList",list);
        request.setAttribute("numOfPage",numOfPage);
        request.setAttribute("currentPage",pageNumber);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);

    }
}
