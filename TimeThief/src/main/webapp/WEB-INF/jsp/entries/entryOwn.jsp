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
<table>
	<ul>
		<li>In Time: ${entry.inTime}</li>
		<li>Out Time: ${entry.outTime}</li>
		<li>Department: ${entry.department}</li>
		<li>
			<c:choose>
    			<c:when test="${entry.isVerified==true}">
        			Entry has been verified.
			    </c:when>    
			    <c:otherwise>
			        Entry is not verified.
			    </c:otherwise>
			</c:choose>
		</li>
	</ul>
	<c:forEach var="listValue" items="${entry.comments}">
	<div class="comment">
		<h3>${listValue.employeeId}</h3>
		<p>${listValue.text}</p>
	</div>
	</c:forEach>
</table>
</div>
<div class="navbar">
<a href="/clock">Return to clock page</a>
</div>
</div>
</body>
</html>

