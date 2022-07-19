<html>


<head>

<style>
   h1{
color:white;	
background-color:red;
font-size:40px;
height:65px;
width:1200px;
padding : 13px;
}
table{
border:none;
}
th,td{
  padding : 9px;
}
.subBtn{

   background-color:blue;
  color : white;
  border: none;
  border-radius:10px;
  width:70px;
  height:30px

}
.homeBtn{
margin:50px;


}

</style>


   <%@ page import="main.java.com.lxisoft.vegetable.Vegetable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

</head>
<body>

<center><h1>VEGETABLE UPDATE FORM</h1></center>


<a href = "vegetable-list"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
</a>
   
   <form action ="<%=request.getContextPath() %>/update-vegetable" method ="post">


   <%List<Vegetable> vegetables = (ArrayList<Vegetable>)request.getAttribute("vegetable");

 
      for (Vegetable vegetable : vegetables) {%>

<center>
<table style = "width: 80%">

  
   <td><input type = "hidden" name = "id" value =<%=vegetable.getId()%>></td>
   </tr>
   
   <tr>

      <td>Enter Name</td>
      <td><input type = "text" name = "name" value =<%=vegetable.getName()%>></td>
      </tr>
      
      <tr> 
      <td>Enter Price </td>
      <td><input type = "text" name = "price"  value =<%=vegetable.getPrice()%>></td>
    </tr>
    
    <tr>
    <td>Enter Stock</td>
    <td><input type = "text" name = "stock"  value =<%=vegetable.getStock()%>></td>
    </tr>
    
    <tr>
    <td>Enter OrderQuantity</td>
    <td><input type = "text" name = "orderQuantity"  value =<%=vegetable.getOrderQuantity()%>></td>
    </tr>
    
     </table>
     
     <input type = "submit" value = "submit" class ="subBtn"/>
     
    

 </center>

 <%}%>
</body>
</html>