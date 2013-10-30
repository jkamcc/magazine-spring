<%@include file="init.jsp"%>

<div id="register">
	<span>
		<s:message code="register-message"/>
	</span>
	<form name="register_fm" action="javascript;;" method="post">
		<label for="username"><s:message code="username"/></label>
		<input class="input-block" name="username" type="text" required>
		<label for="email"><s:message code="email" /></label>
		<input class="input-block" name="email" type="text" required>
		<label for="password"><s:message code="password"/></label>
		<input class="input-block" name="password" type="password" >
		<label for="confirm-password"><s:message code="confirm-password"/></label>
		<input class="input-block" name="confirm[password" type="password" >
		<input class="input-block" name="submit" type="button">
	</form>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("label").inFieldLabels();
	});
</script>