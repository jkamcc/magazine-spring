function getUserById(userId) {
    var uri = "http://localhost:8080/service/user/" + userId;
    var user = null;
    $.getJSON(uri, function(data){
        user = data;
    });
    return user;
};


