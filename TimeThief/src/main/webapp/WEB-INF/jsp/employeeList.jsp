<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/employeeList.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/toolbar.css"/>"/>
</head>
<body>
<%@ include file="toolbars.jsp" %>
<div class="container">
<div class="employeeSearch">
	<form method="get" class="searchForm">
		<input type="text" name="findEmployee" placeholder="Find by name/user" value="${searchString}">
		<input type="submit" value="Search">
	</form>
	${resetButton}
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
		<td>
			<c:choose>
	    		<c:when test="${listValue.isAdmin==true}">Yes</c:when>
				<c:otherwise>No</c:otherwise>
			</c:choose>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
<div class="navbar">
<a href="/employee/create" class="button">Create new employee</a>
</div>
</div>
</body>
</html>

