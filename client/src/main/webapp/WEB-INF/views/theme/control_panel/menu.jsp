<%@ include file="../../init.jsp" %>
<div class="span3">
    <div class="well sidebar-nav control-menu">
        <ul class="nav nav-list">
            <li class="nav-header"><s:message code="control-panel"/></li>
            <%--<li class="active"><a href="#">Link</a></li>--%>
            <li><i class="fi-torsos-all size-16"></i><a href='<c:url value="/users/"/>'><s:message code="users"/></a></li>
            <li><i class="fi-folder size-16"></i><a href='<c:url value="/sections/"/>'><s:message code="sections"/></a></li>
            <li><i class="fi-page-multiple size-16"></i><a href='<c:url value="/articles/"/>'><s:message code="articles"/></a></li>
        </ul>
    </div><!--/.well -->
</div><!--/span-->