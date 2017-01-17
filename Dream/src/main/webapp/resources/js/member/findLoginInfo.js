$(function(){
	$("#findPassBtn").hide();
	$('#member_pass').attr('readonly','readonly');
	$('#member_pass').attr('type','text');
	$('#member_pass').attr('value','아이디를 먼처확인하시게');
	$('#member_pass_check').attr('readonly','readonly');
	
	$('#member_pass').keyup(function(){
		pass_Check();
	});//member_pass keyup event
	
	$('#member_pass_check').keyup(function(){
		pass_Check();
	});//member_pass keyup event
	
	$("#member_mail").click(function(){
		$('#mailAuthModal').modal({backdrop : "static"});
	});//member_mail
		
	$("#member_authMail").keyup(function(){
		var member_mail = $('#member_authMail').val();
		$.ajax({
			url : '/dream/checkMemberMail',
			type : 'post',
			data : {
				member_mail : member_mail
			},// data
			success : function(checkMemberMail) {
				if(checkMemberMail == 'noResult'){
					$('#checkMemberMail').html('');
					$('#checkMemberMail').html("<span class='danger'>아이디를 입력하세요.</span>");
					$("#mailAuthNumBtn").hide();
				}
				else if (checkMemberMail == 'success') {
					$('#checkMemberMail').html("<span class='success'>아이디가 일치합니다.</span>");
					$('#member_pass').removeAttr('readonly','readonly');
					$('#member_pass').attr('type','password');
					$('#member_pass').val('');
					$('#member_pass_check').removeAttr('readonly','readonly');
					$("#mailAuthNumBtn").show();
					$("#findPassBtn").show();
				} else {
					$('#checkMemberMail').html("<span class='fail'>아이디가 존재하지 않습니다.</span>");
					$("#mailAuthNumBtn").hide();
				}
			}// success
		});//ajax
	});//member_mail keyup event
	
	$("#findPassBtn").click(function(){
		var member_mail = $("#member_mail").val();
		var member_name = $("#member_name").val();
		var member_pass = $("#member_pass").val();
		
			$.ajax({
				url : '/dream/findPass',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					member_mail : member_mail,
					member_name : member_name,
					member_pass : member_pass
				}),// data
				success : function(findPass) {
					if(findPass=='success'){
						alert("비밀번호 변경 완료");
						location.href = "/dream";
						$('#loginModal').modal();
						alert("11")
					}
				}// success
		});//ajax
	});//findPassBtn click event
	
});//ready