<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<style>
		    .links, .links a {color: #979da3; text-decoration: none;}
			input {text-transform: uppercase;}
		</style>
	</head>
	<body style="margin:0;background: #e6f0e9;">
		<div
			style="background: #0a3939; color: white; text-align: center; padding: 9px; text-transform: uppercase;">
			<h1>Used Car Showroom Application</h1>
			<h2 class="links">
				<a href="${contextPath}">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="create">Add New Car</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="logout">Logout</a>
			</h2>
		</div>
		<div align="center">
			<c:if test="${car != null}">
				<form action="${contextPath}/update" method="post">
	        </c:if>
	        <c:if test="${car == null}">
				<form action="${contextPath}/insert" method="post">
	        </c:if>
		        <table border="1" cellpadding="5" cellspacing="0" style="text-transform: uppercase;">
		            <caption>
		            	<h2>
		            		<c:if test="${car != null}">
		            			EDIT CAR
		            		</c:if>
		            		<c:if test="${car == null}">
		            			ADD NEW CAR
		            		</c:if>
		            	</h2>
		            </caption>
		        		<c:if test="${car != null}">
		        			<input type="hidden" name="carId" value="${car.carId}" />
		        		</c:if>            
		            <tr>
		                <th>Manufacturer</th>
		                <td>
		                	<input type="text" name="manufacturer" value="${car.manufacturer}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Model</th>
		                <td>
		                	<input type="text" name="model" value="${car.model}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Variant</th>
		                <td>
		                	<input type="text" name="variant" value="${car.variant}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Year</th>
		                <td>
		                	<input type="text" name="year" value="${car.year}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Total Kilometers</th>
		                <td>
		                	<input type="text" name="totalKilometers" value="${car.totalKilometers}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Expected Price</th>
		                <td>
		                	<input type="text" name="expectedPrice" value="${car.expectedPrice}" />
		                </td>
		            </tr>
		            <tr>
		                <th>Other Details</th>
		                <td>
		                	<input type="text" name="otherDetails" value="${car.otherDetails}" />
		                </td>
		            </tr>
		            <tr>
		            	<td colspan="2" align="center">
		            		<input type="submit" value="Save" style="background: #040505; color: white; border-radius: 12px; padding: 6px 12px;" />
		            	</td>
		            </tr>
		        </table>
	        </form>
	    </div>	
	</body>
</html>