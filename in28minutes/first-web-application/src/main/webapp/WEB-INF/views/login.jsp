<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<form action="/login" method="post">
			<p><font color="red">${errorMessage}</font></p>
			<p>Name: <input type="text" name="name" /></p>
			<p>Password: <input type="password" name="password" /></p> 
			<p><input type="submit" value="Login" /></p>
		</form>
	</body>
</html>