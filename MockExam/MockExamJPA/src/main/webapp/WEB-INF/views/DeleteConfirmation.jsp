<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="com.lxisoft.model.*"%>
	<title>Confirmation</title>
	<style>
.container {
  height: 700px;
  position: relative;
  border: 5px solid oldlace;
}
.center {
  margin: 0;
  position: absolute;
  top: 25%;
  left: 30%;
  -ms-transform: translate(-30%, -30%);
  transform: translate(-20%, -20%);
}
.button_css
{
  background-color: grey;
  color: white;
  width: 140px;
  height: 40px;
}
</style>
</head>
<body>
<div align="center" style="background-color: grey;" >
            <br>
            <br>
            <h1><font size="50px" color="midnightblue" >Confirmation </font></h1>
            <br>
            <br>
        </div>
       
         
    <H3>Are you sure to delete?</H3>
    <form>
            <c:forEach var="examModel" items="${listExam}">
				<tr>

					<td>${examModel.question}</td>
					<td>${examModel.opt1}</td>
					<td>${examModel.opt2}</td>
					<td>${examModel.opt3}</td>
					<td>${examModel.opt4}</td>
					<td>${examModel.answer}</td>
					<td><<a href="deleteExam?id=${examModel.id}">YES<a>
					</td>

				</tr>
			</c:forEach>
			</form>
<form>
<center><button type="submit" formaction="deleteExam?id=${examModel.id}" class="button_css">yes</button></center>

 <center><button type="submit" formaction="firstpage" class="button_css">NO</button></center></form>
</body>
</html>