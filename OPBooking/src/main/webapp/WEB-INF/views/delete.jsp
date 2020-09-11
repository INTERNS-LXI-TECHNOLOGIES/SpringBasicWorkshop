<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>


</head>
<body>
<div>
<h1>Confirm Delete!</h1>
<a href="delete?id=${qId}"><button>Yes</button></a>
<a href="view"><button>No</button></a>
</div>

</body>
</html>