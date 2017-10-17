$(function(){
	var member_no = $("#session_no").val();
	get_memberAddress(member_no, "get_laterMemberAddress");
	
	$("#textArea  *:text").keyup(function(event){
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
	
    $("#change_memberAddress").click(function(){
    	window.open("/dream/get_changeAdress_list?member_no="+member_no, '주소지선택', "width=800, height=600, left=530, top=120, channelmode=no, location=no, resizable=no, scrollbars=yes" )
//    	window.open(url, 'islide', 'toolbar=no, menubar=no, resizeable=yes, status=no, width=800, height=600, scrollbars=no');
    })	
    
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
			var sector_children = $("#numSector_card  *:text").length;
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
/*			alert("----- 무통장 입금 정보 -----"+
					"\npay_user_name : "+pay_user_name+
					"\npay_account_number : "+pay_account_number);*/

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
			pay_bank = "무통장 입금";

		}//결제정보입력

		///환불 정보
		var payback_bank = $("#numSector_payback_account select option:selected").val();
		var payback_account = $("#numSector_payback_account :text:eq(0)").val();
		
		if(payback_bank == "----"){
			alert("환불받으실 은행을 선택하세요")
			$("#numSector_payback_account select").click();
			return;
		}
		
		if(payback_account ==""){
			alert("환불 계좌번호를 입력하세요")
			$("#numSector_payback_account :text:eq(0)").focus();
			return;
		}
		
		//리워드 선택 후원 진행시 배송 정보
		if($("#member_address_request").attr("state") =="register"){
			var address_member_no = 0;

			var addressInfo = get_address_value();
			while(addressInfo == false){
				return;
			}
			
			var address_member_phone = get_phone_value();
			while(address_member_phone == false){
				return;
			}
		}else{
			
			var edit_mode_status = $("#address_edit_mode").attr("state")
			if(edit_mode_status =="false"){
				alert("주소지 수정을 완료하세요")
				return;
			}
			
			var address_member_no = $("#address_edit_mode").attr("param");
			
			var addressInfo = get_address_print_value(address_member_no);
			while(addressInfo == false){
				return;
			}
			
			var address_member_phone = get_phone_print_value(address_member_no);
			while(address_member_phone == false){
				return;
			}
		}
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
				"\npay_back_bank : " +payback_bank+
				"\npay_back_account : "+payback_account+
				"\n----- 배송정보 -----" +
				"\n받는사람  : "+ addressInfo.address_member_name +
				"\n주소 별칭 : " +addressInfo.address_alias+
	            "\n우편번호 : " +addressInfo.member_address_zip_code+
	            "\n주소 : " +addressInfo.member_address+
	            "\n상세주소 : " +addressInfo.member_detail_address+
	            "\n등록자 연락처 : "+address_member_phone
			);
			
			$.ajax({
				url : '/dream/supportRegister_reward',
				type : 'post',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},// headers
				dataType : 'text',
				data : JSON.stringify({
					member_no : member_no,
					project_no : project_no ,
					member_name : member_name,
					support_amount : support_amount,
					pay_bank : pay_bank,
					pay_method : pay_method,
					pay_account_number : pay_account_number,
					payback_bank : payback_bank,
					payback_account : payback_account,
					support_category : 'o',
					deliveryDTO :
						{
							project_no : project_no ,
							total_reward_no  : reward_no ,
							receiver_name : addressInfo.address_member_name,
							receiver_address_alias : addressInfo.address_alias,
							receiver_zip_code : addressInfo.member_address_zip_code,
							receiver_address : addressInfo.member_address,
							receiver_detail_address : addressInfo.member_detail_address,
							receiver_phone : address_member_phone
						}
				}),// data
				success : function(result){
					location.href="/dream/supportDetailView_reward?member_no="+member_no+"&support_no="+result;
				}//success
			});//ajax
	});//patBtn click event
    
});