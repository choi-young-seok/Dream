$(function(){
	
	var member_no = $("#session_no").val();
	
	//마이페이지 메인
	$("#mypage_main_side").click(function(){
		location.href = "/dream/mypage";
	});//
	
//	마이페이지 : 회원
	//사이드바 회원정보
	$("#member_info_side").click(function(){
		location.href = "/dream/mypage_member_info?member_no="+member_no;
	});//member_Info click event
	
	//사이드바 비밀번호 수정 
	$("#password_info_edit_side").click(function(){
		location.href = "/dream/mypage_member_password_update";
	});//password_Info_Edit_View click event
	
	//사이드바 회원 탈퇴 : 미구현 
	$("#member_withdraw_side").click(function(){
		alert("회원탈퇴 미구현")
		location.href = "/dream/mypage_member_withdraw";	
	});//password_Info_Edit_View click event
	
// 마이페이지 : 프로젝트
	//사이드바 진행 프로젝트
	$("#processing_project_list_side").click(function(){
		location.href = "/dream/mypage_project";
//		location.replace("/dream/myProject?member_no="+member_no+"&request=processing_project&success_state=T")
	});//project_Info click event
	
	// 사이드바 지난 프로젝트
	$("#last_project_side").click(function(){
		location.href = "/dream/mypage_project";
//		location.replace("/dream/myProject?member_no="+member_no+"&request=last_project&success_state=T")
	});//project_Info click event
	
	// 사이드바 등록중 프로젝트
	$("#during_registration_side").click(function(){
		location.href = "/dream/mypage_project";
//		location.replace("/dream/myProject?member_no="+member_no+"&request=during_registration")
	});//project_Info click event
	
//	마이페이지 : 주소지
	//사이드바, 배송정보 조회 버튼 클릭 이벤트
	$("#address_info_side").click(function(){
		location.href = "/dream/mypage_address";
	});//password_Info_Edit_View click event
	
//	마이페이지 : 후원
	//사이드바 후원 정보
	$("#support_info_side").click(function(){
		location.href ="/dream/mypage_support";
	});//support_Info click event
	
//	마이페이지 : 관심 프로젝트
	//사이드바 관심 프로젝트
	$("#interest_project_side").click(function(){
		alert("관심 프로젝트 미구현")
//		location.href ="/dream/mypage_support_info_view?member_no="+member_no;
	});//support_Info click event
});//