<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>


<div style="margin-left:30px;" class="container">
	
	<!-- Para mostrar las sections existentes en la BD -->
	<inpu type="hidden" name="sectionId" >
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
					<input type="submit" class="deleteButton" value="Eliminar"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</br>
		
	<h4>Add Section</h4>
	<input type="text" name="sectionArticle" id="sectionArticle"/>
	<input type="button" value=<s:message code="button-add"/> name="agregarButton" id="agregarButton"/>
</div>

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
                    alert("Error: " + e);
                }
            });
            return false;
     });
	
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
	);
</script>