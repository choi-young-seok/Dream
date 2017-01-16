//비밀번호 일치성 검사 함수부
function pass_Check() {
	var member_pass = $('#member_pass').val();
	var member_pass_check = $('#member_pass_check').val();

	if (member_pass == member_pass_check) {
		$('#pass_check').html("<span class='success'> 비밀번호가 일치합니다 </span>");
	} else {
		$('#pass_check').html("<span class='fail'> 비밀번호를 확인하세요 </span>");
	}// esle
}// function pass_Check
