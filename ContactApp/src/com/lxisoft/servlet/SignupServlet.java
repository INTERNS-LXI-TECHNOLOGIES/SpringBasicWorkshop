package com.lxisoft.servlet;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignupServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response){
    	UsersDatabase users = new UsersDatabase();

		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		users.addUsers(name,pass);
		
		try{
		    response.sendRedirect("signupSuccess.jsp");	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}