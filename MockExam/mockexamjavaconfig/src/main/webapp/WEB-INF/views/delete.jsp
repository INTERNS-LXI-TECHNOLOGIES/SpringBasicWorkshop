<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
	
		<link href='<c:url value="resources/css/deletecss.css"></c:url>' rel="stylesheet" type="text/css"/>
		
</head>
<body onload = toggleModal()>
 	   <div class="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h1>Confirm Delete!</h1>
            <a href="${pageContext.request.contextPath}/delete?
					id=${qId}"><button>Yes</button></a>
            <a href="${pageContext.request.contextPath}/admin"><button>No</button></a>
        </div>
    </div>
    <script type="text/javascript">
    
	
    var modal = document.querySelector(".modal");
    var trigger = document.querySelector(".trigger");
    var closeButton = document.querySelector(".close-button");

    function toggleModal() {
        modal.classList.toggle("show-modal");
    }

    function windowOnClick(event) {
        if (event.target === modal) {
            toggleModal();
        }
    }

    trigger.addEventListener("click", toggleModal);
    closeButton.addEventListener("click", toggleModal);
    window.addEventListener("click", windowOnClick);
	

    </script>
</body>
</html>