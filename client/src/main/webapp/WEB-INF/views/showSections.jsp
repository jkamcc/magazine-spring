<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>


<div style="margin-left:30px;" class="container">
	<form action="<c:url value="/sections/delete"/>" method="post" name="delete">
		<h2>Sections</h2>  
		<h4><s:message code="list-sections"/></h4>
		<c:if test="${!empty sectionList}">
			<table border="1">
				<tr>
					<th><s:message code="section-id"/><th>
					<th><s:message code="section-name"/></th>
					<th></th>
				</tr>
				<c:forEach items="${sectionList}" var="section">
				<tr>
					<td><c:out value="${section.sectionid}" /></td>
					<td><c:out value="${section.sectionArticle}" /></td>
					<td>
						<a href="localhost:8080/client/sections/delete/<c:out value="${section.sectionid}"/>"><s:message code="button-delete"/></a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
		</br>
	</form>

	<!-- <form action="<c:url value="/sections/"/>" method="post" name="agregar">
		<h4>Agregar Secci&oacuten:</h4>
		<input type="text" name="sectionArticle" id="sectionArticle"/>
		<input type="submit" value=<s:message code="button-add"/>/>
	</form>  -->
</div>

<script type="text/javascript">
	/*$('#deleteButton').click(function(){
			var rowD=this.parentNode.parentNode;
			var id= rowD[0];
            $.ajax({
                type: "POST",
                url: "/delete/".id,
                data: JSON.stringify({
                     serversListModel: {
                         "assignedServers": assigned,
                         "availableServers": available
                     }
                 }),
                datatype: "jsondata",
                contentType: 'application/json',
                success: function(data) {
                    alert("Success");
                },
                error: function (e) {
                    alert("Error: " + e);
                }
            });
            return false;
        });*/
</script>