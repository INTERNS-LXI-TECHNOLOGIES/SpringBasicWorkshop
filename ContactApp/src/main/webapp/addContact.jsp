<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>AddContact</title>
</head>
<body>
	<form id="login-form" class="form" modelAttribute="contact" action="addContact" method="GET">
        <h3 class="text-center text-info">Add Contact</h3>
        <div class="form-group">
            <label for="name" class="text-info">Enter the Name</label><br>
            <input type="name" name="name" id="name" class="form-control">
        </div>
        <div class="form-group">
            <label for="number" class="text-info">Enter the Number</label><br>
            <input type="number" name="number" id="number" class="form-control">
        </div>
        <div class="form-group">
            <label for="email" class="text-info">Enter the Email Id</label><br>
            <input type="email" name="email" id="email" class="form-control">
        </div>

        <div class="form-group">           
            <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
        </div>
                          
    </form>
</body>
</html>