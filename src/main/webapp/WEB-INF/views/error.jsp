<%@include file="init.jsp" %>
<tiles:insert page="/theme/layout.jsp" flush="true">  
  <tiles:put name="header" value="/theme/header.jsp" />       
  <tiles:put name="footer" value="/theme/footer.jsp" />     
</tiles:insert>


<div class="errorDiv" style="display: inline-block;">
	<div class="imagenError" style="float: left;">
		<img src='<c:url value="/resources/img/error_image.jpg"/>' alt="Imagen de error" width="300" height="310">
	</div>
	
	<div class ="textoError">
		<h3> Error </h3>
		<h5> Disculpe, se ha producido un error en la aplicaci&oacuten </br> Por favor ingrese a otra de las opciones del men&uacute  </h5>
	</div>
</div>