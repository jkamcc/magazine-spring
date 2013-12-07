<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../init.jsp" %>

<div class="container-fluid">
	<article style="margin-bottom:40px;">
		<c:if test="${!empty article}">
			<header>
				<h2><c:out value="${article.subject}"/></h2>
				<h4> by <c:out value="${article.author}"/></h4>
				<p> <s:message code="created-date"/> :
					<c:out value="${article.datearticle}"/>
				</p>
			</header>
			<p> <c:out value="${article.article}"/></p>
		</c:if>
	</article>
	<div class="well form-horizontal">
		<fieldset>
			<legend><s:message code="article-comments"/></legend>
			<c:if test="${!empty article.comments}">
				<c:forEach items="${article.comments}" var="comment">
					<div class="article-comment">
						<p>
							<strong><c:out value="${comment.author}"/></strong>: <c:out value="${comment.dateComment}"/> </br><c:out value="${comment.commentarticle}"/>
						</p>
					</div>
				</c:forEach>
			</c:if>
		</fieldset>
		<form>
			<fieldset>
				<div class="control-group" style="margin-top:40px;">
					<label class="control-label" for="content"><s:message code="create-comment"/>: </label>
					<div class="controls">
						<textarea id="content" rows="7" cols="50" name="article" class="input-xxlarge"></textarea></br>
					</div>
				</div>
				<div class="form-actions">	
					<input type="button" class="commentButton btn btn-primary"" value="Comment"/>
				</div>
			</fieldset>
		</form>
	</div>
</div>
