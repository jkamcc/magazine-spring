<%@ include file="/WEB-INF/views/init.jsp" %>
<div class="well sidebar-nav control-menu">
    <ul class="nav nav-list">
        <li class="nav-header"><s:message code="control-panel"/></li>
        <%--<li class="active"><a href="#">Link</a></li>--%>
        <li><i class="fa fa-users fa-2"></i><a class="menu-link" href='<c:url value="/users/"/>'><s:message code="users"/></a></li>
        <li><i class="fa fa-folder-open-o fa-2"></i><a class="menu-link" href='<c:url value="/sections/"/>'><s:message code="sections"/></a></li>
        <li><i class="fa fa-pencil-square-o fa-2"></i><a class="menu-link" href='<c:url value="/articles/"/>'><s:message code="articles"/></a></li>
    </ul>
</div><!--/.well -->