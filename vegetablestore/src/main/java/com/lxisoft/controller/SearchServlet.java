package main.java.com.lxisoft.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.lxisoft.vegetable.Vegetable;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public class SearchServlet extends HttpServlet{


 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException{

 List <Vegetable>vegetables = new ArrayList<Vegetable>();


String word = request.getParameter("search");

String sql = "select * from vegetablestore where name like'%"+word+"%';";

System.out.println(sql);

try {
      
 Class.forName("com.mysql.cj.jdbc.Driver");

 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft","root","Mubashir24092000");
 
 Statement st = con.createStatement();
 
 ResultSet rs = st.executeQuery(sql);

while(rs.next()){


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
  
vegetables.add( new Vegetable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),base64Image));


}


request.setAttribute("vegetable",vegetables);
  RequestDispatcher requestDispatcher = request.getRequestDispatcher("vegetable.jsp");
        requestDispatcher.forward(request, response);



}catch(Exception e){

e.printStackTrace();


}
}
}
