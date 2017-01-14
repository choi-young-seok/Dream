$(function() {
	$("#mailAuthNumBtn").hide();
	// - 아이디 중복 체크 이벤트
	$('#member_authMail').keyup(function() {		
		var member_authMail = $('#member_authMail').val();
		$.ajax({
			url : '/dream/idDuplicationCheck',
			type : 'post',
// headers : {
// "Content-Type" : "application/json",
// "X-HTTP-Method-Override" : "POST"
// },// headers
			dataType : 'text',
// data : JSON.stringify({
// member_authMail : member_authMail,
// }),// data
			data : {
				member_authMail : member_authMail,
			},// data
			success : function(result) {
				if(result == 'noResult'){
					$('#idDuplicationCheck').html('');
					$("#mailAuthNumBtn").hide();
				}
			else if (result == 'success') {
					$('#idDuplicationCheck').html("<span class='success'>사용가능한 아이디입니다</span>");
					$("#mailAuthNumBtn").show();
				} else {
					$('#idDuplicationCheck').html("<span class='fail'>이미 존재하는 아이디 입니다</span>");
					$("#mailAuthNumBtn").hide();
				}
			}// success
		});// ajax
	});// member_mail keypress event

	// - 회원가입 버튼 클릭 이벤트
	$('#joinBtn').click(function() {

		// - 중복검사 여부 확인부
		// - if(중복검사x){중복검사 요청 호출부}
		// - else{중복검사 요청 일치 호출부}
		// - 일치시 유효성검사 호출부
		// - 유효성검사 완료시 컨트롤러에 요청접수

		var member_mail = $('#member_mail').val();
		var member_pass = $('#member_pass').val();
		var member_name = $('#member_name').val();
		var member_birth = $('#member_birth').val();
		var member_gender = $("#member_gender").is(":checked");
		if (member_gender) {
			var member_gender = 'M';
		} else {
			var member_gender = 'F';
		}
		//
		// $('#member_gender').checkOn(function(){
		// var member_gender = $('#member_gender').val();
		// });
		alert(member_gender);
		// var member_gender = $('#member_gender').val();

		// - 유효성 검사 호출부

		$.ajax({
			type : 'post',
			url : '/dream/memberJoin',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				member_mail : member_mail,
				member_pass : member_pass,
				member_name : member_name,
				member_birth : member_birth,
				member_gender : member_gender
			}), // data
			success : function(result) {
				if (result == "success") {
					alert("가입이 완료 되었습니다.")
					location.href = "/dream";
				} else {
					alert("회원가입에 실패하였습니다.")
				}
			}// success
		});// ajax
	});// joinBtn click event

	// - 메일 중복 검사 여부 함수부
	// - 메일 중복검사 요청 함수부
	// - 회원가입 정보 유효성 검사 함수부

	// - 회원가입 취소 버튼 클릭 이벤트
	$('#cancelBtn').click(function() {
		var check = confirm("입력된 내용은 저장되지 않습니다. 취소하시겠습니까?");
		// '예' 클릭시 (check == true) mainBody.jsp로 이동
		if (check) {
			location.href = "/dream"
		}
	});// cancelBtn click event

});// ready

