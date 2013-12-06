function deleteArticle(button){
	var id=(button.parentNode.parentNode.children)[4].textContent;
	var row= button.parentNode.parentNode;
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/service/article/delete/"+id,
        async: false,
        data: '',
        contentType:"application/json",
        dataType: "json",
        success: function(data) {
        	var eliminar=confirm("Are you sure you want to delete the article?");
            if(eliminar){
            	$('#articlesTable').dataTable().fnDeleteRow(row);
            	$tableS.fnGetData();
                $('#articlesTable').dataTable().fnDraw();
            }
            
        },
        error: function (e){
            alert("Se ha producido un error al eliminar");
        }
    });
};


function editArticle(id){
    document.location.href=window.location.toString()+'edit/'+id;
};