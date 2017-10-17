$(function() {
//	$("#category").click(function() {
//	})
		var category = $(this).attr("title")
		get_category_project_list(category)
})

function get_category_project_list(category){
	$.ajax({
		url:'/dream/main_category_list/'+category,
		type: 'get',
		error : function(request, status, error){
			alert("request : "+request.status+ "\nerror : "+error)
		},
		beforeSend : function(){
		    $("#loading-mask").show();
		},
		success : function(result){
			$("#loading-mask").fadeOut();
//			$(result).each(function(){
//				var percentage = this.projectOperDTO.project_percentage;
//				if(this.projectOperDTO.project_percentage > 100){
//					percentage = 100;
//				}else if(this.projectOperDTO.project_percentage == 0){
//					percentage = 10;
//				}
//		});// each
				var source = $("#project_point_info").html();
				var template = Handlebars.compile(source);
				$("#category_project_list").html(template(result))
				
//			$('#mainResultView').html(mainList);
		}// success
	});// ajax
}