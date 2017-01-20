$(function(){
	
	//사용자 문의사항 등록 이벤트
	$('#qnaRegister').click(function(){
		var qna_title = $('#qna_title').val();
		var qna_content = $('#qna_content').val();
		var member_name = $('#member_name').val();
		var member_mail = $('#member_mail').val();
		
		if(qna_title ==''){
			alert('제목은 필수 입력사항입니다.')
			$('#qna_title').focus();
			return;
		}else if(qna_content == ''){
			alert('내용은 필수 입력사항입니다.')
			$('#qna_content').focus();
			return;
		}
		
		$.ajax({
			url : '/dream/qnaRegister',
			type : 'post',
			headers : { 
				"Content-Type" : "application : json",
				"X-HTTP-Method-Override" : "POST"
			},//headers
			dataType : 'text',
			data : JSON.stringify({
				qna_title : qna_title,
				qna_content : qna_content,
				member_name : member_name,
				member_mail : member_mail
			}),// data
			success : function(result) {
				alert(result)
			}// success
		});// ajax
		
//		$.ajax({
//			url :'/dream/qnaRegister',
//			tpye : 'post',
//			headers : { 
//				"Content-Type" : "application : json",
//				"X-HTTP-Method-Override" : "POST"
//			},//headers
//			data : JSON.stringify({
//				qna_title : qna_title,
//				qna_content : qna_content,
//				member_name : member_name,
//				member_mail : member_mail
//			}),//data
//			dataType : 'text',
//			success : function(result){
//				alert("???"+result)
//			}//success
//		});//
		
	});//qnaRegister click event
	
});//ready