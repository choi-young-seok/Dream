$(function(){
	//아아디 찾기 첫 화면 셋팅
//	$("#findMailBtn").hide(); 
	
	//비밀번호 변경 첫 화면 셋팅
	$("#findPassBtn").hide(); 
	$('#member_pass').attr('readonly','readonly');
	$('#member_pass').attr('type','text');
//	$('#member_authMail').attr('value','아이디를 먼처 입력하세요');
	$('#member_pass').attr('value','아이디를 먼저 입력하세요');
	$('#member_pass_check').attr('readonly','readonly');
//	---------------------------------------------------------------------------------------------------------아이디 찾기
	
	
	//아이디 찾기 버튼 클릭 이벤트 : 아이디+생년월일 일치 검사 및 아이디 찾기 로직
	$("#findMailBtn").click(function(){
		var member_name = $('#member_name').val();
		var member_birth = $('#member_birth').val();
		
		if(member_name == ''){
			$('#mail_check').html("<span class='fail'>아이디를 입력하세요</span>");	
			return;
		}else if(member_birth == ''){
			$('#mail_check').html("");	
			$('#birth_check').html("<span class='fail'>생년월일을 입력하세요</span>");
			return;
		}
		$('#birth_check').html("");
			//아이디+생년월일 일치 검사 
			$.ajax({
				url : '/dream/findMail',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},//headers
				dataTpye:'text',
				data: JSON.stringify({
					member_name : member_name,
					member_birth : member_birth
				}),//data
				success : function(checkMemberMail){
					alert("결과 데이터"+checkMemberMail);
					var mainList = "";
					var now = new Date();

					
					$(checkMemberMail).each(function(){
						mainList += "<br><span class='fail'>가입 아이디 목록</span>"+
									"<br>"+
									"<span class = 'success'>메일 : "+this.member_mail+"</span> <button id='findPassView'>비밀번호 찾기</button>"+
									"<br><span class = 'success'>가입일 : "+this.member_regdate+"/></span>"+
									"<br>";
					});//each
					$('#findMailInfo').html(mainList);
				}//success
			});//ajax			
	})//findMailBtn click event
	

//	---------------------------------------------------------------------------------------------------------비밀번호 변경
	//아이디 텍스트 버튼 클릭 이벤트 : 메일인증 모달창 출력
	$("#member_mail").click(function(){
		$('#mailAuthModal').modal({backdrop : "static"});
	});//member_mail
		
	//모달창 아이디 텍스트 버튼 키업 이벤트 : 아이디 존재유뮤 + 메일인증 처리 로직
	$("#member_authMail").keyup(function(){
		var member_mail = $('#member_authMail').val();
		
		//아이디 존재유무 검사
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
	
	//비밀번호 형식 검사
	$('#member_pass').keyup(function(){
		pass_Check();
	});//member_pass keyup event
	
	//비밀번호 일치성 검사
	$('#member_pass_check').keyup(function(){
		pass_Check();
	});//member_pass keyup event
	
	//변경된 비밀번호 처리 로직
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
					}
				}// success
		});//ajax
	});//findPassBtn click event
	
});//ready