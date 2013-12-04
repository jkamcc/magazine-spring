<%@ include file="/WEB-INF/views/init.jsp" %>

<h2>Hola</h2>

<!--
<div>
	<h1> Edici&oacuten de secciones </h1>
	<form name="sectionsForm" id="sectionsForm">
		<table name="listaSecciones" id="listaSecciones">
			<thead>
				<tr>
					<th> Nombre de secci&oacuten</th>
					<th> </th>
				</tr>
			</thead>
		</table>
	</form>
	
	
	<h2>Agregar nueva Secci&oacuten</h2>
	<form name="addSectionForm" id="addSectionForm">
		<label for="SectionName">Nombre de la secci&oacuten</label>
		<input type="text" name="SectionName" id="SectionName" placeholder="Inserte un nombre"/>
		<input type="submit" name="SectionSubmit" value="addSection"/>
		<div id="responseSectionForm"></div>
	</form>
</div>

<script type="text/javascript">
	
	// Agrega una nueva seccion
	$('#addSectionForm').submit(function(e) {
    	$.post('${pageContext.request.contextPath}/section/addSection', $(this).serialize(), function(response) {
      	$('#responseSectionForm').text(response); });
    	e.preventDefault(); // prevent actual form submit and page reload
  	});
	
	// Obtiene las secciones y las muestra
	 $( window ).load(function() {
		 $.getJSON('${pageContext.request.contextPath}/section/getSections', function(response) {
			 for (var i=0; i<response.length();++i){
				var row = document.createElement("tr");
				var cell = document.createElement("td");
				var contenido = document.createTextNode(response[i].sectionName);
				cell.appendChild(contenido);
				row.appendChild(cell);
				cell =document.createElement("td");
				var boton= document.createElement("input");
				boton.type="button";
				boton.value=" - ";
				boton.onclick= function(){
					alert('Se eliminara la seccion');
				};
				$('table#listaSecciones').childNodes.appendChild(row);
			 };}
		);
	});
	

</script> -->