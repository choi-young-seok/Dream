$(function() {
	var ranAuthNum;
	$("#mailAuthNumBtn").hide();
	
	//메일 인증 모달창 출력
	$("#member_mail").click(function() {
		// backdrop 옵션 : 뒷배경 처리
		// backdrop : true 뒷배경 클릭시 modal off처리 + 뒷배경 static 처리
		// backdrop : false 뒷배경 클릭시 modal on처리 + 뒷배경 nonstatic 처리
		// backdrop : true 뒷배경 클릭시 modal on처리 + 뒷배경 static 처리
		$("#mailAuthModal").modal({
			backdrop : "static"
		});

	});// click event

	$('#mailAuthNumBtn').click(function() {
		var member_authMail = $('#member_authMail').val();
		var member_name = $('#member_name').val();
		
		if(confirm($('#member_authMail').val() + "로 인증번호를 보내시겠습니까?")){
			$.ajax({
				url : '/dream/authMailSender',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					member_authMail : member_authMail,
					member_name : member_name
				}),// data
				success : function(authNum) {
					if (authNum != 0) {
						ranAuthNum = authNum;
						alert("메일전송이 완료되었습니다.");
						$('#member_authMail').attr('readonly','readonly'); 
					} else {
						alert("입력하신 메일주소를 확인하세요")
					}// mailsend fail else
				}// success
			});// ajax
		}// confirm if
		else {
			alert("메일 전송을 취소합니다.")
		}
	});// member_mail click event

	$('#authSubmit').click(function() {
		var authNum = $('#authNum').val();
		if (member_authMail == '') {
			alert("메일주소를 입력하세요");
			return;
		} else if (authNum == '') {
			alert("인증번호를 입력하세요")
			return;
		} else {
			if (ranAuthNum != authNum) {
				alert("인증번호가 일치하지 않습니다.")
				$('#member_authMail').val('');
				$('#authNum').val('');
				$('#member_authMail').removeAttr('readonly','readonly'); 
				return;

			} else if (ranAuthNum == authNum) {
				alert("인증에 성공하였습니다.")
				$('#authCheck').val("success");
				$('#member_mail').val($('#member_authMail').val());
				$('#member_mail').attr('readonly', 'readonly');
				$("#mailAuthModal").modal('hide');
				$('#member_pass').removeAttr('readonly', 'readonly')
				$('#member_pass_check').removeAttr('readonly', 'readonly')
				$('#member_name').removeAttr('readonly', 'readonly')
				$('#member_birth').removeAttr('readonly', 'readonly')
				$('#joinBtn').show();

				// 인증번호 일치시 컨트롤러에 인증성공여부를 전달하려고 구상하였지만
				// 인증성공여부가 어떤 로직을 동반해야 하거나, 어떤 처리를 동반해야하거나,
				// 혹은 DB에 그 결과가 반영되야하는 것이 아니므로
				// 직접 프론트에서 객체(DOM) 조작을 통해 처리 하겠음
			}// inner esle
		}// outer else
	});// authNum click event

	$('#authCancel').click(function() {
		ranAuthNum = 0;

		$('#member_authMail').val('');
		$('#authNum').val('');
		$('#member_authMail').removeAttr('readonly','readonly'); 
		$('#authCheck').val("fail");
		$("#mailAuthModal").modal('hide');
		$('#idDuplicationCheck').html('');
	});// authCancel click event
});// ready
