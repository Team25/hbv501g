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
<div class="entry">
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
	<div class="comment_container">
		<c:forEach var="listValue" items="${entry.comments}">
		<div class="comment">
			<h3>${listValue.employeeName}</h3>
			<h4><i>${listValue.timestamp}</i></h4>
			<p>${listValue.text}</p>
		</div>
		</c:forEach>
	</div>
	<sf:form method="POST" commandName="comment" action="/entry/view/own/${entry.id}">

        <table>
            <tr>
                <td>Comment:</td>
                    <%--the `path` attribute matches the `text` attribute of the Entity that was passed in the model--%>
                <td><sf:textarea path="text" type="text" placeholder="Comment..."/></td>
            </tr>
        </table>

        <input type="submit" VALUE="Comment!"/>

    </sf:form>
	${commentMessage}
</div>
<div class="navbar">
<a href="/entry/view/own">back to your entries view</a>

<a href="/clock">Return to clock page</a>

</div>
</div>
</body>
</html>

