$(function(){
	$("#project_search_btn").click(function(){
		var project_search_keyword = $("#project_search_keyword").val();
		if(project_search_keyword == ''){
			alert("검색어를 입력하세요")
			return;
		}
		location.href = "/dream/search_result_view?search_keyword="+project_search_keyword
	})
	
		$("#project_search_keyword").keydown(function(event){
		var project_search_keyword = $("#project_search_keyword").val();
		if(event.keyCode == 13){
			if(project_search_keyword == ''){
				alert("검색어를 입력하세요")
				return;
			}
			location.href = "/dream/search_result_view?search_keyword="+project_search_keyword
			event.preventDefault();
			return;
		}
	})
	
	
})