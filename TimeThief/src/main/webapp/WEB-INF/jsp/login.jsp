<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
${loginError}
<div class="form-group form">
	<sf:form action='login' method="POST">
		<div>
			<label>User name:</label>
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control"/>
		</div>
		<button id="loginButton" class="form-control">Login</button>
	</sf:form>
</div>
</div>
</body>
</html>