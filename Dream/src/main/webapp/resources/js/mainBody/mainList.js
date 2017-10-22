$(function(){
	
	$.ajax({
		url:'/dream/mainList',
		type: 'post',
		error : function(request, status, error){
			alert("request : "+request.status+ "\nerror : "+error)
		},
		beforeSend : function(){
		    $("#loading-mask").show();
		},
		success : function(result){
			$("#loading-mask").fadeOut();
			$.each(result,function(key, value){
				if(key == "new_project_list"){
					var source = $("#project_point_info").html();
					var template = Handlebars.compile(source);
					$("#new_project_list").html(template(value))
				}else if(key == "hot_project_list"){
					var source = $("#project_point_info").html();
					var template = Handlebars.compile(source);
					$("#hot_project_list").html(template(value))
				}else if(key == "max_support_project"){
					var source = $("#max_support_project").html();
					var template = Handlebars.compile(source);
					$("#max_support_project_list").html(template(value))
				}
			})
		}// success
	});// ajax
});// ready