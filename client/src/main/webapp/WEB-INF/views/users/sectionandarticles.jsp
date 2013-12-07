<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>



<c:if test="${!empty articles}">
	<c:if test="${!empty section}">
	
		<h2>Section <c:out value="${section.sectionArticle}"/> with articles</h2>
		
		<table border="5" width="600">
			<tr>
				<th>Section</th>
				<th>Articles</th>
			</tr>
			
				<tr>
					<td  rowspan="10"><c:out value="${section.sectionArticle}"/></td>
					<c:forEach items="${articles}" var="article">
						<c:if test="${article.sectionid == section.sectionid}">
							<td>
								<a class="menu-link" href='<c:url value="/articles/article/2"/>'>
									<c:out value="${article.subject}"/>
								</a>
							</td>
						</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</c:if>