<%@ include file="/WEB-INF/views/init.jsp" %>

<h2>Articles in section</h2>
<c:if test="${!empty articlesList}">
	<c:if test="${!empty sectionList}">
			<c:forEach items="${sectionList}" var="section" varStatus="status">
				<br>
				<br>
				<h3><c:out value="${section.sectionArticle}"/></h3>
					<c:forEach items="${articlesList}" var="article" varStatus="statusArticle">
						<c:if test="${article.sectionid == section.sectionid}">
							<li>
								<a class="menu-link" href='<c:url value="/articles/article/"/>${article.articleid}'>
									<c:out value="${article.subject}"/>
								</a>
							</li>
						</c:if>
					</c:forEach>
			</c:forEach>
	</c:if>
</c:if>