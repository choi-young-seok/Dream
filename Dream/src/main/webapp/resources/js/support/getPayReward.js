//$(function(){
//	var reward_no = $("#reward_no").val();
//	if(reward_no == 0){
//		return;
//	}else{
//
//		$.getJSON('/dream/get_pay_reward/'+reward_no, function(result){
//			var get_pay_reward = "";
//			$(result).each(function(){
//
//				get_pay_reward += 
//					'<div class="boxSpace" style="position : fixed;">'+
//                    '상품 번호 : '+this.rewardVO.reward_no+'<br>'+
//                    '후원 금액 : '+this.rewardVO.reward_amount+"<br>"+
//                    '결제 품목 : '+this.rewardVO.reward_title + this.rewardVO.reward_items+"<br>"+
//                    '배송 예정일 :'+this.rewardVO.reward_delivery_date+
//					'<input type="button" id="pay" class="btn btn-primary btn-sm pull-right" value="결제하기">'+
//					'</div>';
//			});//each
//
//				
//			$("#select_reward").html(get_pay_reward);
////			$("#address_frame").html(address_frame);
//		});//getJSON
//	}//else end
//	
//});//ready
//
//function get_pay_reward(){
//	 $.ajax({
//			url : '/dream/get_pay_reward?reward_no='+reward_no,
//			type : 'get',
//			data : {
//				support_amount : support_amount
//				//reward_no : reward_no
//			},// data
//			success : function(result) { 
//				//result객체는 controller에서 return한 Map데이터
//				//controller에서 지정한 Map데이터의 key값으로 해당 데이터의 value 출력가능
//				//result(Map데이터).reward_no(Map데이터의 key)
//				//alert("1.reward_no : "+result.reward_no)
//				//alert("2.support_no : "+result.support_amount)
//				//Map데이터 내에 저장된 VO or List형태의 데이터 출력
//				//result(Map데이터).rewardVO(Map데이터의 key)데이터를 받아와
//				//jquery의 each함수를 이용하여 각각의 데이터(java변수명 으로 mapping되어있음) 출력
//				
////				$(result).each(function(){
////					alert("리워드 번호 : "+this.rewardVO.reward_no
////							+"\n리워드 타이틀 : "+this.rewardVO.reward_title
////							+"\n리워드 아이템 : "+this.rewardVO.reward_items
////							+"\n리워드 배송일 : "+this.rewardVO.reward_delivery_date);
////				});//each
//
//				//if(result.reward_no == "noReward"){
//					//loaction.href = "/dream/"						
//				//}
//				
////				var reward_detail = "";
////				$(result).each(function(){
////					reward_detail = "<div>"+
////									"<input type='text' value='"+this.rewardVO.reward_title+"'>"
////				});//each
////				$("#reward_result_View").html(reward_detial);
//			}//success
//		});// ajax
//	
//}