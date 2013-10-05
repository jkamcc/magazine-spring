<%@ include file="../init.jsp" %>

<div id="nav-top">
	<ul>
		<li>
			<a href="login"><s:message code="sign-in" /></a>
		</li>
		<li>
			<a href="register"><s:message code="register"/></a>
		</li>
	</ul>
	Current Locale : ${pageContext.response.locale}
</div>
<div id="nav-mid">
	<ul>
		<li id="title"><a>Logo</a></li>
		<li class="section"><a>Inicio</a></li>
		<li class="section"><a>Hogar</a></li>
		<li class="section"><a>Familia</a></li>
		<li class="section"><a>Viajes</a></li>
	</ul>
</div>
<div id="nav-bot"></div>