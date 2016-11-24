<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/entryOwn.css"/>"/>
</head>
<body>
	<div class="container">
	  <h1>Entry overview</h1>
		<div class="entry">
			<ul>
				<li><strong>In Time:</strong> ${entry.inTime}</li>
				<li><strong>Out Time:</strong> ${entry.outTime}</li>
				<li><strong>Department:</strong> ${entry.department}</li>
				<li>
					<c:choose>
		    			<c:when test="${entry.isVerified==true}">
		        			<strong>Status:</strong> verified
					    </c:when>    
					    <c:otherwise>
					        <strong>Status:</strong> not verified
					    </c:otherwise>
					</c:choose>
				</li>
			</ul>
			<hr class="great-divide">
			<div class="comment_container">
				<c:forEach var="listValue" items="${entry.comments}">
				<div class="comment">
					<h3>${listValue.employeeName} <span>commented</span></h3>
					<h4><i>${listValue.timestamp}</i></h4>
					<p>${listValue.text}</p>
				</div>
				<hr>
				</c:forEach>
			</div>
			<sf:form method="POST" commandName="comment" action="/entry/view/own/${entry.id}">
		
		        <table>
		            <tr>
		                <%--the `path` attribute matches the `text` attribute of the Entity that was passed in the model--%>
		                <td><sf:textarea path="text" type="text" placeholder="Comment..."/></td>
		                <td><input type="submit" VALUE="Comment!"/></td>
		            </tr>
		        </table>
		        
		
		    </sf:form>
			${commentMessage}
		</div>
		<div class="navbar">
		<a href="/entry/view/own"><button>back to your entries view</button></a>
		
		<a href="/clock"><button>Return to clock page</button></a>
		
		</div>
	</div>
</body>
</html>

