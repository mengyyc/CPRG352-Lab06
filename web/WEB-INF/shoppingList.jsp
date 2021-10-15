<%-- 
    Document   : shppingList
    Created on : 14-Oct-2021, 11:35:41 AM
    Author     : lixia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Shopping List</title>
	</head>
	<body>
		<h1>Shopping List</h1>
		<p>Hello, ${user.username}</p>
		<a href="ShoppingList?action=logout">Logout</a>
		<h3>List</h3>

		<form action="" method="POST">
			<label>Add Item: </label>
			<input type="text" value="" name="item" />
			<input type="submit" value="Add" />
			<input type="hidden" value="add" name="action" />
		</form>

		<form action="" method="POST">
			<span>page ${page}</span> | <span>page size ${pagesize}</span>
		<ul>
			<c:forEach var="item" items="${displaylist}">
				<li>
					<input type="radio" value="${item}" name="item" />
					${item}
				</li>
			</c:forEach>
		</ul> 
		<c:if test="${page > 1}">
			<form action="" method="post"> 
				<input type="submit" value="Back" />
				<input type="hidden" name="page" value="${page - 1}" />
			</form>
		</c:if>

		<c:if test="${page < lastpage}">
			<form action="" method="POST"> 
				<input type="submit" value="Next" />
				<input type="hidden" name="page" value="${page + 1}" />
			</form>
		</c:if>

		<br>
		<form action="" method="POST">
			<input type="submit" value="Delete" />
			<input type="hidden" value="delete" name="action" />
		</form>
	</body>
</html>
