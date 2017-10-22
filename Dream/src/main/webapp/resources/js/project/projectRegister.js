$(function(){
	//------------------------------------------------------------- 이벤트 기본 설정
	// 프로젝트 기본 정보 등록 radio button 이벤트 : 프로젝트 종료 기간 선택
	$('#radio5').click(function(){
		$('#dateArea').html('<input type="text" class="form-control" id="project_end_date">');
	});//project_end_date_input click event
	
	$('#radio6').click(function(){
		$('#dateArea').html('<input type="date" id="project_end_date">');
	});//project_end_date_input click event
	
	//프로젝트 스토리 정보 등록 radio button 이벤트 : 영상업로드 방법 선택 
	$('#video_upload').click(function(){
		alert("upload")
	});//video_upload click event
	
	$('#youtube').click(function(){
		alert("Youtube URL을 입력하세요")
		$('#imageZone').hide();
		$('#youtube_address').html('<input type="text" name="project_video">');
	});//youtube_address click event
	//------------------------------------------------------------- 이벤트 기본 설정
	
	
	//프로젝트 기본 정보 등록 요청
	$('#basicInfoRegister').click(function(){
		var project_thumbnail = $('#project_thumbnail').val();
		var project_title = $('#project_title').val();
		var project_summary = $('#project_summary').val();
		var project_category = $('#project_category option:selected').val();
		
		var project_goal_amount = $('#project_goal_amount').val();
		var member_mail = $('#session_mail').val();
		var member_no = $('#session_no').val();
		
		if(project_thumbnail == ""){
			alert("프로젝트 썸네일 사진을 등록하세요")
			$("project_thumbnail").focus();
			return;
		}
		
		if(project_title == ""){
			alert("프로젝트 타이틀을 입력하세요")
			$("#project_title").focus();
			return;
		}
		
		if(project_summary ==""){
			alert("프로젝트 소개문구를 입력하세요")
			$("#project_summary").focus();
			return;
		}
		if(project_category=="----"){
			alert("프로젝트 카테고리를 선택하세요")
			$("#project_category").focus();
			return;
		}
		if(project_goal_amount==""){
			alert("프로젝트 목표 금액을 입력하세요")
			$("#project_goal_amount").focus();
			return;
		}else{ //숫자 유효성 검사부
			
		}
		
		var project_end_date = $('#project_end_date').val();
		if(project_end_date==""){
			alert("프로젝트 종료 기간을 입력하세요")
			$("#project_end_date").focus();
			return;
		}
		
/*		alert("--- 프로젝트 기본 정보 ---" +
				"\n썸네일  : "+project_thumbnail+
				"\n타이틀  : " +project_title+
				"\n소개문구 : " +project_summary+
				"\n카테고리 : " +project_category+
				"\n종료일자 : " +project_end_date+
				"\n목표금액 : " +project_goal_amount);
		*/
		$.ajax({ 
			url : '/dream/basicInfoRegister',
			type : 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				project_thumbnail : project_thumbnail,
				project_title : project_title,
				project_summary :project_summary,
				project_category : project_category,
				project_end_date : project_end_date,
				project_goal_amount : project_goal_amount,
				member_no : member_no
			}),//data
			success : function(result){
				if(result == "fail"){
					alert("입력 정보를 다시 확인하세요")
				}else{
//					alert("프로젝트 번호 : " +result)
					location.href="/dream/projectRewardView?project_no="+result;					
					return; 
				}
			}//success
		});//ajax
	});//basicInfoRegister click event
	
	//프로젝트 등록자 프로필 정보 입력 요청
	$('#profileInfoRegister').click(function(){
		var project_no = $('#project_no').val();
		var member_no = $("#session_no").val();
		var member_profile = $('#register_profile').val();
		var register_name = $('#register_name').val();
		var register_intro = $('#register_intro').val();

		
		if(member_profile==""){
			alert("프로필 사진을 등록하세요")
			return;
		}

		if(register_intro==""){
			alert("소개문구를 입력하세요")
			$('#register_intro').focus();
			return;
		}

		if($("#member_address_request").attr("state") =="register"){
			var address_member_no = 0;

			var addressInfo = get_address_value();
			while(addressInfo == false){
				return;
			}
			
			var address_member_phone = get_phone_value();
			while(address_member_phone == false){
				return;
			}
		}else{
			
			var edit_mode_status = $("#address_edit_mode").attr("state")
			if(edit_mode_status =="false"){
				alert("주소지 수정을 완료하세요")
				return;
			}
			
			var address_member_no = $("#address_edit_mode").attr("param");
			
			var addressInfo = get_address_print_value(address_member_no);
			while(addressInfo == false){
				return;
			}
			
			var address_member_phone = get_phone_print_value(address_member_no);
			while(address_member_phone == false){
				return;
			}
		}
		
/*		alert("--- 프로젝트 프로필 정보 ---" +
				"\n프로젝트 번호 : " +project_no+
				"\n등록자 번호 : " +member_no+
				"\n등록자 프로필 사진  : "+member_profile+
				"\n등록자 이름 : " +register_name+
				"\n등록자 소개 : " +register_intro+
				"\n주소 등록자 : " +addressInfo.address_member_name+
				"\n주소 별칭 : " +addressInfo.address_alias+
				"\n우편번호 : " +addressInfo.member_address_zip_code+
				"\n주소 : " +addressInfo.member_address+
				"\n상세주소 : " +addressInfo.member_detail_address+
				"\n등록자 연락처 : "+address_member_phone);*/
		
		$.ajax({
			url : '/dream/projectProfileRegister',
			type: 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				project_no : project_no,
				member_no : member_no,
				address_member_no : address_member_no,
				member_profile : member_profile,
				register_name : register_name,
				register_intro : register_intro,
				memberAddressVO : {
					member_no : member_no,
					address_member_name : addressInfo.address_member_name,
					address_member_phone : address_member_phone,
					address_alias : addressInfo.address_alias,
					member_address_zip_code : addressInfo.member_address_zip_code,
					member_address : addressInfo.member_address,
					member_detail_address : addressInfo.member_detail_address, 
				}
			}),//data
			success : function(result){
				if(result == "success"){
//					alert("성공")
					location.href="/dream/projectAccountView?project_no="+project_no;
				}else{
					alert("입력정보를 다시 확인하세요")
				}
			},//success
			error : function(reqeust, status, error){
				alert("reqeust : "+reqeust.status+"\nerror : "+error )
			}
		});//ajax
		
	});//basicInfoRegister click event
	
	//프로젝트 계좌 정보 등록 요청
	$('#accountInfoRegister').click(function(){
		var project_no = $('#project_no').val();
		var access_terms_agree = $("#access_terms_agree").is(":checked");
		var register_address = $('#register_address').val();
		var project_account_bank = $('#account_bank_list').val();
		var project_account = $('#project_account').val();
		
		
		if(!access_terms_agree){
			access_terms_agree = 'F';
			alert("이용약관에 동의해주세요");
			return;
		}else{
			access_terms_agree = 'T';
		}
		if(register_address == ""){
			alert("주소를 입력하세요");
			$('#register_address').focus();
			return;
			
		}
		if(account_bank_list == "----"){
			alert("은행을 선택하세요");
			return;
			
		}
		if(project_account == ""){
			alert("계좌번호를 입력하세요");
			$('#project_account').focus();
			return;
			
		}
		$.ajax({
			url : '/dream/projectAccountRegister',
			type: 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				project_no : project_no,
				access_terms_agree : access_terms_agree,
				register_address : register_address,
				project_account_bank : project_account_bank,
				project_account : project_account
			}),//data
			success : function(result){
				if(result == "success"){
					location.href="/dream/projectPreView?project_no="+project_no;
				}else{
					alert("실패")
				}
			}//success
		});//ajax

	});//basicInfoRegister click event
	
	//프로젝트 미리보기 -> 최종등록 요청
	$('#project_register').click(function(){
		
		var project_no = $('#project_no').val();
		
		$.ajax({
			url :'/dream/projectRegister',
			type : 'post',
			data : {
				project_no : project_no
			},//data
			success : function(result){
				if(result == 'success'){
					location.href = '/dream';
				}
			}
		});//ajax
	});// project_register click eventp4

});// ready
