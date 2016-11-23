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
<div class="employeeSearch">
	<form method="get">
		<input type="text" name="findEmployee" placeholder="Find by name/user">
		<input type="submit" value="Search">
	</form>
</div>
<div class="employeelist">
<table>
	<tr>
		<th>Full Name</th>
		<th>Login Name</th>
		<th>Social Security</th>
		<th>Phone Number</th>
		<th>Default Department</th>
		<th>Admin?</th>
	</tr>
	<c:forEach var="listValue" items="${employeeList}">
	<tr>
		<td><a href="${listValue.id}">${listValue.fullName}</a></td>
		<td>${listValue.loginName}</td>
		<td>${listValue.socialSecurity}</td>
		<td>${listValue.phoneNumber}</td>
		<td>${listValue.defaultDepartment}</td>
		<td>${listValue.isAdmin}</td>
	</tr>
	</c:forEach>
</table>
</div>
<div class="navbar">
<a href="/employee/create">Create new employee</a>
<a href="/clock">Return to clock page</a>
</div>
</div>
</body>
</html>

