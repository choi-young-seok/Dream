$(function(){
	$("#support_project_view").click(function(){
		var project_no = $("#project_no").val();
		location.href = "/dream/support_choice_View?project_no="+project_no;
	});//support_project click event
	
	$("#support_project_input").click(function(event) {
		var reward_no = 0;
		var support_amount = $("#support_input_amount").val();
		if(support_amount == ""){
			alert("금액을 입력하세요")
			$("#support_input_amount").focus();
			return;
		}
		pay_info_registForm(support_amount, reward_no);
	});// support_input_amount : support_project click event
	
	$("div#reward_List > * button").click(function() { 
		var reward_no = $(this).attr("param");    // param 속성에 지정된 total_reward_no
	    var support_amount = $("#support_amount").val();
	    pay_info_registForm(support_amount, reward_no);
	});// dev#reward_List > input click event
	
	function pay_info_registForm(support_amount,reward_no){  
		var project_no = $("#project_no").val();
		var member_no = $("#session_no").val();
		if(reward_no == 0){
			location.href = "/dream/support_NoReward_View?project_no="+project_no+"&support_amount="+support_amount	
			return;
		}else{
			location.href = "/dream/support_selectReward_view?member_no="+member_no+"&project_no="+project_no+"&reward_no="+reward_no+"&support_amount="+support_amount	
		}
	  } // get next Page reqeust


});//ready