<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Sign Up</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <!--Stylesheet-->
    <style media="screen">
      *,
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body{
    background-color: #080710;
}
.background{
    width: 430px;
    height: 520px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
}
</style>
</head>
<body>
	<div class="background"></div>
	<div>
		<center>
			<form action="userRegistration" method="post" modelAttribute="user" modelAttribute="role">
			<label for="username">Username</label>
			<input type="text" name="username" placeholder="Username" id="username">
			<label for="password">Password</label>
			<input type="text" name="password" placeholder="Password">
			<button class="btn">Sign Up</button>			
			</form>
		</center>
	</div>
</body>
</html>