<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Art�culo Nuevo </h2>

<div id="editarticlediv">

<form id="editarticle_fm" name="editarticle_fm" action="<c:url value='/articles/savearticle' />" method='POST'>
		<p>
			<input name="article_name" type="text" class="input-block-level" placeholder="T�tulo">
		</p>
		<p>
			<c:if test="${!empty sectionList}">
				Indique la secci�n del art�culo: <br>
				<select>
					<c:forEach items="${sectionList}" var="section">
						<option value="<c:out value="${section.sectionid}"/>">
							<c:out value="${section.sectionArticle}"/>
						</option>
					</c:forEach>
				</select> 
			</c:if>
		</p>
		<p>
			<textarea rows="15" cols="50" name="article_content" class="input-block-level" placeholder="Contendio del art�culo">
			</textarea>
		</p>
		<button id="btn-editarticle" type="submit">Crear Art�culo</button>
	</form>
</div>