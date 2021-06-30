package com.lxisoft.servlet;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
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