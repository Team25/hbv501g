<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Employee</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/createEmployee.css"/>"/> 
</head>
<body>
	<div class="container">
		<sf:form action="/employee/create" method="POST" commandName="employee">
			<h1>Create Employee</h1>
			<table>
				<tr>
					<div class="form-group">
						<td><label for="full_name">Full Name:</label></td>
						<td><sf:input path="fullName" type="text" id="full_name" name="full_name" placeholder="Full name" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label for="userId">User name:</label></td>
						<td><sf:input path="loginName" type="text" id="userId" name="userId" placeholder="user name" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label for="password">Password:</label></td>
						<td><sf:input path="loginPassword" type="password" id="password" name="password" placeholder="password" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Social Security</label></td>
						<td><sf:input path="socialSecurity" type="text" id="social_security" name="social_security" placeholder="000000-0000" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Phone number:</label></td>
						<td><sf:input path="phoneNumber" type="text" id="phone_number" name="phone_number" placeholder="588-5522" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Home Address:</label></td>
						<td><sf:input path="homeAddress" type="text" id="home_address" name="home_address" placeholder="Home Address" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Date of Employment:</label></td>
						<td><fmt:formatDate value="${employee.dateOfEmployment}" var="dateString" pattern="dd/MM/yyyy" /> 
						<sf:input path="dateOfEmployment" type="text" value = "${dateString}" id="first_day" name="first_day" placeholder="dd/mm/yyyy" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Hourly Rate:</label></td>
						<td><sf:input path="hourlyRate" type="text" id="hourly_rate" name="hourly_rate" class="form-control"/> kr/hour </td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Default Department:</label></td>
						<td><sf:input path="defaultDepartment" type="text" id="default_department" name="default_department" placeholder="batman department" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><label>Admin privileges:</label></td>
						<td><sf:checkbox path="isAdmin" id="is_admin" class="form-control"/></td>
					</div>
				</tr>
				<tr>
					<td><button id="createButton" class="form-control">Create</button></td>
				</tr>
			</table>
		<div class="message">
		 	${createMessage}
		 </div>
		</sf:form>
		<div class="navbar">
			<a href="/employee/view/all"><button>Back to employees overview</button></a>
			<a href="/clock"><button>Return to clock page</button></a>		
		</div>
	</div>
</body>
</html>