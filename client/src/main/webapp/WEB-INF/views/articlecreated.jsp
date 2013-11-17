<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<c:if test="${!empty error}">
		<c:out value="${error}"/>
	</c:if>
		<h2>Articulo creado con exito</h2>	
</div>