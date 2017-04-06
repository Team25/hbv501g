<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/resetPassword.css"/>"/>
</head>
<body>
	<div class="pass">
	<p>Please enter your username to receive a new password in your mailbox.<p>
		<sf:form action='resetPW' method="POST">
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control"/>
			<button id="loginButton" class="form-control">Reset</button>
		</sf:form>
			<div class="message">
		 		${Error}
			</div>
     	 </div>
	</div>





</body>
</html>