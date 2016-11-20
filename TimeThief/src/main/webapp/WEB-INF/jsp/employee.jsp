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
<ul>
	<li>${employee.fullName}</li>
	<li>${employee.loginName}</li>
	<li>${employee.socialSecurity}</li>
	<li>${employee.phoneNumber}</li>
	<li>${employee.homeAddress}</li>
	<li>${employee.dateOfEmployment}</li>
	<li>${employee.hourlyRate}</li>
	<li>${employee.defaultDepartment}</li>
</ul>
</div>
<div class="navbar">
<a href="/employee/update">Update employee</a>
<a href="/clock">Return to clock page</a>
</div>
</div>
</body>
</html>

