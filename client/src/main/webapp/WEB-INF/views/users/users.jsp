<%@ include file="/WEB-INF/views/init.jsp" %>

<div id="users" class="container-fluid well">

    <h2><s:message code="users"/></h2>

    <div>
        <button class="btn btn-primary btn-xxlarge" onclick="location.href='<c:url value="/users/new"/>'">
            <s:message code="new-user-add"/> &nbsp;
            <i class="fa fa-plus"></i>
        </button>
    </div>
</div>

<div class="container-fluid well">
	<fieldset>
		<legend><s:message code="users-list"/></legend>
		<table border="1" name="usersTable" id="usersTable" style="text-align:center;width: auto;"> 
			<thead  class="btn-primary">
				<tr>
					<th><s:message code="user-id"/></th>
					<th><s:message code="user-name"/></th>
					<th><s:message code="user-email"/></th>
					<th><s:message code="user-name2"/></th>
					<th><s:message code="user-profile"/></th>
					<th style="width:50%;"><s:message code="action"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty usersList}">
					<c:forEach items="${usersList}" var="user">
						<tr>
							<td> <c:out value="${user.userid}"/></td>
							<td> <c:out value="${user.username}"/></td>
							<td> <c:out value="${user.email}"/></td>
							<td> <c:out value="${user.name}"/></td>
							<td> <c:out value="${user.profile}"/></td>
							<td>
								<input type="button" class="deleteButton" value="Delete"/>
								<input type="button" class="editButton" value="Edit"/>
							</td>
						</tr>	
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</fieldset>
</div>


<script src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.jeditable.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/users.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        var dataAjax;
        var $tableS= $('#usersTable').dataTable( {
            "bProcessing": true,
            "aaSorting": [[ 1, "asc" ]],
        });

        $(document).on("click", ".deleteButton", function() {
        	deleteUser(this);
        });

    	$(document).on("click", ".editButton", function() {
            var id=(this.parentNode.parentNode.children)[0].textContent;
            editUser(id);
        });
    });
</script>