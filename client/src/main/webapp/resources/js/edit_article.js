var articleValidation = {
    rules: {
        subject: {
            required: true,
            maxlength: 50
        },
        sectionid: {
            required:true
        },
        author: {
            required : true,
            maxlength:100
        },
        article: {
            required: true
        }
    },
    submitHandler: function (form) {
        submitArticle(form);
    },
    errorClass: "error"
};

var ArticleVariables = {};

function Article(articleid, sectionid, subject, author, article, datearticle) {

    if (articleid) this.articleid = articleid;
    this.sectionid = sectionid;
    this.subject = subject;
    this.author = author;
    this.article = article;

    if (datearticle) {
        this.datearticle = new Date(datearticle).getTime();
    } else {
        this.datearticle = new Date().getTime();
    }
}

function submitArticle(form) {
    var article = new Article(form.articleid.value,
        form.sectionid.value, form.subject.value,
        form.author.value, form.article.value, form.datearticle.value);
    //console.info(article);

    if (ArticleVariables.submitButton.hasClass('edit_article')) {
        editArticle(article);
    } else {
        createArticle(article);
    }
};

function createArticle(article) {
    console.info(JSON.stringify(article));
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/service/article/create",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(article),
        success: function() {
            displaySuccessInfoArticle(ArticleVariables.message, ArticleVariables.inputs);
        },
        error: function(response) {
            displayErrorArticle(ArticleVariables.message, response);
        }
    });
}

function editArticle(article) {
    $.ajax({
        type: 'PUT',
        url: "http://localhost:8080/service/article/update",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(article),
        success: function() {
            displaySuccessInfoArticle(ArticleVariables.message, ArticleVariables.inputs);
        },
        error: function(response) {
            displayErrorArticle(ArticleVariables.message, response);
        }
    });
}

function displaySuccessInfoArticle(message, inputs) {
    if (message) {
        message.removeClass('hide').addClass('alert-success');
        message.children().text(ArticleVariables.successMessage);
    }
    if (inputs) inputs.hide();
}

function displayErrorArticle(message, response) {
    if(console) console.error(response.responseText);
    if (message) {
        message.removeClass('hide').addClass('alert-error');
        message.children().text(ArticleVariables.errorMessage +' '+response.responseJSON.message);
    }
}
