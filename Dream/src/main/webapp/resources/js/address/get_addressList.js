$(function() {
	var member_no = $("#session_no").val();
	get_memberAddress_list(member_no);

	$("#address  * form").mouseover(function() {
		$(this).css("background-color", "ghostwhite");
	});
	$("#address > * .boxSpace").mouseout(function() {
		$(this).css("background-color", "white");
	});
	$("#address > a").click(function(event) {
//		alert("방지")
//		var address_member_no = $(this).
//		event.preventDefault();
	})

})
