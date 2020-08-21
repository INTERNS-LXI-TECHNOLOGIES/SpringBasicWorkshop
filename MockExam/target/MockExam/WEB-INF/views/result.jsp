
<%@ page import = "com.lxisoft.model.*"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Mock Exam</title>
  <style>
    body{
     background-color: lightblue; 
    /* margin-top:250px;*/
    /* text-align:center;*/
    }

    a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 20px;
}

    h1 {
        color: black;
        text-align: center;
        font-family: verdana;
      }
  .button {
  background-color: #4CAF50;
  border: none;
  color: white;

   border-radius: 5px;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
} 
.button:hover {  background-color: black; }
.button2 {background-color: #4CAF50;} 
.button2:hover {  background-color: #f44336;}

.search-container {  float: right;}

.search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #4CAF50;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

  


  </style>
  </head>
<body>
<%  ArrayList<String> anslist = new ArrayList<String>();
 anslist	= (ArrayList<String>)session.getAttribute("ansSelected");%>
<% int mark = Integer.parseInt(request.getAttribute("totalScore").toString()); %>

<li><h1> Thank U For Attending The Exam </h1></li>
        <li><h1> You Got <%out.println(mark);%> Marks.</h1></li>

        <%
   
   if(mark >=1)
   {
    %>
    <h1><%out.println("Congratulations....");%></h1>
    <h1><%out.println("Exam Passed");%></h1>
   <%
   }
   else
   {
    %>

    <h1><%out.println("!! Sorry !!");%></h1><br>
    <h1><%out.println("Exam Failed");%></h1>
   <%
   }
   %>
   <h3>Your Answers Are </h3>
   <table id="pager" border="2px" width="100%">
   		<tr>
   			<th>SL.NO</th>
   			<th>QUESTION</th>
   			<th>Option Selected</th>
   			<th>Answer</th>
   		</tr>
    	<%
    		ArrayList<Problem> questions = new ArrayList<Problem>();
        	questions = (ArrayList<Problem>)session.getAttribute("qList");
           	for (int i=0;i<questions.size();i++)
                				{%>

                				<tr>
                			<td><%out.println(questions.get(i).getId());%></td>
                			<td><%out.println(questions.get(i).getQuestion());%></td>
                			<% String selected = anslist.get(i);
                       			if(selected.equals(1))
                       			{%><td><%out.println(questions.get(i).getOption1());%></td><%
                       			if(selected.equals(questions.get(i).getAnswer()))
                       			{%><td><%out.println("True");%></td><%}
                       			else
                       			{%><td><%out.println("False");%></td><%}
                       			}
                       			 else if(selected.equals(2))
                       			{%><td><%out.println(questions.get(i).getOption2());%></td><%
                       			if(selected.equals(questions.get(i).getAnswer()))
                         			{%><td><%out.println("True");%></td><%}
                           			else
                           			{%><td><%out.println("False");%></td><%}
                                 }
                       			else if(selected.equals(3))
                       			{%><td><%out.println(questions.get(i).getOption3());%></td><%
                       			if(selected.equals(questions.get(i).getAnswer()))
                           			{%><td><%out.println("True");%></td><%}
                           			else
                         			{%><td><%out.println("False");%></td><%}
                          			}
                            	else if(selected.equals(4))
                    			{%><td><%out.println(questions.get(i).getOption4());%></td><%
                    			if(selected.equals(questions.get(i).getAnswer()))
                         			{%><td><%out.println("True");%></td><%}
                          			else
                          			{%><td><%out.println("False");%></td><%}
                           			}
                       			 %>
                			</tr>
                                    			<%}%>
   <br>
        
  <a href="home"><!-- <button type="submit">Home</button> --><input type="submit" class="button" value="Home"></a>

</body>
</html>