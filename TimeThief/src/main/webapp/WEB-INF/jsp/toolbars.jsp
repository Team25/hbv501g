		<div class="toolbar">
		<c:choose>
			<c:when test="${not empty adminToolbar}">
<%@ include file="admin-toolbar.jsp" %>
			</c:when>
		</c:choose>
		<div class="user-toolbar">
		    <a href="/entry/view/own"><div>View own entries</div></a>
			<a href="/logout"><div>Logout</div></a>
		  </div>
	    </div>