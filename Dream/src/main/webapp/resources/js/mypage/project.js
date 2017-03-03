$(function(){
	$("#processing_project_list").click(function(){
		var member_no = $('#session_no').val();
		//kr.co.dream.mypage.controller : MypageViewController.java
		location.href= "/dream/processing_project_View?member_no="+member_no;
	});//processing_project_list click event
});//ready 