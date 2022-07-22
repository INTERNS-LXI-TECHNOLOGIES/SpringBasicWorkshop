package main.java.com.lxisoft.controller;

import main.java.com.lxisoft.dao.VegetableDao;
import main.java.com.lxisoft.vegetable.Vegetable;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@MultipartConfig
public class VegetableController {


    @GetMapping("/")
public void readVegetable() {

    System.out.println("controller read method working");
    List<Vegetable> vegetables = new ArrayList<Vegetable>();

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
        ModelAndView mav = new ModelAndView("view/vegetable");

        mav.addObject("vegetable",vegetables);



    } catch (Exception ex) {
        ex.printStackTrace ();
    }


}
@GetMapping("add-form")
public void addVegetableForm(){

    ModelAndView mav = new ModelAndView("view/addVegetable");

}
@PostMapping("create-vegetable")
public void createVegetable(@RequestParam("name,price,stock,orderQuantity,image")String name,String price,String stock,String orderQuantity,javax.servlet.http.Part image) throws IOException {

    VegetableDao vegetableDao = new VegetableDao();

    System.out.println("add method working");

  	/*name = request.getParameter("name");
  price = request.getParameter("price");
    stock = request.getParameter("stock");
  orderQuantity = request.getParameter("orderQuantity");
   image = request.getPart("image");

    System.out.println(request.getParts());*/

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

    ModelAndView mav = new ModelAndView("view/vegetableConform");
}

@GetMapping("select-vegetable")
public void selectVegetable(@RequestParam("id")int id) {

    System.out.println("update");

    List <Vegetable>vegetable = new ArrayList<Vegetable>();
    try{


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

        ModelAndView mav = new ModelAndView("view/updateVegetable");

        mav.addObject("vegetable",vegetable);


    }catch(Exception e) {
        e.printStackTrace();

    }
}

@GetMapping("update-vegetable")
    public void updateVegetable(@RequestParam("id,name,price,stock,orderQuantity")int id,String name,String price,String stock,String orderQuantity){
        System.out.println("update Vegetable");


         /*name = request.getParameter("name");
        price = request.getParameter("price");
        stock = request.getParameter("stock");
        orderQuantity = request.getParameter("orderQuantity");*/

        Vegetable vegetable = new Vegetable(id,name,price,stock,orderQuantity);

        VegetableDao vegetableDao = new VegetableDao();

        try {
            vegetableDao.updateVegetable(vegetable);

        }catch( Exception e) {
            e.printStackTrace();

        }

        //response.sendRedirect("vegetable-list");
    }



@PostMapping("delete-vegetable")
public void delete(@RequestParam("id")int id) {

    VegetableDao vegetableDao = new VegetableDao();

    System.out.println("Delete method working");



    try {

        vegetableDao.deleteVegetable(id);

    } catch (Exception e) {

        e.printStackTrace();

    }


}


}