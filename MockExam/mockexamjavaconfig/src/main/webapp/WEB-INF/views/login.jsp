<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link href='<c:url value="resources/css/logincss.css"></c:url>' rel="stylesheet" type="text/css"/>
</head>
<body onload='document.loginForm.username.focus();'>
    <div class="login-page">
    	<c:if test="{not empty errorLogin}">
    		<div class="errormsg">${errorLogin}</div>
    	</c:if>
    	<c:if test="{not empty logoutMsg}">
    		<div class="logoutmsg">${logoutMsg}</div>
    	</c:if>
      <div class="form">
        <form name='loginForm' action="${pageContext.request.contextPath}/login" method="POST" class="login-form">
           <input type="text" name="username" placeholder="username" required="required" />
           <input type="password"  name="password" placeholder="password" required="required" />
           <button>login</button>
           <p class="message">Not registered? <a href="${pageContext.request.contextPath}/register">Register</a></p>
        </form>
     </div>
   </div>
<script type="text/javascript" href="sample.js"></script>
</body>
</html>
