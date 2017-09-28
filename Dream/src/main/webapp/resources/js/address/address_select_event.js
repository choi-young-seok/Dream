$(function() {
	$("#address_list").on("click","#address_info_select", function(){
		var member_no = $("#session_no").val();
		var address_member_no = $(this).attr("param")
//		alert("선택 번호: " + address_member_no)
		opener.call_test(member_no, address_member_no)
//		get_memberAddress(member_no, "get_memberAddress", address_member_no)
		window.close();
	});
});