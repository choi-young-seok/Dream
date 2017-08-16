$(function() {
	$('#rewardOk').click(function() {
		if ($('#re_money').val() == "") {
			alert('서약금액을 입력하세요');
			$('#re_money').focus();
			return false;
		}  else if ($('#title').val() == "") {
			alert('리워드 타이틀을 입력하세요');
			$('#title').focus();
			return false;
		} else if ($('#item').val() == "") {
			alert('리워드 아이템을 입력하세요');
			$('#item').focus();
			return false;
		} else if ($('#duedate').val() == "") {
			alert('배송 예정일을 입력하세요');
			$('#duedate').focus();
			return false;
		} else if ($('#amount').val() == "") {
			alert('리워드 한정수량을 입력하세요');
			$('#amount').focus();
			return false;
		} 
		nextStep();
	});//click event
});
