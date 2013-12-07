<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/init.jsp" %>


<c:if test="${!empty articles}">
	<c:if test="${!empty section}">
	
		<h2>Section: <c:out value="${section.sectionArticle}"/></h2>
			<br>
			<c:forEach items="${articles}" var="article">
				<h3><c:out value="${article.subject}"/></h3>
				<p><c:out value="${article.article}"/></p>
				<a class="menu-link" href='<c:url value="/articles/article/"/>${article.articleid}'>
					Keep reading..
				</a>
				<hr>
			</c:forEach>
	</c:if>
</c:if>