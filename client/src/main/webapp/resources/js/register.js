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
        submitUser(form, registerUserValidaton.message);
    },
    errorClass: "error"
};

var UserVariables = {
    message: null,
    successMessage: null,
    errorMessage: null,
    inputs: null,
    redirect: {
        url: null,
        message: null
    }
};

function UserArticle(username, name, password, profile, profileid, email) {
    this.username = username;
    this.name = name;
    this.password = password;
    this.profile = profile;
    this.profileid = profileid;
    this.email = email;
};

function submitUser(form) {
    var userArticle = new UserArticle(form.username.value, form.name.value,
        form.password.value, form.profile.value,
        form.profileid.value, form.email.value);
    console.info(userArticle);
    registerUser(userArticle);
};

function registerUser(userArticle) {
    var user = JSON.stringify(userArticle);
    var message = UserVariables.message;
    var inputs = UserVariables.inputs;
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/service/user/create",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(userArticle),
        success: function(response) {
            if (message) {
                message.removeClass('hide').addClass('alert-success');
                message.children().text(UserVariables.successMessage);
            }

            if ($('.user-info')) inputs.hide();
        },
        error: function(response) {
            console.error(response.responseText);
            if (message) {
                message.removeClass('hide').addClass('alert-error');
                message.children().text(UserVariables.errorMessage +' '+response.responseJSON.message);
            }
            if (UserVariables.inputs) UserVariables.inputs.hide();
        }
    });
}