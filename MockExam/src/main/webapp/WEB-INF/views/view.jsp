<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ADMIN</title>


</head>
<body>
		<div id="addProblem">
			<a href="add"><button class="button1">Add Question</button></a>
		</div>

		<div id="view">
		<table id="pager" border="2px" width="100%">
		<tr>
			<th>SL.NO</th>
			<th>ID</th>
			<th>QUESTION</th>
			<th>OPT_1</th>
			<th>OPT_2</th>
			<th>OPT_3</th>
			<th>OPT_4</th>
			<th>ANSWER</th>
		</tr>
		<c:forEach var = "quest" items = "${questionList}">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><button>Delete</button></td>
				<td><button>Update</button></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>