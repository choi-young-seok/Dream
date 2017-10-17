$(function() {
	var member_no = $("#session_no").val();
	get_memberAddress_list(member_no);

	$("#address  * form").mouseover(function() {
		$(this).css("background-color", "ghostwhite");
	});
	$("#address > * .boxSpace").mouseout(function() {
		$(this).css("background-color", "white");
	});

})
