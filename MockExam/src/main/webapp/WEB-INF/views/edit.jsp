<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>Edit</title>
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



      .pagination {  display: inline-block; }

    .pagination a {
      color: black;
      float: left;
      padding: 8px 16px;
      text-decoration: none;
    }

    .pagination a.active {  background-color: #4CAF50;
      color: white; }

    .pagination a:hover:not(.active) {background-color: #ddd;}

      </style>
</head>
<body>

		<div class="container">
			<h2>EDIT QUESTION</h2>
			<form:form action="edit" method="GET" modelAttribute="questById">
				<table>
					<tr>
						<td>ID .:</td>
						<td><form:input path="id"  readonly="readonly" /></td>
					</tr>
					<tr>
						<td>QUESTION:</td>
						<td><form:input path="question"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-1:</td>
						<td><form:input path="option1"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-2:</td>
						<td><form:input path="option2"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-3:</td>
						<td><form:input path="option3"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-4:</td>
						<td><form:input path="option4"  required="required"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><form:input path="answer"  required="required"/></td>
					</tr>
					<tr>
						<td colspan = "2" align = "center" ><button type = "submit" onclick="myFunction()">Save</button></td>
					</tr>
				</table>
			</form:form>
		</div>
		<script type="text/javascript">

			function myFunction()
			{
				confirm("Edited Successfully.....");
			}

		</script>
</body>
</html>