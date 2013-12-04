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