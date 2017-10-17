$(function(){

	get_project_reqeust_state("processing_project","T");
	
	$("#project_state > li").click(function(event){
		$("#project_state > li").removeAttr("class");
		$(this).attr("class","active");		
	});//statec click event
	
	$("#projects > li").click(function(){
		$("#projects > li").removeAttr("class")
		$(this).attr("class","active")
	});//
	
	function get_project_reqeust_state(request, success_state){
		var member_no = $("#session_no").val();
		
		$.getJSON('/dream/get_myProject_list/'+member_no+"/"+request+"/"+success_state,
			function(result){
				var source = $("#project_point_info").html();
				var template = Handlebars.compile(source);
				$("#project_list").html(template(result))        
		});//getJSON
	}
	
	$("#projects > li,  #project_state > li").click(function(){
		var request = $("#projects > li.active").attr("title"); 
		var success_state = $("#project_state > li.active").attr("title");
		
		get_project_reqeust_state(request, success_state)
	})

});//ready 