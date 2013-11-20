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
    errorClass: "error help-inline"
};

function UserArticle(username, name, password, profile, profileid, email) {
    this.username = username;
    this.name = name;
    this.password = password;
    this.profile = profile;
    this.profileid = profileid;
    this.email = email;
};

function submitUser(nodeForm) {
    var userArticle = new UserArticle(nodeForm.username.value, nodeForm.name.value,
        nodeForm.password.value, nodeForm.profile.value,
        nodeForm.profileid.value, nodeForm.email.value);

    console.info(userArticle);
    registerUser(userArticle);
}

function registerUser(userArticle) {
    var user = JSON.stringify(userArticle);
    console.info(user);
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/service/user/create",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(userArticle),
        success: function(response) {
            console.info(response);
        },
        error: function(e) {
            console.error(e.responseText);
        }
    });
}