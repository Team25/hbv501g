		<div class="toolbar">
		
		<c:if test="${not empty adminToolbar}">
<%@ include file="admin-toolbar.jsp" %>
		</c:if>
		
		<div class="user-toolbar">
		    <a href="/clock"><div>Home page</div></a>
		    <a href="/entry/view/own"><div>My entries</div></a>
			<a href="/logout"><div>Logout</div></a>
		  </div>
	    </div>