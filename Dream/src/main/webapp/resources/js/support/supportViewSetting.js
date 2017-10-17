$(function(){
	//결제방법 초기 radio버튼 카드결제 화면으로 설정
	$("#radio5").attr("checked","checked");
	pay_method_card();

	//결제 시 카드정보 입력 화면 출력 
	$("#radio5").click(function(){		
		pay_method_card();
	});//pay_method_card click event
	
	//결제 시 무통장입금 정보 입력 화면 출력
	$("#radio6").click(function(){
		pay_method_cash();
	});//pay_method_card click event
	
	function pay_method_card(){
		$("#pay_card_area").show();
		$("#numSector_card").show();
		$("#pay_cash_area").hide();
		$("#radio5").attr("checked","checked");
		$("#radio6").removeAttr("checked")
	}  
	
	function pay_method_cash(){
		$("#pay_cash_area").show();
		$("#pay_card_area").hide();
		$("#numSector_card").hide();
		$("#radio6").attr("checked","checked");
		$("#radio5").removeAttr("checked")
	}	
	
})