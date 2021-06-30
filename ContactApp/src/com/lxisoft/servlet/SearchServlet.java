package com.lxisoft.servlet;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name = "";
		if(request.getParameter("name") != null){
			name = request.getParameter("name"); 
		}
		
		ContactDatabase contacts = new ContactDatabase();
		int pageNumber = 1;
		int totalContacts = 0;
		int contactPerPage = 5;
		int start = 0;
		int numOfPage = 0;
		try{
			if(request.getParameter("page") != null){
    			pageNumber = Integer.parseInt(request.getParameter("page"));
	    	}

     		start = (pageNumber-1)*contactPerPage;
		    ArrayList<Contact> list = contacts.viewSearchResult(start,contactPerPage,name);
	    	totalContacts = contacts.numOfSearchContacts(name);
    		numOfPage = totalContacts/contactPerPage;
	    	if(totalContacts > numOfPage * contactPerPage){
                numOfPage = numOfPage+1;
	        }
	        request.setAttribute("contactList",list);
	        request.setAttribute("numOfPage",numOfPage);
	        request.setAttribute("currentPage",pageNumber);
	        RequestDispatcher rd = request.getRequestDispatcher("searchView.jsp");
	        rd.forward(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}