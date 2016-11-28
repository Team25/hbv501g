<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of entries</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/entryAdmin.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/toolbar.css"/>"/>
</head>
<body>
		<%@ include file="../toolbars.jsp" %>
<div class="container">
<div class="entry">

	<sf:form method="POST" commandName="updatedEntry" action="/entry/view/all/${entry.id}/update">
		<div class="form-group">
			<sf:input path="id" type="hidden" id="id" name="id" value="${entry.id }" class="form-control"/>
			<sf:input path="employeeId" type="hidden" id="id" name="id" value="${entry.employeeId }" class="form-control"/>
		</div>
        <table>
            <tr>
                <td>Employee:</td>
                <td>
                    ${employeeName}
                </td>
            </tr>
            <tr>
                <td>In Time:</td>
                <td>
                    <fmt:formatDate value="${entry.inTime}" var="inTime" pattern="yyyy-MM-dd HH:mm"/>
                    <sf:input path="inTime" type="text" value="${inTime}"/>
                </td>
            </tr>
            <tr>
                <td>Out Time:</td>
                <td>
                  <fmt:formatDate value="${entry.outTime}" var="outTime" pattern="yyyy-MM-dd HH:mm"/>
                  <sf:input path="outTime" type="text" value="${outTime}"/>
                </td>
            </tr>
            <tr>
                <td>Department:</td>
                <td><sf:input path="department" type="text" value="${entry.department }"/></td>
            </tr>
            <tr>
				<td><label>Check to verify:</label></td>
				<c:choose>
	    			<c:when test="${entry.isVerified==true}">
	        			<td><sf:checkbox path="isVerified" id="is_verified" checked="true" class="form-control"/></td>
				    </c:when>
				    <c:otherwise>
				        <td><sf:checkbox path="isVerified" id="is_verified" class="form-control"/></td>
				    </c:otherwise>
				</c:choose>
			</tr>
        </table>

        <input type="submit" VALUE="Update Entry"/>

    </sf:form>
    <div class="message_container">
    	<p>${updateMessage}</p>
    </div>
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
<a href="/entry/view/all"><button>Back to All Entries</button></a>
</div>
</div>
</body>
</html>
