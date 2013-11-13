<%@include file="init.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="register" >
    <h1><s:message code="join-message"/></h1>
	<h2><s:message code="register-message"/></h2>

	<form id="register_fm" name="register_fm" action="<c:url value="/users/register"/>" method="post">

        <input name="profile" value="<%=Profile.NORMAL.toString()%>" type="hidden">
        <input name="profileid" value="<%=Profile.NORMAL.getValue()%>" type="hidden" >

		<label for="username"><s:message code="username"/></label>
		<input id="username" class="input-block" name="username" type="text" >

        <label for="name"><s:message code="name"/></label>
        <input id="name" name="name" type="text">

		<label for="email"><s:message code="email" /></label>
		<input id="email" class="input-block" name="email" type="text">

		<label for="password"><s:message code="password"/></label>
		<input id="password" class="input-block" name="password" type="password">

		<label for="confirm-password"><s:message code="confirm-password"/></label>
		<input id="confirm-password" class="input-block" name="confirm-password" type="password" >

		<input class="input-block" name="Create an account" value="Create an account" type="submit">

	</form>

</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'>
    $(document).ready(function(){
        $('#register_fm').validate({
            rules: {
                username: {
                    required: true
                },
                name: {
                    required: true
                },
                email: {
                    required : true,
                    email : true
                },
                password: {
                    minlength: 5
                }
            }
        });
    });
    //
    //    $('#register_fm').submit(function(e) {
    //        var form = document.register_fm;
    //        var user1 = {
    //            username : form.username,
    //            password: form.password,
    //            name:
    //        };
    //        user1.username = document.register_fm.username.value;
    //        e.preventDefault();
    //
    //    });
</script>