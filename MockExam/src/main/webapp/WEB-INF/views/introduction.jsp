
<!DOCTYPE HTML>
<html>
  <head>
    <title>Mock Exam</title>
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
<h1>Mock Exam</h1>
<h2>Instructions</h2>


 
 <form action="getQueslist" method="GET">
  
  <h3>1.Students  should take Hallticket</h3>
  <h3>2.Student should have ID cards</h3>
   <h3>3...................</h3>
   <h3>4...................</h3>
   <h3>5...................</h3>
   
  <input type="hidden" name="count" value="0">
  <button class="button">Start Exam</button>
 
		</form>
      <button class="button">Create New User</button>
</body>
</html>