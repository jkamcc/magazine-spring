<h2>Artículo Nuevo </h2>

<div id="editarticlediv">
<form class="form-editarticle" name='login_fm' action="<c:url value='j_spring_security_check' />" method='POST'>
		<p>
		<input name="article_name" type="text" class="input-block-level" placeholder="Título">
		</p>
		<p>
		<textarea rows="15" cols="50" name="article_content" class="input-block-level" placeholder="Contendio del artículo">
		</textarea>
		</p>
		<button id="btn-editarticle" type="submit">Crear Artículo</button>
	</form>
</div>