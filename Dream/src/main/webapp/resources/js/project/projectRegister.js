$(function(){
	// 프로젝트 기본 정보 등록 radio button 이벤트 : 프로젝트 종료 기간 선택
	$('#project_end_date_input').click(function(){
		$('#dateArea').html('<input type="text" id="project_end_date">');
	});//project_end_date_input click event
	
	$('#project_end_date_select').click(function(){
		$('#dateArea').html('<input type="date" id="project_end_date">');
	});//project_end_date_input click event
	
	//프로젝트 스토리 정보 등록 radio button 이벤트 : 영상업로드 방법 선택 
	$('#video_upload').click(function(){
		alert("upload")
	});//video_upload click event
	
	$('#youtube').click(function(){
		alert("youtube")
		$('#imageZone').hide();
		$('#youtube_address').html('<input type="text" name="project_video">');
	});//youtube_address click event

	//프로젝트 기본 정보 등록 요청
	$('#basicInfoRegister').click(function(){
		var project_thumbnail = $('#project_thumbnail').val();
		var project_title = $('#project_title').val();
		var project_summary = $('#project_summary').val();
		var project_category = $('#project_category').val();
		var project_end_date = $('#project_end_date').val();
		var project_goal_amount = $('#project_goal_amount').val();
		var member_mail = $('#session_mail').val();
		var member_no = $('#session_no').val();
		alert(member_mail);
		alert(member_no);
		
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
				alert(result)
				if(result == "success"){
					location.href="/dream/projectRewardView";					
				}else{
					alert("입력 정보를 다시 확인하세요")
					return;
				}
			}//success
		});//ajax
	});//basicInfoRegister click event
	
		$('#rewardInfoRegister').click(function(){
			location.href="/dream/projectStoryView";
//		$.ajax({			
//			url: '/dream/projectStoryView',
//			type : 'post',
//			success : function(result){
//				$('#projectStoryView').html(result)
//			}//success
//		})//ajax
	});//basicInfoRegister click event

//		$('#savebutton').click(function(){
//			var project_content = $('#editor').val();
//			alert("프로젝트 소개 : "+project_content);
//			location.href="/dream/projectProfileView";
//		});//basicInfoRegister click event

		/*	$('#storyInfoRegister').click(function(){
		
		$.ajax({			
			url: '/dream/projectProfileView',
			type : 'get',
			success : function(result){
				$('#projectProfileView').html(result)
			}//success
		})
	});//basicInfoRegister click event
*/	
	
	
//	--------------------------------------------------------------------------------
	//프로젝트 기본 정보 등록 이벤트
//	$('#basicInfoRegister').click(function(){
//		location.href="/dream/projectRewardView";
//	});//basicInfoRegister click event
	
	$('#projectRewardRegister').click(function(){
		location.href="/dream/projectStoryView";
	});//basicInfoRegister click event
	
	$('#profileInfoRegister').click(function(){
		var project_no = $('#project_no').val();
		var register_profile = $('#register_profile').val();
		var register_name = $('#register_name').val();
		var register_intro = $('#register_intro').val();
		var register_sns = $('#register_sns').val();

		
		alert("프로젝트 번호 : "+project_no+"프로필사진 : "+register_profile+"이름 : "+register_name+"소개문구 : "+register_intro+"sns : "+register_sns)
	
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
				register_profile : register_profile,
				register_name : register_name,
				register_intro : register_intro,
				register_sns : register_sns
			}),//data
			success : function(result){
				if(result == "success"){
					alert("성공")
					location.href="/dream/projectAccountView";
				}else{
					alert("실패")
				}
			}//success
		});//ajax
		
	});//basicInfoRegister click event
	
	$('#accountInfoRegister').click(function(){
		var project_no = $('#project_no').val();
		var access_terms_agree = $("#access_terms_agree").is(":checked");
		var register_address = $('#register_address').val();
		var account_bank_list = $('#account_bank_list').val();
		var project_account = $('#project_account').val();
		
		
		if(!access_terms_agree){
			access_terms_agree = 'F';
			alert("이용약관에 동의해주세요");
			return;
		}else{
			access_terms_agree = 'T';
		}
		alert("요기")
			
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
				account_bank_list : account_bank_list,
				project_account : project_account
			}),//data
			success : function(result){
				if(result == "success"){
					alert("성공")
					location.href="/dream/projectInfoView?project_no="+project_no;
				}else{
					alert("실패")
				}
			}//success
		});//ajax
		
//		location.href="/dream";
	});//basicInfoRegister click event
	
	$('#project_register').click(function(){
		
		var project_no = $('#project_no').val();
		alert(project_no);
		
		$.ajax({
			url :'/dream/projectRegister',
			type : 'post',
			data : {
				project_no : project_no
			},//data
			success : function(result){
				alert(result);
				if(result == 'success'){
					location.href = '/dream';
				}
			}
		});//ajax
	});//project_register click eventp4
	
	
});//ready


//$('#rewardView').click();

//$.ajax({			
//	url: '/dream/projectRewardView',
//	type : 'post',
//	success : function(result){
//		$('#projectRewardView').html(result)
//	}//success
//})//ajax


//$.ajax({
//url : '/dream/projectBasicInfoView',
//type :'post',
//success : function(result){
//	$('#projectBasicInfoView').html(result)
//}//success
//});//ajax