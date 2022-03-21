<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>
<body>
    <center>
        <div class="container">
        <form class="signUp" method="post" action="/login">
            <h2 class="form-signin-heading">Please sign up</h2>
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
            </p>
            <input name="role" type="hidden" value="USER">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
        </form>
        </div>
    </center>
</body>
</html>