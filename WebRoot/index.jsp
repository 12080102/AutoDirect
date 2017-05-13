<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login here</title>
<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen" />
<link href="themes/css/base.css" rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container">
		<form class="form-signin" role="form" action="helloworld">
			<div class="control-group col-md-6">
			<h2 class="form-signin-heading">Login</h2>
			<input type="text" name="name" class="form-control"
				value="Atelier graphique" placeholder="Username here" required
				autofocus> <input type="password" name="password"
				class="form-control" value="123" placeholder="Password here"
				required autofocus>
</div>
			<div class="control-group col-lg-2">
				<button class="btn btn-lg btn-primary" type="submit">Login</button>
			</div>
		</form>
		<a href="index.html">SSO - </a>
		<button type="submit" id="btn-logout">Sign Out</button>
	</div>
	<script src="//cdn.auth0.com/js/lock/10.13/lock.min.js"></script>
	<script src="auth0-variables.js"></script>

	<script src="app.js"></script>
</body>
</html>