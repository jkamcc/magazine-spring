<%@ include file="/WEB-INF/views/init.jsp" %>

<h2>Articles in section</h2>

<c:if test="${!empty articlesList}">
	<c:if test="${!empty sectionList}">
		<c:if test="${!empty indexes}">
		
			<table border="5" width="600">
			<tr>
				<th>Sections</th>
				<th>Articles</th>
			</tr>
			
			<c:forEach items="${sectionList}" var="section" varStatus="status">
				<tr>
					<td  rowspan="<c:out value="${indexes[status.index]}"/>"><c:out value="${section.sectionArticle}"/></td>
					<c:forEach items="${articlesList}" var="article" varStatus="statusArticle">
						<c:if test="${article.sectionid == section.sectionid}">
							<td>
								<a class="menu-link" href='<c:url value="/articles/article/"/>${article.articleid}'>
									<c:out value="${article.subject}"/>
								</a>
							</td>
						</c:if>
				</tr>
				</c:forEach>
			</c:forEach>
	</table>
	</c:if>
	</c:if>
</c:if>