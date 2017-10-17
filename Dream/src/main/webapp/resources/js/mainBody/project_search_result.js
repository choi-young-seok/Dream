$(function() {

	var search_keyword = $("#search_keyword").val();
	project_search(search_keyword);
})

function project_search(search_keyword) {
	$.ajax({
		url : '/dream/project_search/' + search_keyword,
		type : 'get',
		error : function(request, status, error) {
			alert("request : " + request.status + "\nerror : " + error)
		},
		beforeSend : function() {
			$("#loading-mask").show();
		},
		success : function(result) {
			$("#loading-mask").fadeOut();
			$.each(result, function(key, value) {
				if (key == "project_title_result") {
					var title_search_list = value;
					var source = $("#project_point_info").html();
					var template = Handlebars.compile(source);
					$("#project_title_result").html(template(title_search_list))
					
					var search_count = ({search_count : value.length})
					var source = $("#search_count").html();
					var template = Handlebars.compile(source);
					$("#title_search_count_area").html(template(search_count))
					
				} else if (key == 'project_category_result') {
					var category_search_list = value;
					var source = $("#project_point_info").html();
					var template = Handlebars.compile(source);
					$("#project_category_result").html(template(category_search_list))

					var search_count = ({search_count : value.length})
					var source = $("#search_count").html();
					var template = Handlebars.compile(source);
					$("#category_search_count").html(template(search_count))
				}
			})
		}// success
	});// ajax
}