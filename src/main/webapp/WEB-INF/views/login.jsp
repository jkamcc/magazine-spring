<%@include file="init.jsp"%>

<div id="login" class="auth-form">

	<form name='login_fm' action="<c:url value='j_spring_security_check' />" method='POST'>

		<div class="auth-form-header">
			<h1>
				<s:message code="sign-in" />
			</h1>
		</div>
		
		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
		
		<div class="auth-form-body">
			<label for="j_username" >
				<s:message code="login-user" />
			</label> 
			<input class="input-block" type='text' name='j_username' value=''> 
			<label for="j_password">
				<s:message code="login-password" />
			</label> 
			<input class="input-block" type='password' name='j_password' /> 
			<input class="button" type="submit" value='<s:message code="sign-in"/>' />
		</div>
	</form>
</div>