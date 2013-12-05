function deleteArticle(id, posicion){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/service/article/delete/"+id,
        async: false,
        data: '',
        contentType:"application/json",
        dataType: "json",
        success: function(data) {
            $('#articlesTable').dataTable().fnDeleteRow(posicion);
            $tableS.fnGetData();
            $('#articlesTable').dataTable().fnDraw();
        },
        error: function (e){
            alert("Se ha producido un error al eliminar");
        }
    });
};


function editArticle(id){
    document.location.href='/edit/'+id;
};