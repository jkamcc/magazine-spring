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
    }
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
        this.datearticle = new Date();
    }
}

function submitArticle(form) {
    //var article = new Article(form.articleid.value, form.sectionid)
}
