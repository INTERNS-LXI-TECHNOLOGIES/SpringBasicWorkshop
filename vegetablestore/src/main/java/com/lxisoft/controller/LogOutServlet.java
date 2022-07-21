package main.java.com.lxisoft.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public class LogOutServlet extends HttpServlet {


 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException{

 HttpSession session = request.getSession();
 session.invalidate();
 response.sendRedirect("vegetable-list");




}





}