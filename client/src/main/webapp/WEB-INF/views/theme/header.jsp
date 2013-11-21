<%@ include file="../init.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="brand" href='<c:url value="/"/>'>Project name</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href='<c:url value="/"/>'>Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href='<c:url value="/sections/"/>'>Section</a><li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="nav-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul>
					</li>
				</ul>
                <div class="navbar-form pull-right">
                    <c:choose>
                        <c:when test="${not empty currentUser}">
                            <span>${currentUser}</span>
                            <a href='<c:url value="/users/signout"/>'><s:message code="sign-out"/></a>
                        </c:when>
                        <c:otherwise>
                            <a href='<c:url value="/users/signin"/>'><s:message code="sign-in"/></a>
                            <a href='<c:url value="/users/register"/>'><s:message code="register"/></a>
                        </c:otherwise>
                    </c:choose>
				</div>
			</div><!--/.nav-collapse -->
		</div>
	</div>
</div>
<div id="nav-bot"></div>