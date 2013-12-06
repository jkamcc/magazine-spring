<%@ include file="/WEB-INF/views/init.jsp" %>

<div id="register" class="container-fluid">

    <h1><s:message code="users"/></h1>

    <form id="edit_user_fm" name="edit_user_fm" action="javascript:;" method="post" class="well form-horizontal">
        <fieldset>

            <legend><s:message code="new-user"/></legend>

            <div class="messages">
                <div id="message" class="form-message control-group alert hide">
                    <label><!--ajax--></label>
                </div>
            </div>

            <div class="user-info">

                <div class="control-group">
                    <label class="control-label" for="profile"><s:message code="profile"/></label>
                    <div class="controls">
                        <select id="profile" name="profile">
                            <option></option>
                            <c:forEach items="${profiles}" var="profile">
                                <option value="${profile.value}"
                                        <c:if test="${profile.value == user.profileid}">
                                            selected
                                        </c:if>
                                        >
                                    <s:message code="profile-${profile.key}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="username"><s:message code="username"/></label>
                    <div class="controls">
                        <input id="username" class="input-large" name="username" value="${user.username}" type="text" >
                    </div>

                </div>

                <div class="control-group">
                    <label class="control-label" for="email"><s:message code="email" /></label>
                    <div class="controls">
                        <input id="email" class="input-large" name="email" value="${user.email}" type="text">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="name"><s:message code="name"/></label>
                    <div class="controls">
                        <input id="name" class="input-large" name="name" value="${user.name}" type="text">
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
                    <c:choose>
                        <c:when test="${not empty user}">
                            <button class="btn btn-primary" type="submit"><s:message code="update-user"/></button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-primary" type="submit"><s:message code="register-button"/></button>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </fieldset>

    </form>
</div>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/register.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        UserVariables.message = $('#message');
        UserVariables.action= '${action}';
        if (UserVariables.action == 'new') {
            UserVariables.errorMessage = '<s:message code="error-created-user"/>';
            UserVariables.successMessage = '<s:message code="success-created-user"/>';
        } else {
            UserVariables.errorMessage = '<s:message code="error-edited-user"/>';
            UserVariables.successMessage = '<s:message code="success-edited-user"/>';
        }
        UserVariables.inputs = $('.user-info');

        $('#edit_user_fm').validate(registerUserValidaton);
    });
</script>