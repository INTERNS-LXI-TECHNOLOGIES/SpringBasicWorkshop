<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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




  </style>
<head>
<meta charset="UTF-8">
<title>Delete</title>


</head>
<body>
<div>
<h1>Confirm Cancel..!</h1>
<a href="deleteuser?id=${uId}"><button>Yes</button></a>
<a href="admin"><button>No</button></a>
</div>

</body>
</html>