$(function() {
	var member_no = $('#session_no').val();
	var member_mail = $("#session_mail").val();
	
	//비밀번호 변경 페이지 초기 화면 설정
	$(".edit_form").hide();
	$("#pass_edit_btn").hide();
	
	
	//ㅡㅡㅡㅡㅡ mypage memberBtn click event ㅡㅡㅡㅡㅡ
	//헤더 내 정보 보기 버튼 클릭 이벤트
	$('#member_Info').click(function() {
		location.href="/dream/memberInfoView?member_no="+member_no;
	});// memberInfoView click event

	//메인페이지 메인 회원정보 버튼 클릭 이벤트
	$("#member_Info_Edit").click(function(){
		location.href = "/dream/memberInfoView?member_no="+member_no;
	});//member_Info click event
	
	//사이드바 회원정보 수정 버튼 클릭 이벤트
	$("#member_Info_View").click(function(){
		location.href = "/dream/memberInfoView?member_no="+member_no;		
	});//member_Info_Edit

	//사이드바 비밀번호 수정 버튼 클릭 이벤트
	$("#password_Info_Edit_View").click(function(){
		location.href = "/dream/password_Info_Edit_View?member_no="+member_no;	

	});//password_Info_Edit_View click event

	//ㅡㅡㅡㅡㅡ 탭리스트 로직 ajax전송으로 수정할것ㅡㅡㅡㅡㅡ
	//회원정보 탭 리스트 회원정보 수정 버튼 클릭 이벤트
	$("#member_Info_Edit_Tab").click(function(){
		location.href = "/dream/memberInfoView?member_no="+member_no;		
	});//member_Info_Edit
	
	//회원정보 탭 리스트 비밀번호 변경 버튼 클릭 이벤트
	$("#password_Info_Edit_Tab").click(function(){
		location.href = "/dream/password_Info_Edit_View?member_no="+member_no;
		$(this).parent().addClass("active");
//		alert($(this))
//		alert($(this).parent())
	});//password_Info_Edit_Tab click event
	
	//비밀번호 변경 화면 : 비빌번호 확인 버튼 클릭 이벤트
	$("#pass_check_btn").click(function(){
		var check_password = $("#check_password").val();
		alert(check_password+"/"+member_no+"/"+member_mail);
		
		$.ajax({
			url : '/dream/password_check',
			type : 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				login_mail : member_mail,
				login_pass : check_password
			}),// data
			success : function(result){
				alert(result);
				if(result =='success'){
					$(".edit_form").show();
					$("#pass_edit_btn").show();
					$(".check_form").hide();
					$("#pass_check_btn").hide();
				}
				else{
					alert("비밀번호 확인에 실패 하였습니다.\n 다시 입력해주세요")
					$(".edit_form").hide();
				}
			}
		});//ajax
	});//pass_check_btn click event
	
	//변경 비밀번호 일치성 검사
	$('#member_pass').keyup(function(){
		//pass_Check함수 위치 : resouces/js/common/validityCheck.js
		pass_Check();
	});// member_pass keyup event

	$('#member_pass_check').keyup(function(){
		//pass_Check함수 위치 : resouces/js/common/validityCheck.js
		pass_Check();
	});// member_pass_check keyup event
	
	//비밀번호 변경
	$("#pass_edit_btn").click(function(){
		var member_pass = $("#member_pass").val();
		
		$.ajax({
			url : '/dream/password_edit',
			type : 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				member_mail : member_mail,
				member_pass : member_pass
			}),// data
			success : function(editPass) {
				if(editPass=='success'){
					alert("비밀번호 변경 완료");
					location.href="/dream/memberInfoView?member_no="+member_no;
				}
			}// success
		});//ajax
	});//pass_edit_btn click event	

	//프로필 사진 수정
	$('#memberInfoEdit').click(function(){
		
		var member_profile = $('#member_profile').val();
		
		$.ajax({
			url : '/dream/memberInfoEdit',
			type : 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data :JSON.stringify({
				member_no : member_no,
				member_profile : member_profile
			}), // data
			success : function(result) {
				location.reload();
			}// success
		});// ajax
		
	});//memberInfoEdit click event
	
	var member_profile_value = $("#member_profile_value").val();
	if(member_profile_value =='NO PROFILE'){
		
		$('#profileArea').show();
		$('#proFileZone').hide();		
	}else{
		$('#profileArea').hide();
		$('#proFileZone').show();		
	}
	
	$('#profileEdit').click(function(){
		$('#profileArea').show();
		$('#proFileZone').hide();		
	});//profileEdit click event
 
});// ready
