<%@include file="init.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="register" class="container-fluid">

    <h1><s:message code="join-message"/></h1>

    <form id="register_fm" name="register_fm" action="javascript:;" method="post" class="well form-horizontal">
        <fieldset>

            <legend><s:message code="register-message"/></legend>

            <input name="profile" value="<%=Profile.NORMAL.toString()%>" type="hidden">
            <input name="profileid" value="<%=Profile.NORMAL.getValue()%>" type="hidden" >

            <div class="control-group">
                <label class="control-label" for="username"><s:message code="username"/></label>
                <div class="controls">
                    <input id="username" class="input-large" name="username" type="text" >
                </div>

            </div>

            <div class="control-group">
                <label class="control-label" for="email"><s:message code="email" /></label>
                <div class="controls">
                    <input id="email" class="input-large" name="email" type="text">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="name"><s:message code="name"/></label>
                <div class="controls">
                    <input id="name" class="input-large" name="name" type="text">
                </div>
            </div>

            <div class="control-group">

                <label class="control-label" for="password"><s:message code="password"/></label>

                <div class="controls">
                    <input id="password" class="input-large" name="password" type="password">
                </div>

            </div>

            <div class="control-group">
                <label class="control-label" for="confirm-password"><s:message code="confirm-password"/></label>
                <div class="controls">
                    <input id="confirm-password" class="input-large" name="confirm-password" type="password" >
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary" type="submit">Create an account</button>
            </div>

        </fieldset>

    </form>

    <img id="user-image" src='<c:url value="/resources/img/user-icon.jpg"/> ' alt="user-icon.jpg" />

</div>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/register.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        var form = $('#register_fm');
        form.validate(registerUserValidaton);
        form.submit(function(e){
            submitUser(document.register_fm);
        });
    });
</script>