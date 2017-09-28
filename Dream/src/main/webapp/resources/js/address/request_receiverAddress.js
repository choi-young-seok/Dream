$(function(){
	var support_no =$("#support_no").val();
	get_receiverAddress(support_no)
	var cnt = 0;
		
	$("#payback_info_update_btn").click(function(){
		if(cnt == 0){
			alert("수정모드112")
			$("#payback_bank").removeAttr("readonly")
			$("#payback_account").removeAttr("readonly")
			cnt ++;
			return;
		}
		var payback_bank = $("#payback_bank").val();
		var payback_account = $("#payback_account").val();
		
		
		update_paybackInfo(support_no,payback_bank,payback_account  )
	});//payback_info_update_btn click event
	
	$("#address_list").on("click","#address_edit_mode", function(){
		$(this).hide();
		$(this).attr("state","false")
		var address_alias = $("#old_address_alias").text()
		
		var source = $("#search_btn").html();
  		var template = Handlebars.compile(source);
  		$("#seach_btn_area").html(template())

  		source = $("#alias_input").html();
  		template = Handlebars.compile(source);
  		$("#alias_input_area").html(template({address_alias :address_alias}))    

  		source = $("#edit_btn").html();
  		template = Handlebars.compile(source);
  		$("#edit_btn_area").html(template())    
  		
  		$("#address_edit_area > * input:not(.searchArea)").removeAttr("readonly");
  		$("#findAddress").show();
  		
  		$("#address_area").attr("id","address_area");
  		$("#address_member_name").attr("id","address_member_name");
  		$("#address_alias").attr("id","address_alias");
  		
  		$("#post_num1").attr("id","post_num1");
  		$("#post_num2").attr("id","post_num2");
  		$("#choiceAddress").attr("id","choiceAddress");
  		$("#numSector_phone").attr("id","numSector_phone");
	});
	
	//수정 요청
	$("#address_list").on("click","#address_info_edit", function(){
		edit_mode_status = true;
		
		var address_member_no = $(this).attr("param");
		var request = $("#address_edit_mode").attr("request");
		
		var addressInfo = get_address_value();
		   while(addressInfo == false){
		         return;
		   }
	   
	   var address_member_phone = get_phone_value();
	   while(address_member_phone == false){
	         return;
	   }
	   
	   alert("--- 프로젝트 프로필 정보 ---" +
	               "\n후원 번호 : " +support_no+
	               "\n주소 등록자 : " +addressInfo.address_member_name+
	               "\n주소 별칭 : " +addressInfo.address_alias+
	               "\n우편번호 : " +addressInfo.member_address_zip_code+
	               "\n주소 : " +addressInfo.member_address+
	               "\n상세주소 : " +addressInfo.member_detail_address+
	               "\n등록자 연락처 : "+address_member_phone
	   );
	   update_receiverAddress(support_no, addressInfo, address_member_phone)
	   
	}); //address_info_edit ajax request
	
	 //주소 찾기 버튼 클릭 이벤트
	$("#address_list").on("click","#findAddress", function(){
		$("#addressModal").modal();
		$("#search_address").val(""); 
		$("#search_address").focus();
	});// findAddress click event
	
	$("#address_list").on("click","#address_info_cancel", function(){
		var address_member_no = $(this).attr("param");
		var request = $("#address_edit_mode").attr("request");
		
		
		if(confirm("취소하시겠습니까? 입력하신 정보는 저장되지 않습니다.")){
			get_receiverAddress(support_no);
		}else{
			return;
		}
	});

});//

function update_paybackInfo(support_no,payback_bank,payback_account){
	alert("환불정보 수정\n"
			+"\payback_bank : " +payback_bank	
		+"\npayback_account : " +payback_account	
	)
	
	$.ajax({
			url : '/dream/update_paybackInfo',
			type : 'put',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				support_no : support_no,
				payback_bank : payback_bank,
				payback_account : payback_account 
			}),
			error : function(request, status, error){
				alert("reqeust.status :" + request.status + "\nerror : " +error )
			},//error
			success : function(result){
				alert("수정되었습니다.")
				$("#payback_bank").val(payback_bank)
				$("#payback_bank").attr("readonly","readonly")
				$("#payback_account").val(payback_account)
				$("#payback_account").attr("readonly","readonly")
			}//success
		});//update ajax
}
      
function get_receiverAddress(support_no) {
	$.getJSON('/dream/get_receiverAddress/'+support_no, function(result){
		var post_num = result.receiver_zip_code+'';
		var member_phone = result.receiver_phone+'';
		
		var data=[];
			data.push({
				address_member_name : result.receiver_name,
				address_alias : result.receiver_address_alias,
				post_num1 : post_num.substring(0,3),
				post_num2 : post_num.substring(3,6),
				member_address : result.receiver_address,
				member_detail_address : result.receiver_detail_address,
				member_phone1 : member_phone.substring(0,3),
				member_phone2 : member_phone.substring(4,8),
				member_phone3 : member_phone.substring(9,13),
			}) //data
		var source = $("#template").html();
		var template = Handlebars.compile(source);
		$("#address_list").html(template(data))        
	});//getJSON
}

function update_receiverAddress(support_no, addressInfo, address_member_phone){
	alert("수정요청")
	$.ajax({
			url : '/dream/update_receiverAddress',
			type : 'put',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},// headers
			dataType : 'text',
			data : JSON.stringify({
				support_no : support_no,
				receiver_name : addressInfo.address_member_name,
				receiver_address_alias : addressInfo.address_alias,
				receiver_zip_code : addressInfo.member_address_zip_code,
				receiver_address : addressInfo.member_address,
				receiver_detail_address : addressInfo.member_detail_address,
				receiver_phone : address_member_phone 
			}),
			error : function(request, status, error){
				alert("reqeust.status :" + request.status + "\nerror : " +error )
			},//error
			success : function(result){
				alert("수정되었습니다.")
				get_receiverAddress(support_no);
			}//success
		});//update ajax
}