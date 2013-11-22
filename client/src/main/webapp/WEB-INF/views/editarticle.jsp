<%@include file="init.jsp"%>

<div id="editarticle">

    <form id="editarticle_fm" name="editarticle_fm" action="<c:url value='/articles/savearticle' />" method='POST' class="well form-horizontal">

        <fieldset>
            <input name="articleid" type="hidden">
            <input name="sectionName" type="hidden">

            <legend><s:message code="article-new"/></legend>

            <div class="control-group">
                <label class="control-label" for="subject"><s:message code="article-title" /></label>
                <div class="controls">
                    <input id="subject" name="subject" type="text" class="input-large">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="sectionid"><s:message code="article-select-section"/></label>
                <div class="controls">
                    <select id="sectionid" name="sectionid">
                        <option></option>
                        <c:if test="${not empty sectionList}">
                            <c:forEach items="${sectionList}" var="section">
                                <option value="<c:out value="${section.sectionid}"/>">
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
                    <input id="author" name="author" type="text" class="input-large" >
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="content" ><s:message code="article-content"/></label>
                <div class="controls">
                    <textarea id="content" rows="7" cols="50" name="article" class="input-xxlarge"></textarea>
                </div>
            </div>

            <div class="form-actions">
                <button id="btn-editarticle" class="btn btn-primary" type="submit">
                    <s:message code="article-publish"/>
                </button>
                <button type="cancel" class="btn">Cancel</button>
            </div>

        </fieldset>
    </form>
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/edit_article.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        var form = $('#editarticle_fm');
        form.validate(articleValidation);

        form.submit(function(event){
            var id = $('#sectionid option:selected').attr('name')
            $('input[name="sectionName"]').val(id);
        });
    });


</script>