<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
</head>
<body>
<div class="container">
<div class="employeelist">
<c:forEach var="listValue" items="${employeeList}">
	<li>${listValue}</li>
</c:forEach>
</div>
<div class="navbar">
<a href="/employee/create">Create new employee</a>
<a href="/clock">Return to clock page</a>
</div>
</div>
</body>
</html>

