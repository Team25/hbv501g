<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/clock.css"/>"/>
<title>Clock in/out</title>
</head>
<body>
	<div class="admin-toolbar">
		${adminToolbar}
	</div>
	<div class="container">
		<h1>${user}</h1>
		<div class="status-box">
			${clockInInfo}
		</div>
		<sf:form action='clock' id='clock-form' method="POST">
			<div class="form-group">
				<label for="department">Department:</label>
				<select form='clock-form' name='department' id='department'>
					<option value="Overlord">Overlord</option>
					<option value="BigBossDepartment">BigBossDepartment</option>
					<option value="JokerDepartment">JokerDepartment</option>
					<option value="BatmanDepartment">BatmanDepartment</option>
				</select>
			</div>
			<button id="clockButton" class="form-control">${clockStatus }</button>
		</sf:form>
		<p>${loginFeedback}</p>
	</div>
	
</body>
</html>
