$(function(){
	$("#member_info_toggle_item").hide();
	$("#member_info_toggle_title").click(function(){
		$("#member_info_toggle_item").slideToggle();
	});//member_info_toggle_title click event
	
	$("#project_info_toggle_item").hide();
	$("#project_info_toggle_title").click(function(){
		$("#project_info_toggle_item").slideToggle();
	});//member_info_toggle_title click event
	
	$("#support_info_toggle_item").hide();
	$("#support_info_toggle_title").click(function(){
		$("#support_info_toggle_item").slideToggle();
	});//member_info_toggle_title click event
	
	$("#delivery_info_toggle_item").hide();
	$("#delivery_info_toggle_title").click(function(){
		$("#delivery_info_toggle_item").slideToggle();
	});//member_info_toggle_title click event
	
	$("#pay_info_toggle_item").hide();
	$("#pay_info_toggle_title").click(function(){
		$("#pay_info_toggle_item").slideToggle();
	});//member_info_toggle_title click event
	
	$("#processing_project_list").click(function(){
		var member_no = $('#session_no').val();
		alert("session_no"+member_no);
		$.ajax({
			url : '/dream/processing_project_list',
			type: 'post',
			data: {
				member_no : member_no
			},
			dataType : 'text',
			success : function(result){
				alert(result)
			}
		});//ajax
	});//processing_project_list click event
	
});//ready