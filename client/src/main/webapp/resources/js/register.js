var registerUserValidaton = {
    rules: {
        username: {
            required: true,
            maxlength: 20
        },
        name: 'required',
        email: {
            required : true,
            email : true,
            maxlength: 50
        },
        password: {
            required: true,
            minlength: 5
        },
        "confirm-password": {
            equalTo: "#password"
        }
    },
    submitHandler: function (form) {
        submitUser(form);
    },
    errorClass: "error"
};

function UserArticle(username, name, password, profile, profileid, email, userid) {
    if (userid) this.userid = userid;
    this.username = username;
    this.name = name;
    this.password = password;
    this.profile = profile;
    this.profileid = profileid;
    this.email = email;
}

UserVariables = {};

function submitUser(form) {
    var userArticle = new UserArticle(form.username.value, form.name.value,
        form.password.value, form.profile.value,
        form.profileid.value, form.email.value, form.userid.value);
    //console.info(userArticle);
    switch (UserVariables.action) {
        case 'new':
            modifyUser(userArticle, 'create');
            break;
        case 'edit':
            modifyUser(userArticle, '/magazine/users/edit');
            break;
        case 'register':
            modifyUser(userArticle, 'register');
            break;
    }
}

function modifyUser(userArticle, urlVal) {
    $.ajax({
        type: 'POST',
        url: urlVal,
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(userArticle),
        complete: function(xhr) {
            if (xhr.status === 200) {
                doSuccessfullRegister();
            } else {
                doFailRegister();
            }
        }
    });
}

function doSuccessfullRegister() {
    if (UserVariables.message) {
        UserVariables.message.removeClass('hide').addClass('alert-success');
        UserVariables.message.children().text(UserVariables.successMessage);
    }
    if (UserVariables.inputs) UserVariables.inputs.hide();
    if (UserVariables.redirect) {
        UserVariables.redirect.message.removeClass('hide');
        setTimeout(function(){
            self.location = UserVariables.redirect.url;
        }, 3000);
    }
}

function doFailRegister() {
    if(console) console.error(response.responseText);
    if (message) {
        message.removeClass('hide').addClass('alert-error');
        message.children().text(UserVariables.errorMessage + ' ' + xhr.responseText);
    }
}
