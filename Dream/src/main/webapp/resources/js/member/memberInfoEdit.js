$(function(){
	//비밀번호 일치성 검사 이벤트
	$('#member_pass').keyup(function(){
		//pass_Check함수 위치 : resouces/js/common/validityCheck.js
		pass_Check();
	});// member_pass_check keyup event

	$('#member_pass_check').keyup(function(){
		//pass_Check함수 위치 : resouces/js/common/validityCheck.js
		pass_Check();
	});// member_pass_check keyup event
	
	
	//회원정보 수정 
	$('#memberInfoEdit').click(function(){
		
	});//memberInfoEdit click event
	
});//ready