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

	<sf:form method="POST" commandName="updatedEntry" action="/entry/view/all/${entry.id}/update">
		<div class="form-group">
			<sf:input path="id" type="hidden" id="id" name="id" value="${entry.id }" class="form-control"/>
			<sf:input path="employeeId" type="hidden" id="id" name="id" value="${entry.employeeId }" class="form-control"/>
		</div>
        <table>
            <tr>
                <td>In Time:</td>
                    <%--the `path` attribute matches the `text` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="inTime" type="text" value="${entry.inTime }"/></td>
            </tr>
            <tr>
                <td>Out Time:</td>
                    <%--the `path` attribute matches the `text` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="outTime" type="text" value="${entry.outTime }"/></td>
            </tr>
            <tr>
                <td>In Time:</td>
                    <%--the `path` attribute matches the `text` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="department" type="text" value="${entry.department }"/></td>
            </tr>
            <tr>
				<td><label>Check to verify:</label></td>
				<td><sf:checkbox path="isVerified" id="is_verified" checked="${entry.isVerified }" class="form-control"/></td>
			</tr>
        </table>

        <input type="submit" VALUE="Update Entry"/>

    </sf:form>
    <div class="message_container">
    	<p>${updateMessage}</p>
    </div>
	<div class="comment_container">
		<c:forEach var="listValue" items="${entry.comments}">
		<div class="comment">
			<h3>${listValue.employeeName}</h3>
			<h4><i>${listValue.timestamp}</i></h4>
			<p>${listValue.text}</p>
		</div>
		</c:forEach>
	</div>
	<sf:form method="POST" commandName="comment" action="/entry/view/all/${entry.id}/comment">

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
<a href="/entry/view/all">back to your entries view</a>

<a href="/clock">Return to clock page</a>

</div>
</div>
</body>
</html>

