var commentValidation = {
    rules: {
    	commentarticle: {
            required: true
        },
        author: {
            required:true
        },
        articleid: {
            required: true
        }
    },
    submitHandler: function (form) {
        submitComment(form);
    },
    errorClass: "error"
};

var CommentVariables = {};

function Comment(commentarticle, author, articleid) {

    this.articleid = articleid;
    this.commentarticle = commentarticle;
    this.author = author;
    this.articleid = articleid;

    /*if (datearticle) {
        this.datecomment = new Date(datecomment).getTime();
    } else {*/
        this.dateComment = new Date().getTime();
    //}
}

function submitComment(form) {
    var comment = new Comment(form.commentarticle.value,
        form.author.value, form.articleid.value);
    console.info(comment);
    createComment(comment);
};

function createComment(comment) {
	console.info(comment);
    console.info(JSON.stringify(comment));
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/service/comment/create",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(comment),
        success: function() {
            displaySuccessInfoComment(CommentVariables.message, CommentVariables.inputs);
        },
        error: function(response) {
        	displayErrorComment(CommentVariables.message, response);
        }
    });
}

function displaySuccessInfoComment(message, inputs) {
    if (message) {
        message.removeClass('hide').addClass('alert-success');
        message.children().text(CommentVariables.successMessage);
    }
    if (inputs) inputs.hide();
}

function displayErrorComment(message, response) {
    if(console) console.error(response.responseText);
    if (message) {
        message.removeClass('hide').addClass('alert-error');
        message.children().text(CommentVariables.errorMessage +' '+response.responseJSON.message);
    }
}

function goBack(){
	window.history.back();
}

function showMore(){
	var cantidad= $('#commentNumber').val();
	var id=window.location.pathname.split('/')[4];
	 $.ajax({
	        type: 'GET',
	        url: "http://localhost:8080/service/comment/get/"+id+'/'+cantidad+'/'+'3',
	        contentType: "application/json",
	        dataType: "json",
	        data: '',
	        success: function(data) {
				var comentarios= $.makeArray(data);
				for (i=0; i<comentarios.length;++i){
					var newComment= '<div class="article-comment"><p><strong>'+comentarios[i].authorName;
					newComment= newComment+'</strong>: '+comentarios[i].dateComment+'</br>'+comentarios[i].commentarticle+'</p></div>';
					$('#commentsDiv').append(newComment);
				}
				$('#commentNumber').val(parseInt(cantidad,10)+comentarios.length);
	           
	        },
	        error: function(response) {
	        	
	        }
	});
}