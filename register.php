<?php include('server.php') ?>

<!DOCTYPE html>
<html>
<head>
	<title>Chamna</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="header">
		<h2>SignUp</h2>
	</div>
	<form method="post" action="register.php">
		<?php include('errors.php')  ?>
		<div class="input-group">
			<label>Name</label>
			<input type="text" name="name"/>
		</div>
		<div class="input-group">
			<label>Username</label>
			<input type="text" name="username"/>
		</div>
		<div class="input-group">
			<label>Email</label>
			<input type="Email" name="email"/>
		</div>
		<div class="input-group">
			<label>Password</label>
			<input type="Password" name="password_1" />
		</div>
		<div class="input-group">
			<label>Confirm Password</label>
			<input type="Password" name="password_2" />
		</div>
		<div class="input-group">
			<button type="submit" class="btn"
			 name="reg_user">SignUp</button>
		</div>
		<p>Already a member ?<a href="login.php">Log In</a></p>
	</form>

</body>
</html>