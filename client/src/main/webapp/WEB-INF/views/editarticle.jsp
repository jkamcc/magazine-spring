<%@include file="init.jsp"%>

<style type="text/css">
    .article-info {
        float: left;
    }
</style>

<div id="editarticle">

    <form id="editarticle_fm" name="editarticle_fm" action="javascript:;" method='POST' class="well form-horizontal">

        <fieldset>
            <div id="message" class="form-message control-group alert hide">
                <label><!--ajax--></label>
            </div>

            <div class="article-info">
                <input name="articleid" value="${article.articleid}" type="hidden">
                <input name="datearticle" value="${article.datearticle}" type="hidden">

                <legend><s:message code="article-new"/></legend>

                <div class="control-group">
                    <label class="control-label" for="subject"><s:message code="article-title" /></label>
                    <div class="controls">
                        <input id="subject" name="subject" value="${article.subject}" type="text" class="input-xxlarge">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="sectionid"><s:message code="article-select-section"/></label>
                    <div class="controls">
                        <select id="sectionid" name="sectionid">
                            <option></option>
                            <c:if test="${not empty sectionList}">
                                <c:forEach items="${sectionList}" var="section">
                                    <option value="<c:out value="${section.sectionid}"/>"
                                            <c:if test="${section.sectionid == article.sectionid}">
                                                selected
                                            </c:if>
                                            >
                                        <c:out value="${section.sectionArticle}"/>
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="author"><s:message code="article-author"/></label>
                    <div class="controls">
                        <input id="author" name="author" value="${article.author}" type="text" class="input-large" >
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="content" ><s:message code="article-content"/></label>
                    <div class="controls">
                        <textarea id="content" rows="7" cols="50" name="article" class="input-xxlarge">${article.article}</textarea>
                    </div>
                </div>

                <div class="form-actions">
                    <button id="btn-editarticle" class="btn btn-primary ${edit_article}" type="submit">
                        <s:message code="article-publish"/>
                    </button>
                    <button type="cancel" class="btn">Cancel</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/edit_article.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        ArticleVariables.message = $('#message');
        <c:choose>
        <c:when test="${empty edit_article}">
        ArticleVariables.errorMessage = '<s:message code="error-created-article"/>';
        ArticleVariables.successMessage = '<s:message code="success-created-article"/>';
        </c:when>
        <c:otherwise>
        ArticleVariables.errorMessage = '<s:message code="error-edit-article"/>';
        ArticleVariables.successMessage = '<s:message code="success-edited-article"/>';
        </c:otherwise>
        </c:choose>
        ArticleVariables.inputs = $('.article-info');
        ArticleVariables.submitButton = $('#btn-editarticle');
        $('#editarticle_fm').validate(articleValidation);
    });
</script>