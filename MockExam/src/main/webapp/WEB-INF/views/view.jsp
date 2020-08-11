
<%@ page import = "com.lxisoft.model.*"%>
<%@page import = "java.util.*" %>
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
			<th>OPTION_1</th>
			<th>OPTION_2</th>
			<th>OPTION_3</th>
			<th>OPTION_4</th>
			<th>ANSWER</th>
		</tr>
		<%
        				ArrayList<Problem> questions = new ArrayList<Problem>();
        				questions = (ArrayList<Problem>)session.getAttribute("qList");
        				if(questions.size() == 0)
        				{%>
        				<script type="text/javascript">
        					window.alert("No Records To Display");
        				</script>
        			<%}
        			else
        			{
        				for (int i=0;i<questions.size();i++)
        				{%>

        				<tr>
        				<td><%out.println(i+1);%></td>
        			<td><%out.println(questions.get(i).getId());%></td>
        			<td><%out.println(questions.get(i).getQuestion());%></td>
        			<td><%out.println(questions.get(i).getOption1());%></td>
        			<td><%out.println(questions.get(i).getOption2());%></td>
        			<td><%out.println(questions.get(i).getOption3());%></td>
        			<td><%out.println(questions.get(i).getOption4());%></td>
        			<td><%out.println(questions.get(i).getAnswer());%></td>
        			<td><a href="${pageContext.request.contextPath}/updateQuestion?
        					id=<%=questions.get(i).getId()%>"
        				><button>Update</button></a></td>
        			<td><a href="${pageContext.request.contextPath}/deleteQuestion?
        					id=<%=questions.get(i).getId()%>"><button>Delete</button></a></td>
        			</tr>
        			<%}
        			}%>
		</table>
	</div>
</body>
</html>