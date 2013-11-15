<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="init.jsp" %>


<div style="margin-left:30px;" class="container">
	<form action='<c:url value="/sections/delete"/>' method="post" name="delete_frm" id="delete_frm">
		<h2>Sections</h2>  
	
			<h4><s:message code="list-sections"/> </h4>
			<c:if test="${!empty sectionList}">
				<table border="1">
					<tr>
						<th>Numero</th>
						<th>Nombre </th>
						<th></th>
					</tr>
					<c:forEach items="${sectionList}" var="section">
						<tr>
							  <td name="sectionid"><c:out value="${section.sectionid}" /></td>
						      <td name="sectionArticle"><c:out value="${section.sectionArticle}" /></td>
						      <td>
						      	<input type="submit" value="Eliminar"/>
						      </td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			</br>
	</form>
		
	<form action='<c:url value="/sections/"/>' method="post" name="agregar_frm" id="agregar_frm">
			<h4>Agregar Secci&oacuten:</h4>
			<input type="text" name="sectionArticle" id="sectionArticle"/>
			<input type="submit" value="Agregar"/>
	</form> 
</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'>
    $(document).ready(function(){
        $('#agregar_frm').validate({
            rules: {
                sectionArticle: {
                    required: true
                },
            }
        });
    });
    
    function changeFormValueAndSubmit(eliminar_btn) {
    	   var formData = $('form').serialize();
    	   jQuery.post('/path', formData, function(d) {
    	   });
    }
