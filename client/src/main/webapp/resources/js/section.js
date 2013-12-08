$(document).ready(function(){

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
                    dataAjax[i].boton='<button class="btn btn-small editButton"><s:message code="button-edit"/>&nbsp;<i class="fa fa-edit"></i></button><button class="btn btn-small deleteButton"><s:message code="button-delete"/>&nbsp;<i class="fa fa-trash-o"></i></button>';
                }
            },
        }),
        "aaData": dataAjax,
        aoColumns: [
            { mData: 'sectionid' },
            { mData: 'sectionArticle' },
            {mData:'boton'},
        ]
    });

    $("#add_fm").validate({
        rules: {
            sectionArticle: {
                required: true,
                maxlength: 50,
            }
        },
        messages:{
            sectionArticle: {
                required:"* Required field",
                maxlength:"* The maximum length is 50 characters",
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
					if(data.sectionid!=0){
						dataAjax=  $.makeArray(data);
						dataAjax[0].boton='<button class="btn btn-small editButton"><s:message code="button-edit"/>&nbsp;<i class="fa fa-edit"></i></button><button class="btn btn-small deleteButton"><s:message code="button-delete"/>&nbsp;<i class="fa fa-trash-o"></i></button>';
			            $('#sectionTable').dataTable().fnAddData(dataAjax);
						$('#sectionArticle').val(' ');
						$tableS.fnGetData();
						$('#sectionTable').dataTable().fnDraw();
					}
					else{
						alert("The section couldn't be created");
					}
                },
                error: function (e){
                    alert("The section couldn't be created");
                }
            });
            return false;
        }else{
            alert ('The data inserted is not valid');
        }
    });
	
	$(document).on("click", ".deleteButton", function() {
		deleteRow(this, $('#sectionTable'));
	});

	$(document).on("click", ".editButton", function() {
		var name=prompt("Please enter a new section name","");
    	if (name!=null && name.length<=50 && /^[a-zA-Z]+(?=\d?)/.test(name)){
    		updateRow(this,$('#sectionTable'), name);
    	}
    	else{
    		alert('The data inserted is not valid');
    	}
	});
	
	function deleteRow(button, table){
		var id=(button.parentNode.parentNode.children)[0].textContent;
		var row= button.parentNode.parentNode;
		 $.ajax({
			 type: "DELETE",
			 url: "http://localhost:8080/service/section/delete/"+id,
			 async: false,
			 data: '',
			 contentType:"application/json",
			 dataType: "json",
			 success: function(data) {
				table.dataTable().fnDraw();
				table.dataTable().fnDeleteRow(row);
				table.dataTable().fnGetData();
				table.dataTable().fnDraw();
			 },
			 error: function (e){
				 alert("The section cann't be deleted");
			 }
		 });
	}

	function updateRow(button, table, name){
		var id=(button.parentNode.parentNode.children)[0].textContent;
		var tableRows= button.parentNode.parentNode.parentNode.children;
		var dato='{"sectionid":'+id+', "sectionArticle":'+'"'+name+'"}';
		$.ajax({
			type: "PUT",
			url: "http://localhost:8080/service/section/update/",
			async: false,
			data: dato,
			contentType:"application/json",
			dataType: "json",
			success: function(data) {
				(button.parentNode.parentNode.children)[1].textContent=name;
				table.dataTable().fnGetData();
				table.dataTable().fnDraw();
			},
			error: function (e){
				alert("The section cann't be updated");
			}
		});
	}
});
