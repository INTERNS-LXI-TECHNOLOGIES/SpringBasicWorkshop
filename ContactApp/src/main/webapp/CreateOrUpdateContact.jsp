<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>Contact Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	</head>
	<body>

	  <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href=" " class="navbar-brand"> Contact App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/home" class="nav-link">contact</a></li>
                    </ul>
                </nav>
            </header>
            <br>

		<div

			<h2 class="links">
				<a href="${contextPath}">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/create">Add New Contact</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/logout">Logout</a>
			</h2>
		</div>
		<div align="center">
			<form:form action="${contextPath}/${action}" method="post" modelAttribute="contact">
		        <table border="1" cellpadding="5" cellspacing="0" style="text-transform: uppercase;">
		            <caption>
		            	<h2>
		            		<c:if test="${action == 'update'}">
		            			EDIT CONTACT
		            		</c:if>
		            		<c:if test="${action == 'insert'}">
		            			ADD NEW CONTACT
		            		</c:if>
		            	</h2>
		            </caption>
		            <tr>
		            	<form:hidden path="id"/>
		                <th>FirstName</th>
		                <td>
		                	<form:input path="fname"/>
		                </td>
		            </tr>
		            <tr>
		                <th>LastName</th>
		                <td>
		                	<form:input path="lname"/>	
		         	   	</td>
		            </tr>
		            <tr>
		                <th>Email</th>
		                <td>
		                	<form:input path="email"/>
		                </td>
		            </tr>
		            <tr>
		                <th>PhoneNumber</th>
		                <td>
		                	<form:input path="phn"/>
		                </td>
		            </tr>
		            
		            <tr>
		            	<td colspan="2" align="center">
		            		<input type="submit" value="Save" style="background: #040505; color: white; border-radius: 12px; padding: 6px 12px; cursor: pointer;" />
		            	</td>
		            </tr>
		        </table>
	        </form:form>
	    </div>	
	</body>
</html>
