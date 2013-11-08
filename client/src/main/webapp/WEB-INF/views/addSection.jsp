<%@include file="init.jsp"%>

<div>
	<h1> Edici&oacuten de secciones </h1>
	<!-- Muestra las secciones de la pagina -->
	<form name="sectionsForm" id="sectionsForm">
	</form>
	
	
	<!-- Permite agregar una nueva seccion -->
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