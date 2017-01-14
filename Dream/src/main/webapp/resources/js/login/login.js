$(function() {
	$('#login').click(function() {
		var login_mail = $('#login_mail').val();
		var login_pass = $('#login_pass').val();

		alert(login_mail + " / " + login_pass)
		if (login_mail == '') {
			alert("이메일을 입력하세요");
			return;
		} else if (login_pass == '') {
			alert("비밀번호를 입력하세요");
			return;
		} else {
			$.ajax({
				url : '/dream/login',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					login_mail : login_mail,
					login_pass : login_pass
				}),// data
				success : function(result) {
					// ajax를 이용한 login 처리시 결과 화면에 세션값을 찍기위해
					// 화면 깜박임(reload)를 추가
					location.reload();
					$('#loginModal').modal('hide');
				}// success
			});// ajax
		}// else
	});// memberLogin click event

	$('#logout').click(function() {
		$.ajax({
			url : '/dream/logout',
			type : 'post',
			success : function(result) {
				location.reload();
				alert("로그아웃이 완료되었습니다.");
			}// success
		});// ajax
	});// logout click event
});// ready

