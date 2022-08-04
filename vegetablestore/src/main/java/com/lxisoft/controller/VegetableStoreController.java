package main.java.com.lxisoft.controller;

import main.java.com.lxisoft.dao.VegetableDao;
import main.java.com.lxisoft.vegetable.Vegetable;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@MultipartConfig
public class VegetableStoreController {


    @GetMapping("/")
public String readVegetable(Model model) {

        System.out.println("controller read method working");
        List<Vegetable> vegetables = new ArrayList<Vegetable>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft", "root", "Mubashir24092000");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from vegetablestore;");


            while (rs.next()) {

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


                vegetables.add(new Vegetable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), base64Image));
            }
            model.addAttribute("vegetable", vegetables);



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "vegetable";
    }
@GetMapping("/add-form")
public String addVegetableForm(){
    System.out.println("add veg");

return "addVegetable";
}
@PostMapping("/create-vegetable")
public String createVegetable(@ModelAttribute("SpringWeb")Vegetable veg,MultipartFile image) throws IOException {
    VegetableDao vegetableDao = new VegetableDao();

    System.out.println("add method working");
    System.out.println(veg.getName());
    System.out.println("image: "+ image);

    InputStream inputStream  = image.getInputStream();
    System.out.println(image);


    try{
       // vegetableDao.addVegetable(veg);
    }catch(Exception e)  {
        e.printStackTrace();
    }

    return "redirect:/";
}

@GetMapping("/select-vegetable")
public String selectVegetable(@RequestParam("id")int id,Model model) {

    System.out.println("select");

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



        model.addAttribute("vegetable",vegetable);


    }catch(Exception e) {
        e.printStackTrace();

    }
    return "updateVegetable";
}

@PostMapping("/update-vegetable")
    public String updateVegetable(@ModelAttribute("SpringWeb") Vegetable veg){

        VegetableDao vegetableDao = new VegetableDao();

        try {
            vegetableDao.updateVegetable(veg);

        }catch( Exception e) {
            e.printStackTrace();

        }
return"redirect:/";
    }

@PostMapping("/delete-vegetable")
public String delete(@RequestParam("id")int id) {

    VegetableDao vegetableDao = new VegetableDao();
    try {

        vegetableDao.deleteVegetable(id);

    } catch (Exception e) {

        e.printStackTrace();

    }

return "redirect:/";
}

@GetMapping("/search")
public String search(@RequestParam("search")String word,Model model){

    List <Vegetable>vegetables = new ArrayList<Vegetable>();


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


        model.addAttribute("vegetable",vegetables);



    }catch(Exception e){

        e.printStackTrace();


    }
return "vegetable";
}
@GetMapping("/image")
public void image(@RequestParam("name")String name, HttpServletResponse response) throws IOException {

    String path ="../../../vegetablestore/src/main/resources/picture/"+ name;

    byte [] image = getImageAsBytes(path);

    response.setContentType("image/jpeg");
    response.setContentLength(image.length);
    response.getOutputStream().write(image);


}

    private byte[] getImageAsBytes(String name) {


        File imgPath = new File(name);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            BufferedImage bufferedImage = ImageIO.read(imgPath);
            ImageIO.write(bufferedImage, "jpg", bos );
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();

    }

    @GetMapping("/log-out")
public String logOut(HttpServletRequest request){

    HttpSession session = request.getSession();
    session.invalidate();

        return "redirect:/";
}


}

