$(function(){
	$('#joinBtn').click(function(){
		alert("join.js import확인");
	});//joinBtn click event
	
	$('#cancelBtn').click(function(){
		var check = confirm("입력된 내용은 사라집니다. 취소하시겠습니까?");
		if(check){
			location.href = "/dream"
		}
	});//회원가입 취소 버튼 클릭 이벤트
	
});//ready