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
	<h1>${user}</h1>
	
	<sf:form action='clock' id='clock-form' method="POST">
		<select form='clock-form' name='department' id='department'>
  			<option value="Overlord">Overlord</option>
  			<option value="BigBossDepartment">BigBossDepartment</option>
  			<option value="JokerDepartment">JokerDepartment</option>
  			<option value="BatmanDepartment">BatmanDepartment</option>
		</select>
		<button id="clockButton" class="form-control">${clockStatus }</button>
	</sf:form>
	${loginFeedback }
</div>
<div class="admin-toolbar">
${adminToolbar}
</div>
</div>
</body>
</html>
