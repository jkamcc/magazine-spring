<%@ include file="/WEB-INF/views/init.jsp" %>

<h2>Article</h2>

<c:if test="${!empty article}">
	<p>
		T�tulo:
		<c:out value="${article.subject}"/>
	</p>
	
	<p>
		Fecha:
		<c:out value="${article.datearticle}"/>
	</p>
	
	<p>
		<c:out value="${article.article}"/>
	</p>
	
</c:if>