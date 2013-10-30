<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Article</h2>

<c:if test="${!empty article}">
	<p>
		Título:
		<c:out value="${article.}"/>
	</p>
	
	<p>
		Fecha:
		<c:out value="${article.}"/>
	</p>
	
	<p>
		<c:out value="${article.}"/>
	</p>
	
</c:if>