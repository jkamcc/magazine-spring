<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>


<div style="margin-left:30px;" class="container">
	<form action="<c:url value="/sections/"/>" method="delete" name="delete">
		<h2>Sections</h2>  
	
			<h4>Lista de secciones: </h4>
			<c:if test="${!empty sectionList}">
				<table border="1">
					<tr>
						<th>Nombre de la secci&oacuten</th>
						<th> Acci&oacuten </th>
					</tr>
					<c:forEach items="${sectionList}" var="section">
						<tr>
						      <td><c:out value="${section.sectionArticle}" /></td>
						      <td>
						      	<input type="button" value="Eliminar"/>
						      </td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			</br>
	</form>
		
	<form action="<c:url value="/sections/"/>" method="post" name="agregar">
			<h4>Agregar Secci&oacuten:</h4>
			<input type="text" name="sectionArticle" id="sectionArticle"/>
			<input type="submit" value="Agregar"/>
	</form> 
</div>

