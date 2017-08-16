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
		$("#pay_cash_area").hide();
		$("#radio5").attr("checked","checked");
		$("#radio6").removeAttr("checked")
		
//		var pay_card_area_length = $("#pay_card_area :text").length;
//		for(var i =0; i < pay_card_area_length; i++){
//			$("#pay_card_area :text:eq("+i+")").val("");
//		}
		
	}  
	
	function pay_method_cash(){
		$("#pay_cash_area").show();
		$("#pay_card_area").hide();
		$("#radio6").attr("checked","checked");
		$("#radio5").removeAttr("checked")
		
//		var pay_method_cash_length = $("#pay_cash_area :text").length;
//		for(var i =0; i < pay_method_cash_length; i++){
//			$("#pay_cash_area :text:eq("+i+")").val("");
//		}
	}	
	
	//우편번호 및 주소검색 결과창 readonly처리
	$("#addressTransferSector").children().each(function(){
		$("#addressTransferSector").children().attr("readonly","readonly");
	})
	
	
})