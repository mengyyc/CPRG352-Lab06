<%-- 
    Document   : register
    Created on : 14-Oct-2021, 11:35:26 AM
    Author     : lixia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
	</head>
	<body>
		<h1>Shopping List</h1>
		<form action="ShoppingList" method="POST">
			<label>Username: </label>
			<input type="text" name="username" />
			<input type="hidden" name="action" value="register" />
			<br>

			<input type="submit" value="Register name" />
		</form>
	</body>
</html>
