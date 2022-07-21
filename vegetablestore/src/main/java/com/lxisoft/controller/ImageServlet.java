package main.java.com.lxisoft.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ImageServlet extends HttpServlet {

 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws IOException, ServletException
{

String name = request.getParameter("name");
System.out.println(name);
String path ="../../../vegetablestore/src/main/resources/picture/"+ name;
 
byte [] image = getImageAsBytes(path);

response.setContentType("image/jpeg");
	response.setContentLength(image.length);

	response.getOutputStream().write(image);		


}

private byte[] getImageAsBytes(String name) {
      

 File imgPath = new File(name);
 System.out.println(
 "can read: "+imgPath.canRead()+"\n"+
 "exists: "+imgPath.exists()+"\n"+
 "absolute path: "+imgPath.getAbsolutePath()+"\n"+
 "file? :"+imgPath.isFile()+"\n"
 );
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


}