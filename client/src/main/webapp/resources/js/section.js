$(document).ready(function(){

    // Valida contra expresion regular
    jQuery.validator.addMethod("regx", function(value, element, regexpr) {
        return regexpr.test(value);
    }, "Please enter a valid name");

    var dataAjax;
    var $tableS= $('#sectionTable').dataTable( {
        "bProcessing": true,
        "aaSorting": [[ 1, "asc" ]],
        "sAjaxSource": $.ajax({
            type: "GET",
            url: "http://localhost:8080/service/section/all",
            async: false,
            data: ' ',
            contentType:"application/json",
            dataType: "json",
            success: function(data) {
                dataAjax=  $.makeArray(data);
                for(i=0; i<dataAjax.length;++i){
                    dataAjax[i].boton='<input type="button" class="deleteButton" value="Delete"/>';
                }
            },
        }),
        "aaData": dataAjax,
        aoColumns: [
            { mData: 'sectionid' },
            { mData: 'sectionArticle' },
            {mData:'boton',"fnRender": function( oObj ) {return '<input type="button" class="deleteButton" value="Delete"/>';}}
        ],
    })

    $("#add_fm").validate({
        rules: {
            sectionArticle: {
                required: true,
                maxlength: 50,
                regx: /^[a-zA-Z]+(?=\d?)/,
            }
        },
        messages:{
            sectionArticle: {
                required:"* Required field",
                maxlength:"* El campo no puede exceder los 50 caracteres",
                regx: "* El campo debe contener al menos una letra",
            }
        },
    });


    $('#addButton').click(function(){
        if($("#add_fm").valid()){
            var dataAjax;
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/service/section/create",
                async: false,
                data: '{"sectionArticle":'+'"'+$('#sectionArticle').val()+'"}',
                contentType:"application/json",
                dataType: "json",
                success: function(data) {
                    dataAjax=  $.makeArray(data);
                    dataAjax[0].boton='<input type="button" class="deleteButton" value="Delete"/>';
                    $('#sectionTable').dataTable().fnAddData(dataAjax);
                    $('#sectionArticle').val(' ');
                    $tableS.fnGetData();
                    $('#sectionTable').dataTable().fnDraw();
                },
                error: function (e){
                    return null;
                }
            });
            return false;
        }else{
            alert ('Los datos ingresados no son validos');
        }
    });


    $('.deleteButton').click(function(){
            var id=(this.parentNode.parentNode.children)[0].textContent;
            var tableRows= this.parentNode.parentNode.parentNode.children;
            var posicion=0;
            for(i=0; i<tableRows.length;++i){
                if((tableRows.item(i)).children.item(0).textContent==id){
                    posicion=i;
                }
            }
            $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/service/section/delete/"+id,
                async: false,
                data: '',
                contentType:"application/json",
                dataType: "json",
                success: function(data) {
                    $('#sectionTable').dataTable().fnDeleteRow(posicion);
                    $tableS.fnGetData();
                    $('#sectionTable').dataTable().fnDraw();
                },
                error: function (e){
                    alert("Se ha producido un error al insertar");
                }
            });
        }
    );
});