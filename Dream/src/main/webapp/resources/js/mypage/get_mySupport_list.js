$(function(){
	var member_no = $("#session_no").val();
	var payback_check = 'N';
	
	get_mySupport_reward_info_list(member_no, payback_check);
	
	$("#mySupportList").on("click","#reward_support_detail_info",function(){
		var support_no = $(this).attr("param")
		location.href="/dream/supportDetailView_reward?member_no="+member_no+"&support_no="+support_no;
	});//support_detail_info click event
	
	$("#mySupportList").on("click","#noreward_support_detail_info",function(){
		var support_no = $(this).attr("param")
		location.href="/dream/supportDetailView_noReward?member_no="+member_no+"&support_no="+support_no;
	});//support_detail_info click event
	
	$("#reward_support_list").click(function(){
		get_mySupport_reward_info_list(member_no, payback_check);
	})

	$("#noReward_support_list").click(function(){
		get_mySupport_noReward_info_list(member_no, payback_check);
	});//
});//
function get_mySupport_reward_info_list(member_no, payback_check){
//		payback_check : N (결제목록)
//		payback_check : Y (환불목록)
	$.getJSON('/dream/get_mySupport_reward_info_list/'+member_no+"/"+payback_check, 
			
			function(result){
				var source = $("#support_point_info").html();
				var template = Handlebars.compile(source);
				$("#mySupportList").html(template(result))
	});//getJSON
}

function get_mySupport_noReward_info_list(member_no, payback_check){
	//	payback_check : N (결제목록)
	//	payback_check : Y (환불목록)
	$.getJSON('/dream/get_mySupport_noReward_info_list/'+member_no+"/"+payback_check, function(result){
		var source = $("#support_point_info_noReward").html();
		var template = Handlebars.compile(source);
		$("#mySupportList").html(template(result))
	});//getJSON
}