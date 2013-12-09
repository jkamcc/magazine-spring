<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../init.jsp" %>

<div class="container-fluid">
	<input name="commentNumber" id="commentNumber" value="3" type="hidden">
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
	<div class="well form-horizontal" >
		<fieldset id="commentsDiv" >
			<legend><s:message code="article-comments"/></legend>
			<c:if test="${!empty article.comments}">
				<c:forEach items="${article.comments}" var="comment">
					<div class="article-comment">
						<p>
							<strong><c:out value="${comment.authorName}"/></strong>: <c:out value="${comment.dateComment}"/> </br><c:out value="${comment.commentarticle}"/>
						</p>
					</div>
				</c:forEach>
			</c:if>
		</fieldset>
		<div class="row">
        	<a class="pull-right" href='#' onclick="showMore()"> &lt; &lt; &nbsp;Show More</a>
    	</div>
    	</br>
		<div class="row">
        	<a class="pull-right" href='<c:url value="/articles/article/"/>${article.articleid}'> &lt; &lt; &nbsp;<s:message code="back"/> </a>
    	</div>
		<form id="commentarticle_fm" name="commentarticle_fm" action="javascript:;" method='POST' class="well form-horizontal">
			<!-- input filds -->
			<input name="articleid" value="${article.articleid}" type="hidden">
			<input name="author" value="${currentUser.userid}" type="hidden">

			<fieldset>
				<div id="message" class="form-message control-group alert hide">
					<label><!--ajax--></label>
				</div>
				<div class="comment-info">
					<div class="control-group" style="margin-top:40px;">
						<label class="control-label" for="content"><s:message code="create-comment"/>: </label>
						<div class="controls">
							<textarea id="commentarticle" rows="7" cols="50" name="article" class="input-xxlarge"></textarea></br>
						</div>
					</div>
					<div class="form-actions">	
						<!-- <input type="button" id="btn-comment" class="commentButton btn btn-primary"" value="Comment"/>-->
						<button id="btn-comment" class="btn btn-primary" type="submit">
                        	<s:message code="comment"/>
						</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<div class="row">
        <a class="pull-right" href='#' onclick="goBack()"> &lt; &lt; &nbsp;<s:message code="back"/> </a>
    </div>
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/articlecomment.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        CommentVariables.message = $('#message');
        CommentVariables.errorMessage = '<s:message code="error-created-comment"/>';
        CommentVariables.successMessage = '<s:message code="success-created-comment"/>';
        CommentVariables.inputs = $('.comment-info');
        $('#commentarticle_fm').validate(commentValidation);
    });
</script>

