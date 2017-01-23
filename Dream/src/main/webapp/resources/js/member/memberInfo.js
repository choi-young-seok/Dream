$(function() {
	var member_no = $('#session_no').val();
	
	$('#memberInfoView').click(function() {
		location.href="/dream/memberInfoView?member_no="+member_no;
//		$.ajax({
//			url : '/dream/memberInfoView',
//			type : 'post',
//			dataType : 'text',
//			data :{
//				member_mail : member_mail,
//			}, // data
//			success : function(result) {
//				location.href="/dream/memberInfoView";
//			}// success
//		});// ajax

	});// memberInfoView click event
	
	$('#memberInfoEdit').click(function(){
		
		var member_profile = $('#member_profile').val();
		
		$.ajax({
			url : '/dream/memberInfoEdit',
			type : 'post',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data :JSON.stringify({
				member_no : member_no,
				member_profile : member_profile
			}), // data
			success : function(result) {
				location.reload();
			}// success
		});// ajax
		
	});//memberInfoEdit click event
	
	var member_profile_value = $("#member_profile_value").val();

	if(member_profile_value =='' || member_profile_value == null){
		$('#profileArea').show();
		$('#proFileZone').hide();		
	}else{
		$('#profileArea').hide();
		$('#proFileZone').show();		
	}
	
	$('#profileEdit').click(function(){
		$('#profileArea').show();
		$('#proFileZone').hide();		
	});//profileEdit click event

});// ready
