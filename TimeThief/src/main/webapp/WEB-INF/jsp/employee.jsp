<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/employee.css"/>"/>
</head>
<body>
<div class="container">
<div class="employee_information">
<ul>
	<li>Full name: ${employee.fullName}</li>
	<li>Login name: ${employee.loginName}</li>
	<li>Social Security number: ${employee.socialSecurity}</li>
	<li>Phone number: ${employee.phoneNumber}</li>
	<li>Home address: ${employee.homeAddress}</li>
	<li>Date of employment: ${employee.dateOfEmployment}</li>
	<li>Hourly rate: ${employee.hourlyRate}</li>
	<li>Default department: ${employee.defaultDepartment}</li>
</ul>
</div>
<div class="navbar">
	<a href="/employee/update/${employee.id}">Update employee</a>
	<a href="/clock">Return to clock page</a>
	<div class="admin-toolbar">
		${adminToolbar}
	</div>
</div>
</div>
</body>
</html>

