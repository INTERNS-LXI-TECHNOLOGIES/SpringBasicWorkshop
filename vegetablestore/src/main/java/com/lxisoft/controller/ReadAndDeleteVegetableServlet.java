package main.java.com.lxisoft.controller;


import main.java.com.lxisoft.vegetable.Vegetable;

import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import main.java.com.lxisoft.dao.VegetableDao;

public class ReadAndDeleteVegetableServlet extends HttpServlet {
	
	
 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException
{
		System.out.println("VegetableServlet get method working");
	List <Vegetable>vegetables = new ArrayList<Vegetable>();
	
	try {
      
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft","root","Mubashir24092000");
        
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery("select * from vegetablestore;");
      

while(rs.next())
{

  Blob blob = rs.getBlob(6);
                 
  InputStream inputStream = blob.getBinaryStream();
  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  byte[] buffer = new byte[4096];
  int bytesRead = -1;
   
  while ((bytesRead = inputStream.read(buffer)) != -1) {
      outputStream.write(buffer, 0, bytesRead);                  
  }
   
  byte[] imageBytes = outputStream.toByteArray();
  String base64Image = Base64.getEncoder().encodeToString(imageBytes);
   
   
  inputStream.close();
  outputStream.close();
   

vegetables.add(new Vegetable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),base64Image));


}

request.setAttribute("vegetable",vegetables);
  RequestDispatcher requestDispatcher = request.getRequestDispatcher("vegetable.jsp");
        requestDispatcher.forward(request, response);


       } catch (Exception ex) {
           ex.printStackTrace ();
       }
	  
}


public void doPost(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException
{
  VegetableDao vegetableDao = new VegetableDao();
	
  System.out.println("Delete method working");

	int id = Integer.parseInt(request.getParameter("id"));


	try {
	
	vegetableDao.deleteVegetable(id);
	
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}

  response.sendRedirect("vegetable-list");
	
}

}
