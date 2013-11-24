<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>

<div style="margin-left:30px;" class="container">
	<div class="hero-unit" style="padding-left: 20%;">
		<!-- Para mostrar las sections existentes en la BD -->
		<h2>Sections</h2>  
		<form name="add" id="add" nonvalidate>
			<h4>Add Section</h4>
			<input type="text" name="sectionArticle" id="sectionArticle"/>
			<input type="button" value=<s:message code="button-add"/> name="agregarButton" id="agregarButton" class="btn btn-primary"/>
		</form>
		&nbsp;
		<h4><s:message code="list-sections"/></h4>
		<c:if test="${!empty sectionList}">
			<table border="1" name="sectionTable" id="sectionTable">
				<thead>
					<tr>
					<th><s:message code="section-id"/></th>
					<th><s:message code="section-name"/></th>
					<th><s:message code="action"/></th>
					</tr>
				</thead>
				<tbody id="tableB">
				</tbody>
			</table>
		</c:if>
		</br>
	</div>
</div>

<script src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.dataTables.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.dataTables.min.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.dataTables.editable.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.min.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.jeditable.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-ui.js"/>'></script>
<script type="text/javascript">
	$(document).ready(function(){
		// Valida contra expresion regular
		$.validator.addMethod("regx", function(value, element, regexpr) {          
		    return regexpr.test(value);
		}, "Please enter a valid name");
		
		var dataAjax;
		var $tableS= $('#sectionTable').dataTable( {
			    "bProcessing": true,
			    "aaSorting": [[ 1, "asc" ]],
			    "sAjaxSource": $.ajax({
				   	type: "GET",
				    url: "http://localhost:8080/service/section/all",
				    async: false,
				    data: ' ',
				    contentType:"application/json",
				    dataType: "json",
				    success: function(data) {
				    	dataAjax=  $.makeArray(data);
				    	for(i=0; i<dataAjax.length;++i){
							dataAjax[i].boton='<input type="button" class="deleteButton" value="Delete"/>';
						}
				    },
		         }),
		         "aaData": dataAjax,
		 aoColumns: [
                       { mData: 'sectionid' },
                       { mData: 'sectionArticle' },
					   {mData:'boton',"fnRender": function( oObj ) {return '<input type="button" class="deleteButton" value="Delete"/>';}}
               ],
		})
		
		$("#add").validate({
			rules: {
				sectionArticle: {
					required: true,
					maxlength: 50,
					regx: /^[a-zA-Z]+(?=\d?)/,
				}
			},
			messages:{
				sectionArticle: {
					required:"* Required field",
					maxlength:"* El campo no puede exceder los 50 caracteres",
					regx: "* El campo debe contener al menos una letra",
				}
			},
		});
		
		$('#agregarButton').click(function(){
			if($("#add").valid()){
				var tabla =$('#sectionTable');
				$.ajax({
				   	type: "POST",
				    url: "http://localhost:8080/service/section/create",
				    async: false,
				    data: '{"sectionArticle":'+'"'+$('#sectionArticle').val()+'"}',
				    contentType:"application/json",
				    dataType: "json",
				    success: function(data) {
						dataAjax=  $.makeArray(data);
						dataAjax[0].boton='<input type="button" class="deleteButton" value="Delete"/>';
						$('#sectionTable').dataTable().fnAddData(dataAjax);
						$('#sectionArticle').val(' ');
						$tableS.fnGetData();
						$('#sectionTable').dataTable().fnDraw();
				    },
				    error: function (e){
				      	alert("Se ha producido un error al insertar");
				    	}
				});
			}
			else{
				alert ('Los datos insertados no son validos');
				
			}
		    return false;
			}
		);  
		
		$('.deleteButton').click(function(){
			var id=(this.parentNode.parentNode.children)[0].textContent;
			var tableRows= this.parentNode.parentNode.parentNode.children;
			var posicion=0;
			for(i=0; i<tableRows.length;++i){
				if((tableRows.item(i)).children.item(0).textContent==id){
					posicion=i;
				}
			}
			$.ajax({
				   	type: "DELETE",
				    url: "http://localhost:8080/service/section/delete/"+id,
				    async: false,
				    data: '',
				    contentType:"application/json",
				    dataType: "json",
				    success: function(data) {
						$('#sectionTable').dataTable().fnDeleteRow(posicion); 
						$tableS.fnGetData();
						$('#sectionTable').dataTable().fnDraw();
				    },
				    error: function (e){
				      	alert("Se ha producido un error al insertar");
				    	}
				});
			}
		);
	});
		
</script>