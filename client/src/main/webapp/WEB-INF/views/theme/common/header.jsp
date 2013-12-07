<%@ include file="../../init.jsp" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href='<c:url value="/"/>'><s:message code="site-name"/></a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href='<c:url value="/"/>'>Home</a></li>
                    <c:forEach items="${sectionList}" var="section">
                        <li><a href="#section">${section.sectionArticle}</a></li>
                    </c:forEach>
                </ul>
                <ul class="nav pull-right">
                    <c:choose>
                        <c:when test="${not empty currentUser}">
                            <li><a href='<c:url value="/control_panel"/>'><s:message code="control-panel"/></a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle active" data-toggle="dropdown">${currentUser} <b class="caret"></b></a>

                                <ul class="dropdown-menu">
                                    <li><a href='<c:url value="/users/signout"/>'><s:message code="sign-out"/></a></li>
                                    <!-- <li class="divider"></li> -->
                                    <!-- <li class="nav-header">User</li> -->
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li><a href='<c:url value="/users/signin"/>'><s:message code="sign-in"/></a></li>
                            <li><a href='<c:url value="/users/register"/>'><s:message code="register"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</nav>
<nav id="nav-bot"></nav>