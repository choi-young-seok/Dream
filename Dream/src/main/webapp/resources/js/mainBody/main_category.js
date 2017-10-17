$(function(){
	$("#category_list > div").click(function(){
		var category = $(this).attr("title")
		location.href = "/dream/project_category?category="+category
	})
	
	$.ajax({
		url:'/dream/main_category_project',
		type: 'get',
		error : function(request, status, error){
			alert("request : "+request.status+ "\nerror : "+error)
		},
		beforeSend : function(){
		    $("#loading-mask").show();
		},
		success : function(result){
			$("#loading-mask").fadeOut();
			$(result).each(function(){
					var source = $("#feature_project_category").html();
					var template = Handlebars.compile(source);
					$("#project_category_title").html(template(result))
					$(result).each(function(){
						var source = $("#project_point_info").html();
						var template = Handlebars.compile(source);
						$("#category_projects"+this.project_category).html(template(this.projectPointDTOs))						
					})
			})
		}// success
	});// ajax
})