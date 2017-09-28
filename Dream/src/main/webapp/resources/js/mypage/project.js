$(function(){
	
	$("#project_Info, #processing_project_list").click(function(){
		var member_no = $("#session_no").val();
		location.replace("/dream/myProject?member_no="+member_no+"&request=processing_project&success_state=T")
	});//project_Info click event
	
	$("#last_project").click(function(){
		var member_no = $("#session_no").val();
		location.replace("/dream/myProject?member_no="+member_no+"&request=last_project&success_state=T")
	});//project_Info click event
	
	$("#during_registration").click(function(){
		var member_no = $("#session_no").val();
		location.replace("/dream/myProject?member_no="+member_no+"&request=during_registration")
	});//project_Info click event
	

	$("#projects > li").click(function(event){
		$("#projects > li").removeAttr("class");
		$(this).attr("class","active");		
		$("#project_state > li:eq(0)").attr("class","active");
	});//projects click event

	$("#project_state > li").click(function(event){
		$("#project_state > li").removeAttr("class");
		$(this).attr("class","active");		
	});//statec click event
	
	function get_project_reqeust_state(){
		var member_no = $("#session_no").val();
		
		var request = $("#projects > li.active").attr("title"); 
		var success_state = $("#project_state > li.active").attr("title");
		
		if(request == "during_registration"){
			location.replace("/dream/myProject?member_no="+member_no+"&request="+request)
			return;
		}
		
		location.replace("/dream/myProject?member_no="+member_no+"&request="+request+"&success_state="+success_state)
	}
	
	$("#project_condition > #projects >li , #project_state > li").click(function(event){
		get_project_reqeust_state()

	});//click event;

});//ready 