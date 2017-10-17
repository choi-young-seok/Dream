//비밀번호 일치성 검사 함수부

function pass_Check(member_pass, member_pass_check) {
	var reg_pass = /^.*(?=.{4,8})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	
	var member_pass = $('#member_pass').val();
	var member_pass_check = $('#member_pass_check').val();

	if(member_pass == ''){
		$('#pass_check').html("<b><span class='danger'> 비밀번호를 입력하세요 </span></b>");

	}else if(!reg_pass.test(member_pass)){		
		$('#pass_check').html("<b><span class='danger'> 영문,숫자를 조합한 4~8자리로 입력하세요 </span></b>");

	}else if (member_pass_check == '') {
		$('#pass_check').html("<b><span class='danger'> 비밀번호 확인란을 입력하세요 </span></b>");

	} else {
		if (member_pass == member_pass_check) {
			$('#pass_check').html("<b><span class='success'> 비밀번호가 일치합니다 </span></b>");
			$('#passCheck').val("success");
		} else {
			$('#pass_check').html("<b><span class='fail'> 비밀번호가 일치 하지 않습니다</span></b>");

		}// inner else
	}// outer else
}// function pass_Check


	//mail from check function
	function mailFormCheck(member_authMail) {
		if(member_authMail == ''){
			$('#idDuplicationCheck').html('');
			$('#mailAuthNumBtn').hide();
			return false;
		}else{
			var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
			if (regex.test(member_authMail) == false) {
				$('#idDuplicationCheck').html("<span class='fail'>메일 형식을 다시 확인해주세요</span>");
				$("#mailAuthNumBtn").hide();
				return false;
			}else{
				return true;
			}
		}
	}


///var reg_ppass = ^.*(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-]).*$/;
//소문자+대문자+숫자+특수문자
///var reg_kor = ^[가-힣]+$
//한글 유효성검사
//
