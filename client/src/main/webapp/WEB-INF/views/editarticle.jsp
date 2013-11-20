<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Art�culo Nuevo </h2>

<div id="editarticlediv">

<form id="editarticle_fm" name="editarticle_fm" action="<c:url value='/articles/savearticle' />" method='POST'>
        <input name="sectionName" type="hidden">
		<div>
			<input name="subject" type="text" class="input-block-level" placeholder="T�tulo">
		</div>
		<div>
			<c:if test="${!empty sectionList}">
				Indique la secci�n del art�culo:
				<select id="sectionid" name="sectionid">
					<c:forEach items="${sectionList}" var="section">
						<option value="<c:out value="${section.sectionid}"/>">
							<c:out value="${section.sectionArticle}"/>
						</option>
					</c:forEach>
				</select> 
			</c:if>
		</div>
		<div>
			<input name="author" type="text" class="input-block-level" placeholder="Autor del art�culo" >
		</div>
		<div>
			<textarea rows="7" cols="50" name="article" class="input-block-level" placeholder="Contendio del art�culo">
			</textarea>
		</div>
		<button id="btn-editarticle" type="submit">Crear Art�culo</button>
	</form>
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        var form = $('#editarticle_fm');
        form.validate({
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

        form.submit(function(event){
            var id = $('#sectionid option:selected').attr('name')
            $('input[name="sectionName"]').val(id);
        });
    });


</script>