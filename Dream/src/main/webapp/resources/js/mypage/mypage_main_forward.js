$(function(){
	
	var member_no = $("#session_no").val();
	
	//마이 페이지 메인, 사이드 메뉴 회원정보
	$("#member_info").click(function(){
		location.href = "/dream/mypage_member_info?member_no="+member_no;
	});//member_Info click event
	
	//마이 페이지 메인, 사이드 메뉴 프로젝트 정보
	$("#project_info").click(function(){
		location.href = "/dream/mypage_project";
	});//project_Info click event
	
//	//사이드바, 탭리스트 배송정보 조회 버튼 클릭 이벤트
	$("#address_info").click(function(){
		location.href = "/dream/mypage_address";
	});//password_Info_Edit_View click event
	
	$("#support_info").click(function(){
		location.href ="/dream/mypage_support";
	});//support_Info click event
});//