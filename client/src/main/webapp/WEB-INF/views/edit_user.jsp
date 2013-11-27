<%@include file="init.jsp"%>

<style type="text/css">
    #user-image {
        width: 320px;
        margin-left: 140px;
    }
    .form-message {
        width: 350px;
    }
    .user-info {
        float: left;
    }
    .right-square {
        float: left;
    }
    .messages {
        float: left;
    }
</style>

<div id="users" class="container-fluid">

    <h1><s:message code="join-message"/></h1>

    <form id="register_fm" name="register_fm" action="javascript:;" method="post" class="well form-horizontal">

        <fieldset>

            <legend><s:message code="register-message"/></legend>

            <div class="messages">
                <div id="message" class="form-message control-group alert hide">
                    <label>ajax</label>
                </div>

                <div id="redirect-message" class="form-message alert alert-info hide">
                    <label><s:message code="register-redirect"/></label>
                </div>
            </div>

            <div class="user-info">

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

            </div>

            <div class="right-square">
                <img id="user-image" src='<c:url value="/resources/img/user-icon.jpg"/> ' alt="user-icon.jpg" />
            </div>

            <div style="clear:both"></div>

        </fieldset>

    </form>
</div>