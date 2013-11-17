<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Artículo Nuevo </h2>

<div id="editarticlediv">

<form id="editarticle_fm" name="editarticle_fm" action="<c:url value='/articles/savearticle' />" method='POST'>
		<div>
			<input name="subject" type="text" class="input-block-level" placeholder="Título">
		</div>
		<div>
			<c:if test="${!empty sectionList}">
				Indique la sección del artículo:
				<select name="sectionid">
					<c:forEach items="${sectionList}" var="section">
						<option value="<c:out value="${section.sectionid}"/>">
							<c:out value="${section.sectionArticle}"/>
						</option>
					</c:forEach>
				</select> 
			</c:if>
		</div>
		<div>
			<input name="author" type="text" class="input-block-level" placeholder="Autor del artículo" >
		</div>
		<div>
			<textarea rows="7" cols="50" name="article" class="input-block-level" placeholder="Contendio del artículo">
			</textarea>
		</div>
		<button id="btn-editarticle" type="submit">Crear Artículo</button>
	</form>
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'>
    $(document).ready(function(){
        $('#editarticle_fm').validate({
            rules: {
                article: {
                    required: true
                },
                subject: {
                    required: true
                },
                author: {
                    required : true
                }
            }
        });
    });
</script>