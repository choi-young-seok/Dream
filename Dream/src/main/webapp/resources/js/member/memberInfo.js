$(function() {
	var member_mail = $('#session_mail').val();
	$('#memberInfoView').click(function() {
		location.href="/dream/memberInfoView?member_mail="+member_mail;
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

	});// click event

});// ready
