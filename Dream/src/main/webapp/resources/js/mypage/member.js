$(function() {
	var member_no = $('#session_no').val();
	var member_mail = $("#session_mail").val();
	
	//비밀번호 변경 페이지 초기 화면 설정
	$(".edit_form").hide();
	$("#pass_edit_btn").hide();
	
	//비밀번호 변경 화면 : 비빌번호 확인 버튼 클릭 이벤트
	$("#pass_check_btn").click(function(){
		var check_password = $("#check_password").val();
		
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
					location.href="/dream/mypage_member_info?member_no="+member_no;
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
