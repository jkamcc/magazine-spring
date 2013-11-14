<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Article</h2>

<c:if test="${!empty myArticle}">
	<p>
		Título:
		<c:out value="${myArticle.subject}"/>
	</p>
	
	<p>
		Fecha:
		<c:out value="${myArticle.datearticle}"/>
	</p>
	
	<p>
		<c:out value="${myArticle.article}"/>
	</p>
	
</c:if>