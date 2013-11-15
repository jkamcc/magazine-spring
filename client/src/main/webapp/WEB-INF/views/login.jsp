<%@include file="init.jsp"%>

<div id="login">

	<form class="form-signin" name='login_fm' action="<c:url value='/j_spring_security_check' />" method='POST'>

		<h2 class="form-signin-heading"><s:message code="sign-in" /></h2>

		<c:if test="${not empty error}">
			<div class="alert alert-error">
				<s:message code="login-attempt"/><br />
				<s:message code='${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}'/>
			</div>
		</c:if>
		
		<input name="j_username" type="text" class="input-block-level" placeholder='<s:message code="login-user" />'>
		<input name="j_password" type="password" class="input-block-level" placeholder="Password">
		<label class="checkbox">
			<input type="checkbox" value="remember-me"> Remember me
		</label>
		<button class="btn btn-large btn-primary" type="submit"><s:message code="sign-in"/></button>
	</form>
	
</div>

<script type="text/javascript">
$('form[name="login_fm"]').validate();
</script>