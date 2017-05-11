<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>Success Page</h4>

	success.jsp
	<label>${user.name}</label>

	<form class="form-signin" role="form" action="shopping/getall">
		<input type="hidden" name="name" value="${user.name}">
		<button class="btn btn-lg btn-primary btn-block" type="submit">go
			shopping</button>
	</form>
</body>
</html>

