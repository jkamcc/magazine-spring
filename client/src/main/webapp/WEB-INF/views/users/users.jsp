<%@ include file="/WEB-INF/views/init.jsp" %>

<div id="users" class="container-fluid">

    <h2><s:message code="users"/></h2>

    <div class="element-add">
        <button class="btn btn-primary btn-xxlarge" onclick="location.href='<c:url value="/users/new"/>'">
            <s:message code="new-user-add"/> &nbsp;
            <i class="fa fa-plus"></i>
        </button>
    </div>

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
                <th><s:message code="action"/></th>
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
                            <button class="btn btn-small editButton">
                                <s:message code="button-edit"/>&nbsp;
                                <i class="fa fa-edit"></i>
                            </button>
                            <button class="btn btn-small deleteButton">
                                <s:message code="button-delete"/>&nbsp;
                                <i class="fa fa-trash-o"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </fieldset>
</div>

<script src='<c:url value="/resources/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
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
