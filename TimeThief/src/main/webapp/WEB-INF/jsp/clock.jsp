<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
${clockInInfo}
<div class="form-group form">
	<h1>Welcome ${user}</h1>
	<sf:form action='clock' method="POST">
		<button id="clockButton" class="form-control">Clock</button>
	</sf:form>
</div>
</div>
</body>
</html>