<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Question</title>
<body bgcolor="OldLace">
<style>
body {
  background-image: url('Index.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
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
</head>
<body>
    <div align="center">
        <h1>New Question</h1>
        <form:form action="saveExam" method="post" modelAttribute="examModel">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Question:</td>
                <td><form:input path="question" /></td><br>
            </tr>
            <tr>
                <td>Option1:</td>
                <td><form:input path="opt1" /></td><br>
            </tr>
            <tr>
                <td>Option2:</td>
                <td><form:input path="opt2" /></td><br>
            </tr>
            <tr>
                <td>Option3:</td>
                <td><form:input path="opt3" /></td><br>
            </tr>
             <tr>
                <td>Option4:</td>
                <td><form:input path="opt4" /></td><br>
            </tr>
             <tr>
                <td>Answer:</td>
                <td><form:input path="answer" /></td><br>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>