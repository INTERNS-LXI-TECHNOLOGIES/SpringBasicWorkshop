<!DOCTYPE html>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.model.ExamModel" %>
<html>
<head>
  <title>Questions</title> 
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
  background-color: midnightblue;
  color: white;
  width: 150px;
  height: 40px;
}

</style>
<script>
<!--
<%
String clock = "10";
%>
var timeout = <%=clock%>;
function timer()
{
if( --timeout > 0 )
{
document.getElementById("clock").innerHTML=timeout;
window.setTimeout( "timer()", 1000 );
}
else
{
document.getElementById("clock").innerHTML = "Time over";
document.qform.submit();
///disable submit-button etc
}
}
//-->
</script>

<form action="<%=request.getRequestURL()%>" name="forma">
Seconds remaining: <span id="clock"><%=clock%></span>

</form>
<script>
<!--
timer();
//-->
</script>

</head>
<body>
       <%
       List<ExamModel> questionLists = (List<ExamModel>)session.getAttribute("exam");
       int count=Integer.parseInt(request.getParameter("count"));
       %>
    <div class="wrapper">
        
        <div align="center" style="background-color: grey;" >
            <br>
            <br>
            <h1><font size="50px" color="midnightblue" >Exam Question</font></h1>
            <br>
            <br>
        </div>
        <%if( count< questionLists.size())
            {%>
  <div align="left" style="padding-left: 2%;">
  <form method="GET" action="result">
        <h1><label>Question No <%out.print(count+1+" : "); out.print(questionLists.get(count).getQuestion()); %></label>
        </h1><br>

        <h2><input type="radio" name="option" value="1" id="opt1">
        <label for="option1"><%out.print(questionLists.get(count).getOpt1()); %></label><h2><br>

        <h2><input type="radio"  value="2" name="option" id="opt2" >
        <label for = "option2"><%out.print(questionLists.get(count).getOpt2()); %></label></h2><br>

        <h2><input type="radio"  value="3" name="option" id="opt3" >
        <label for = "option3"><%out.print(questionLists.get(count).getOpt3()); %></label></h2><br>

        <h2><input type="radio"  value="4" name="option" id="opt4" >
        <label for = "option4"><%out.print(questionLists.get(count).getOpt4()); %></label></h2><br>

      <% count++;
      		
       %>
        <div align="center">
        <input type="hidden"class="button" name="count" value=<%out.println(count);%>>       
       <button type="submit">Next</button>
             
    </div>
        </form>
       <%
        }
        else
        {
            response.sendRedirect("resultPage");
        }
    %>
    
</div>
</body>
</html>
