$(function() {
	
	var member_no = $("#session_no").val();
	
	$("#loginBtn").click(function() {
		$("#loginModal").modal();
	});// click event
	
	$("#mypage_Main").click(function(){
		location.href = "/dream/mypageMain?member_no="+member_no;
	});//mypageMain click event
});// ready
