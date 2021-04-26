$(document).ready(function() {
		$("#marca").change(
	function(){
		var idMarca = $(this).children("option:selected").val();
		console.log(idMarca);		
        $.ajax({
            url: '/DriveventuresWeb/modelows',
            type: 'post',
            data: {'action':"searchByMarca", 'id':idMarca},
            dataType: 'json',
            success:function(response){
            	
                var len = response.length;

                $("#modelo").empty();
                for( var i = 0; i<len; i++){
                    var id = response[i]['id'];
                    var name = response[i]['id'];
                    
                    $("#modelo").append("<option value='"+id+"'>"+name+"</option>");

                }
            },
			error: function() {
				alert(response);	
			}
        });
	}
	)
})
