package com.lxisoft.servlet;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		ContactDatabase database = new ContactDatabase();
		String id = request.getParameter("sno");
		String cname = request.getParameter("name");
		String cnumber = request.getParameter("number");
		String mail = request.getParameter("email");	
		PrintWriter out = response.getWriter();
		Contact contact = new Contact();
		contact.setId(Integer.parseInt(request.getParameter("sno")));
		contact.setName(cname);
		contact.setNumber(cnumber);
		contact.setEmail(mail);
		database.editList(contact);
		response.sendRedirect("viewServlet");
	}
}