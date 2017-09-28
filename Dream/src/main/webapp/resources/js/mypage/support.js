$(function(){
	$("#support_Info").click(function(){
		var member_no = $("#session_no").val();
		location.href ="/dream/mypage_support_info_view?member_no="+member_no;
	});//support_Info click event
	
	$("#total_support_info").click(function(){		
		location.href ="/dream/supportPointView?member_no="+member_no;
	});//total_support_info click event
});//ready
