$(function() {
	//cardNumSector태그의 자식태그들에 keyup이벤트가 발생할때마다 요소를 검사
	$("#inputTest  *:text").keyup(function(event){
		var inputVal = $(this).val();
		var getTitle = event.target.title;
		if(getTitle == "textInput"){
			return;
		}
		$(this).val(inputVal.replace(/[^0-9]$/gi,''));
		// g옵션 : 문자열 내 모든 패턴 중
		// i옵션 : 대소문자를 구별하지않고
		// [^0-9] : 0~9를 제외한
		// replace(/[^0-9]/gi,'') : 0~9를 제외한 모든 문자열 패턴을 ''(공백)으로 대체 처리
		if(getTitle != ""){
			if($(this).val().length == event.target.title){
				$(this).parent().next().children("div > :text").focus();
			} 
		}
	})//cardNumSector children keyup event
		
	$("#payBtn").click(function(){
		
		//후원 기본 정보
		var project_no = $("#project_no").val();
		var reward_no = $("#reward_no").val();
		var member_no = $("#session_no").val();
		var support_amount = $("#support_amount").val();
		var member_name = $("#session_name").val();
		
		//결제 정보
		var pay_method = $("#pay_method > * > input:checked").val();
		
		//카드결제시
		if(pay_method == "card"){
			var sector_children = $("#pay_card_area  *:text").length;
			var pay_bank = $("#pay_card_area select option:selected").val();
			var pay_account_number = "";
			//카드번호
			for(var i=0; i<sector_children; i++){
				if($("#numSector_card  :text:eq("+i+")").val() ==""){
					alert("카드번호를 입력하세요")
					$("#numSector_card  :text:eq("+i+")").focus();
					return;
				}else if($("#numSector_card  :text:eq("+i+")").val().length != 4){
					alert("카드번호를 다시 입력하세요")
					$("#numSector_card  :text:eq("+i+")").focus();
					return;
				}else{
					pay_account_number += $("#numSector_card  :text:eq("+i+")").val();
					if(i < sector_children-1){
						pay_account_number += "-";
					}
					
				}
			}
	
		//무통장 입금시
		}else{
			var pay_user_name = $("#pay_cash_area :text:eq(0)").val();
			var pay_account_number = $("#pay_cash_area :text:eq(1)").val();
			var length = $("#pay_cash_area  *:text").length;
			alert("----- 무통장 입금 정보 -----"+
					"\npay_user_name : "+pay_user_name+
					"\npay_account_number : "+pay_account_number);

			if(pay_user_name.length == 0){
				alert("입금자명을 입력하세요");
				$("#pay_cash_area :text:eq(0)").focus();
				return;
			}else if(pay_account_number.length == 0){
				alert("계좌번호를 입력하세요")
				$("#pay_cash_area :text:eq(1)").focus();
				return;
			}
			
			member_name = pay_user_name;

		}//결제정보입력

		///환불 정보
		var pay_back_bank = $("#numSector_payback_account select option:selected").val();
		var pay_back_account = $("#numSector_payback_account :text:eq(0)").val();
		
		if(pay_back_account ==""){
			alert("환불 계좌번호를 입력하세요")
			$("#numSector_payback_account :text:eq(0)").focus();
			return;
		}
		
		//리워드 선택 후원 진행시 배송 정보
		if(reward_no != "0"){
			//받는사람 이름
			var receiver_name = $("#receiver_name").val();
			if(receiver_name == ""){
				alert("배송정보를 입력하세요")
				$("#receiver_name").focus();
				return;
			}//recevier_name if end
			
			//주소
			var post_num = "";
			for(var i=0; i<2; i++){
				if($("#address_area :text:eq("+i+")").val() ==""){
					alert("주소정보를 입력하세요")
					$("#findAddress").click();
					return;
				}
				post_num += $("#address_area :text:eq("+i+")").val();
			}//post_num if end
			
			var receiver_address = $("#address_area :text:eq(2)").val();

			var detail_address = $("#address_area :text:eq(3)").val();
			if(detail_address ==""){
				alert("상세주소를 입력하세요")
				$("#address_area :text:eq(3)").focus();
				return;
			}//detail_address if end
			
			//연락처
			var receiver_phone ="";
			var phone_area_length = $("#numSector_phone :text").length;
			
			for(var i=0; i<phone_area_length; i++){
				receiver_phone += $("#numSector_phone :text:eq("+i+")").val();
				if($("#numSector_phone :text:eq("+i+")").val() ==""){
					alert("연락처를 입력하세요")
					$("#numSector_phone :text:eq("+i+")").focus();
					return;
				}else{
					if(i==0 && $("#numSector_phone :text:eq("+i+")").val().length != 3){
						alert("연락처 앞자리 3자리를 입력하세요")
						$("#numSector_phone :text:eq("+i+")").focus();
						return;
					}else if(i != 0 && $("#numSector_phone :text:eq("+i+")").val().length != 4){
						alert("연락처 자리수를 확인하세요")
						$("#numSector_phone :text:eq("+i+")").focus();
						return;
					}
				}
				if(i < phone_area_length-1){
					receiver_phone += "-";
				}
			}//receiver phone_num if end
			
			alert("----- 리워드 후원 결제 정보 -----"+
				"\nmember_no :  "+member_no+
				"\nproject_no : " +project_no+
				"\nreward_no : "+reward_no+
				"\nmember_name : " + member_name+
				"\nsupport_amount : "+support_amount+
				"\n----- 결제 정보 -----"+
				"\npay_method : " + pay_method+
				"\npay_account_number : "+pay_account_number+
				"\npay_bank : "+pay_bank+
				"\n----- 환불정보 -----" +
				"\npay_back_bank : " +pay_back_bank+
				"\npay_back_account : "+pay_back_account+
				"\n----- 배송정보 -----" +
				"\nreceiver_name : "+ receiver_name +
				"\npost_num : "+ post_num +
				"\nreceiver_address : " +receiver_address+
				"\ndetail_address : "+ detail_address +
				"\receiver_phone : "+ receiver_phone);
			
			$.ajax({
				url : '/dream/supportRegister',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					member_no : member_no,
					project_no : project_no ,
					total_reward_no  : reward_no ,
					member_name : member_name,
					support_amount : support_amount,
					pay_method : pay_method,
					pay_account_number : pay_account_number,
					addressVO :
						{
							receiver_name : receiver_name,
							zip_code : post_num,
							receiver_address : receiver_address,
							detail_address : detail_address,
							receiver_phone : receiver_phone
						}
				}),// data
				success : function(result){
					var itemsVO = JSON.parse(result);
					var support_no = itemsVO.support_no;
					var shipping_address_no = itemsVO.shipping_address_no;
					alert(support_no+", "+shipping_address_no)
					
					location.href="/dream/supportCompleteView?support_no="+support_no+"&&shipping_address_no="+shipping_address_no;
					//후원이 완료되었습니다
//					btn : 메인화면가기 location.href="/mainList"
//			  	    btn : 후원목록가기(마이페이지) loaction.href="mypage/supportproject"
				}//success
			});//ajax
			
		}else{
			var support_amount = $("#support_amount_noReward").val();

			alert("----- 리워드 없는 후원 결제 정보 -----"+
					"\nproject_no : " +project_no+
					"\nreward_no : "+reward_no+
					"\nmember_name : " + member_name+
					"\nmember_no :  "+member_no+
					"\nsupport_amount : "+support_amount+
					"\n----- 결제 정보 -----"+
					"\npay_method : " + pay_method+
					"\npay_account_number : "+pay_account_number+
					"\npay_bank : "+pay_bank+
					"\n----- 환불정보 -----" +
					"\npay_back_bank : " +pay_back_bank+
					"\npay_back_account : "+pay_back_account);
			
			$.ajax({
				url : '/dream/supportRegister',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					member_no : member_no,
					member_name : member_name,
					project_no : project_no ,
					total_reward_no  : reward_no ,
					support_amount : support_amount,
					pay_method : pay_method,
					pay_account_number : pay_account_number,
				}),// data
				success : function(result){
					var itemsVO = JSON.parse(result);
					var support_no = itemsVO.support_no;
					
					location.href="/dream/supportCompleteView?support_no="+support_no+"&&shipping_address_no=noReward";
				}//success
			});//ajax
		}
		//reward 후원 구분 if end
		//데이터 전송
	});//patBtn click event
	
});// ready

