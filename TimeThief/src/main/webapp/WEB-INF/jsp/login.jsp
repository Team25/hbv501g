<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
</head>
<body>
	<div class="container">
	<img class="header-text" src="/Images/timethtransp.png" />
      <div class="middler">
		<sf:form action='login' method="POST">
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control"/>
			<input type="password" id="password" name="password" placeholder="password" class="form-control"/>
			<button id="loginButton" class="form-control">Login</button>
		</sf:form>
		<div class="message">
		 	${loginError}
		</div>
      </div>
	</div>
</body>
</html>