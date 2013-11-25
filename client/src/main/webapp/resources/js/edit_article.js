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

var ArticleVariables = {
	    message: null,
	    successMessage: null,
	    errorMessage: null,
	    inputs: null
};

function Article(articleid, sectionid, subject, author, article, datearticle) {

    if (articleid) this.articleid = articleid;
    this.sectionid = sectionid;
    this.subject = subject;
    this.author = author;
    this.article = article;

    if (datearticle) {
        this.datearticle = datearticle;
    } else {
        this.datearticle = new Date().getTime();
    }
}


function submitArticle(form) {
    var article = new Article(form.articleid.value,
        form.sectionid.value, form.subject.value,
        form.author.value, form.article.value, form.datearticle.value);
    console.info(article);
	garticle = article;
	createArticle(article);
	
};


function createArticle(article) {
    var articleJSON = JSON.stringify(article);
	console.info(articleJSON);
    var message = ArticleVariables.message;
    var inputs = ArticleVariables.inputs;
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/service/article/create",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(article),
        success: function(response) {
            if (message) {
                message.removeClass('hide').addClass('alert-success');
                message.children().text(ArticleVariables.successMessage);
            }

            if (inputs) inputs.hide();
        },
        error: function(response) {
            if(console) console.error(response.responseText);
            if (message) {
                message.removeClass('hide').addClass('alert-error');
                message.children().text(ArticleVariables.errorMessage +' '+response.responseJSON.message);
            }
            if (ArticleVariables.inputs) ArticleVariables.inputs.hide();
        }
    });
}
