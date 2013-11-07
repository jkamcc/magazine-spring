<%@include file="init.jsp"%>

<div>
	<h2>Agregar nueva Secci&oacuten</h2>
	<form name="addSectionForm" id="addSectionForm">
		<label for="SectionName">Nombre de la secci&oacuten</label>
		<input type="text" name="SectionName" id="SectionName" placeholder="Inserte un nombre"/>
		<input type="submit" name="SectionSubmit" value="addSection"/>
		<div id="responseSectionForm"></div>
	</form>
</div>

<script type="text/javascript">
	$('#addSectionForm').submit(function(e) {
    	$.post('${pageContext.request.contextPath}/section/addSection', $(this).serialize(), function(response) {
      	$('#responseSectionForm').text(response); });
    	e.preventDefault(); // prevent actual form submit and page reload
  	});
</script>