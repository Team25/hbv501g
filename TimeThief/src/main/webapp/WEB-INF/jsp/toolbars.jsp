		<div class="toolbar">
		
		<c:if test="${not empty adminToolbar}">
<%@ include file="admin-toolbar.jsp" %>
		</c:if>
		
		<div class="user-toolbar">
		    <a href="/entry/view/own"><div>View own entries</div></a>
			<a href="/logout"><div>Logout</div></a>
		  </div>
	    </div>