<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/entryList.css"/>"/>
</head>
<body>
<div class="container">
<div class="employeelist">
<table>
	<tr>
		<th>Id</th>
		<th>In Time</th>
		<th>Out Time</th>
		<th>Department</th>
		<th>Is Entry Verified?</th>
	</tr>
	<c:forEach var="listValue" items="${entryList}">
	<tr>
		<td><a href="own/${listValue.id}">View Entry</a></td>
		<td>${listValue.inTime}</td>
		<td>${listValue.outTime}</td>
		<td>${listValue.department}</td>
		<td>
			<c:choose>
    			<c:when test="${listValue.isVerified==true}">
        			Yes
			    </c:when>    
			    <c:otherwise>
			        No 
			    </c:otherwise>
			</c:choose>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
<div class="navbar">
<a href="/clock">Return to clock page</a>
</div>
</div>
</body>
</html>

