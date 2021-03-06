function deleteUser(button){
	var id=(button.parentNode.parentNode.children)[0].textContent;
	var row= button.parentNode.parentNode;
	var eliminar=confirm("Are you sure you want to delete this user?");
	if(eliminar){
	    $.ajax({
	        type: "DELETE",
	        url: "http://localhost:8080/service/user/delete/"+id,
	        async: false,
	        data: '',
	        contentType:"application/json",
	        dataType: "json",
	        success: function(data) {
	            $('#usersTable').dataTable().fnDeleteRow(row);
	            $tableS.fnGetData();
	            $('#usersTable').dataTable().fnDraw();
	        },
	        error: function (e){
	            alert("An error have ocurried");
	        }
	    });
	}
};


function editUser(id){
    document.location.href=window.location.toString()+'edit/'+id.trim();
};