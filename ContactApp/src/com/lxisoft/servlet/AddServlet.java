package com.lxisoft.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;

public class AddServlet extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.getWriter().println("Add Contact ");
		try
		{
			ContactDatabase db = new ContactDatabase();
			ArrayList<Contact> contactList = new ArrayList<Contact>();
			Contact contact = new Contact();				
			contact.setName(request.getParameter("name"));
			contact.setNumber(request.getParameter("number"));
			contact.setEmail(request.getParameter("mail"));
			

			db.addToDatabase(contact);
			//contactList = db.viewDatabase(contactList);
			response.sendRedirect("viewServlet");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}	