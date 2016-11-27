<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/allEntryList.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/toolbar.css"/>"/>
</head>
<body>
		<%@ include file="../toolbars.jsp" %>
<div class="container">
<div class="employeelist">
<table>
	<tr>
		<th>Link</th>
		<th>In Time</th>
		<th>Out Time</th>
		<th>Department</th>
		<th>Is Entry Verified?</th>
	</tr>
	<c:forEach var="listValue" items="${entryList}">
	<tr>
		<td><a href="all/${listValue.id}">View Entry</a></td>
		<td>
			<fmt:formatDate value="${listValue.inTime}" pattern="yyyy-MM-dd HH:mm"/>
		</td>
		<td>
			<fmt:formatDate value="${listValue.outTime}" pattern="yyyy-MM-dd HH:mm"/>
		</td>
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
</div>
</body>
</html>
