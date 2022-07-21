package main.java.com.lxisoft.servlets;

import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import main.java.com.lxisoft.dao.VegetableDao;
import main.java.com.lxisoft.vegetable.Vegetable;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
public class CreateVegetableServlet extends HttpServlet {

public CreateVegetableServlet() {
	
	super();
	
}
	
protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException
{
	
	response.getWriter().append("served at:").append(request.getContextPath());

	RequestDispatcher requestDispatcher = request.getRequestDispatcher("addVegetable.jsp");
	requestDispatcher.forward(request, response);


		}

protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
{

	VegetableDao vegetableDao = new VegetableDao();

	System.out.println("add method working");

String	name = request.getParameter("name");
	String price = request.getParameter("price");
	 String stock = request.getParameter("stock");
	 String orderQuantity = request.getParameter("orderQuantity");
 javax.servlet.http.Part image = request.getPart("image");
 
 System.out.println(request.getParts());
 
 System.out.println("image: "+ image);

 InputStream inputStream  = image.getInputStream();
		System.out.println(image);



	Vegetable veg = new Vegetable();


	veg.setName(name);
	veg.setPrice(price);
	veg.setStock(stock);
	veg.setOrderQuantity(orderQuantity);
	veg.setImage(inputStream);
	
try{
	vegetableDao.addVegetable(veg);
}catch(Exception e)  {
	e.printStackTrace();
}
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("vegetableConform.jsp");
	  requestDispatcher.forward(request, response);
}

}


