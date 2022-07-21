package main.java.com.lxisoft.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import  main.java.com.lxisoft.dao.VegetableDao;
import main.java.com.lxisoft.vegetable.Vegetable;


public class UpdateVegetableServlet extends HttpServlet {

 

 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException{
    System.out.println("update");

    List <Vegetable>vegetable = new ArrayList<Vegetable>();
try{

	int id = Integer.parseInt(request.getParameter("id"));

  String select_SQL ="select * from vegetablestore where id=?; ";

   Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft","root","Mubashir24092000");
    
    PreparedStatement ps = 	con.prepareStatement(select_SQL );

    ps.setInt(1,id);

    System.out.println(ps);

    ResultSet rs = ps.executeQuery();

    while(rs.next()){

   int vegId = rs.getInt(1);   
 String name = rs.getString(2);
 String price = rs.getString(3);
 String stock = rs.getString(4);
 String orderQuantity = rs.getString(5);

vegetable.add( new Vegetable(vegId,name,price,stock,orderQuantity));

    }
request.setAttribute("vegetable",vegetable);
  RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateVegetable.jsp");
        requestDispatcher.forward(request, response);
     
}catch(Exception e) {
e.printStackTrace();

}


}

public void doPost(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException{

System.out.println("post");

int id = Integer.parseInt(request.getParameter("id"));


String name = request.getParameter("name");
	String price = request.getParameter("price");
	String stock = request.getParameter("stock");
	String orderQuantity = request.getParameter("orderQuantity");
  
Vegetable vegetable = new Vegetable(id,name,price,stock,orderQuantity);

VegetableDao vegetableDao = new VegetableDao();

try {
vegetableDao.updateVegetable(vegetable);

}catch( Exception e) {
e.printStackTrace();

}

response.sendRedirect("vegetable-list");
}
}