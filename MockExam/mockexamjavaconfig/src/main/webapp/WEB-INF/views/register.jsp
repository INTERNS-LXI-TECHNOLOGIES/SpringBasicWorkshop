<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
  <link href='<c:url value="resources/css/logincss.css"></c:url>' rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="login-page">
      <div class="form">
        <form action="userRegistration" method="GET" class="login-form">
           <input type="text" name="uname" placeholder="name" autocomplete="off" required="required" />
          <input type="password" name="pass" placeholder="password" autocomplete="off" required="required" />
           <button>Register</button>
           <p class="message">Already registered? <a href="login.jsp">Login</a></p>
        </form>
     </div>
   </div>
<script type="text/javascript" href="sample.js"Lo></script>
</body>
</html>
