<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
<!--
<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/> 
-->
</head>
<body>
	<div class="container">
		<sf:form action="/employee/update/${employeeId }" method="POST" commandName="employee">
			<h1>Update employee: ${employeeToUpdate.fullName}</h1>
			
			<div class="form-group">
				<sf:input path="id" type="hidden" id="id" name="id" value="${employeeToUpdate.id }" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="full_name">Full Name:</label>
				<sf:input path="fullName" type="text" id="full_name" name="full_name" value="${employeeToUpdate.fullName }" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="userId">User name:</label>
				<sf:input path="loginName" type="text" id="userId" name="userId" value="${employeeToUpdate.loginName }" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<sf:input path="loginPassword" type="password" id="password" name="password" value="${employeeToUpdate.loginPassword }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Social Security</label>
				<sf:input path="socialSecurity" type="text" id="social_security" name="social_security" value="${employeeToUpdate.socialSecurity }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Phone number:</label>
				<sf:input path="phoneNumber" type="text" id="phone_number" name="phone_number" value="${employeeToUpdate.phoneNumber }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Home Address:</label>
				<sf:input path="homeAddress" type="text" id="home_address" name="home_address" value="${employeeToUpdate.homeAddress }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Date of Employment:</label>
				<fmt:formatDate value="${employeeToUpdate.dateOfEmployment}" var="dateString" pattern="dd/MM/yyyy" /> 	 
				<sf:input path="dateOfEmployment" type="text" id="first_day" name="first_day" value="${employeeToUpdate.dateOfEmployment }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Hourly Rate:</label>
				<sf:input path="hourlyRate" type="text" id="hourly_rate" name="hourly_rate" value="${employeeToUpdate.hourlyRate }" class="form-control"/> kr/hour
			</div>
			<div class="form-group">
				<label>Default Department:</label>
				<sf:input path="defaultDepartment" type="text" id="default_department" name="default_department" value="${employeeToUpdate.defaultDepartment }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Admin privileges:</label>
				<sf:checkbox path="isAdmin" id="is_admin" value="${employeeToUpdate.isAdmin }" class="form-control"/>
			</div>
			
			<button id="createButton" class="form-control">Update</button>
		</sf:form>
		<div class="message">
		 	${updateMessage}
		 </div>
	</div>
</body>
</html>