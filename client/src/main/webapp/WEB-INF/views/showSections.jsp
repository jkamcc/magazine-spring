<!--  	
	$('#agregarButton').click(
		function(){
			var tabla =$('#sectionTable');
			var name= $('#sectionArticle').val();
			var serviceUrl = "http://localhost:8080/service/section/create";
			var datos=  '{"sectionArticle":'+'"'+name+'"}';
			$.ajax({
	            type: "POST",
	            url: serviceUrl,
	            async: false,
	            data: datos,
	            contentType:"application/json",
	            dataType: "json",
	            success: function(data) {
	            	var row = document.createElement("tr");
					var cell = document.createElement("td");
					var contenido = document.createTextNode(data.sectionid);
					cell.appendChild(contenido);
					row.appendChild(cell);
					
					cell = document.createElement("td");
					contenido = document.createTextNode(name);
					cell.appendChild(contenido);
					row.appendChild(cell);
					
					cell =document.createElement("td");
					var boton= document.createElement("input");
					boton.type="submit";
					boton.class= "deleteButton";
					boton.value="Eliminar";
					cell.appendChild(boton);
					row.appendChild(cell);
					tabla.append(row);
					$('#sectionArticle').val('');
	            },
	            error: function (e) {
	                alert("Error: " + e);
	            }
	        });
	        return false;
		}
	);-->




<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>

<div name="divSections" id="divSections" >
</div>
<div style="margin-left:30px;" class="container">
	<div class="hero-unit">
		<!-- Para mostrar las sections existentes en la BD -->
		<h2>Sections</h2>  
		<h4><s:message code="list-sections"/></h4>
		<c:if test="${!empty sectionList}">
			<table border="1" name="sectionTable" id="sectionTable">
				<tr>
					<th><s:message code="section-id"/></th>
					<th><s:message code="section-name"/></th>
					<th></th>
				</tr>
				<c:forEach items="${sectionList}" var="section">
				<tr>
					<td><c:out value="${section.sectionid}" /></td>
					<td><c:out value="${section.sectionArticle}" /></td>
					<td>
						<input type="submit" class="deleteButton btn btn-primary" value="Eliminar"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		</br>
		
		<form name="add" id="add" nonvalidate>
			<h4>Add Section</h4>
			<input type="text" name="sectionArticle" id="sectionArticle"/>
			<input type="button" value=<s:message code="button-add"/> name="agregarButton" id="agregarButton" class="btn btn-primary"/>
		</form>
	</div>
</div>

<script src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.min.js"/>'></script>
<script type="text/javascript">
	$('.deleteButton').click(function(){
		var rowD=this.parentNode.parentNode;
		var id= rowD.childNodes[1].textContent;
		var serviceUrl = "http://localhost:8080/service/section/delete/".concat(id);
	    $.ajax({
	        type: "DELETE",
	        url: serviceUrl,
	        async: false,
	        data: '',
	        success: function(data) {
	            rowD.parentNode.removeChild(rowD);
	        },
	        error: function (e) {
	            alert("No se ha podido eliminar la seccion");
	        }
	    });
	    return false;
	});

	$(document).ready(function(){
		// Valida contra expresion regular
		$.validator.addMethod("regx", function(value, element, regexpr) {          
		    return regexpr.test(value);
		}, "Please enter a valid name");
		
		// Valida existencia de otra section con el mismo nombre
	    $.validator.addMethod(
	        "uniqueSectionName", 
	        function(value, element) {
	        	var response;
	            $.ajax({
	                type: "GET",
	                url: "http://localhost:8080/service/section/get/"+value,
	                data:  '{"sectionArticle":'+'"'+$('#sectionArticle').val()+'"}',
	                contentType:"application/json",
				    dataType: "json",
	                success: function(data)  {
	                   if (data.sectionid!=0){
	                	   response=true;
	                   }
	                   else{
	                	   response=false;
	                	   
	                   }
	                }
	             });
	            return response;
	        }, "Username is Already Taken");
	    
		$("#add").validate({
			rules: {
				sectionArticle: {
					required: true,
					maxlength: 50,
					regx: /^[a-zA-Z]+(?=\d?)/,
					uniqueSectionName: true
				}
			},
			messages:{
				sectionArticle: {
					required:"* Required field",
					maxlength:"* El campo no puede exceder los 50 caracteres",
					regx: "* El campo debe contener al menos una letra",
					uniqueSectionName:"* Ya existe una section con ese nombre"
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
				     	var row='<tr><td>'+data.sectionid+'</td><td>'+data.sectionArticle+'</td>';
				        row= row+'<td>'+'<input type="submit" class="deleteButton" value="Eliminar"/></td></tr>';
				        $('#sectionTable').append(row);
						$('#sectionArticle').val('');
				    },
				    error: function (e) {
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
		
		$('#divSections').jtable({
            title: 'Sections',
            actions: {
                listAction: '/GettingStarted/PersonList',
                createAction: '/GettingStarted/CreatePerson',
                updateAction: '/GettingStarted/UpdatePerson',
                deleteAction: '/GettingStarted/DeletePerson'
            },
            fields: {
                SectionId: {
                    key: true,
                    list: false
                },
                SectionName: {
                    title: 'Section Name',
                    width: '40%'
                },
                Action: {
                    title: 'Age',
                    width: '20%'
                },
            }
        });
	});
	
</script>