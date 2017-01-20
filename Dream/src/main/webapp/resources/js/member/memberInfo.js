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

	});// click event

});// ready
