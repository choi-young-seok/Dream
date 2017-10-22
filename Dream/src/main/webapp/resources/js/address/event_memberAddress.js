$(function() {
	
     var member_no = $("#session_no").val();
     var select_btn_check = $("#request").attr("select_btn_check");
     var edit_mode_status = true;
     
  	$("#address_info_insert").click(function(){
        location.href ="/dream/mypage_address_insert";
  	});//address_info_insert click event;
  	
  	$("#choice_address_insert").click(function(){
  		location.href ="/dream/choice_address_insert?member_no="+member_no
  	});//address_info_insert click event;

    //주소 수정화면 출력
  	$("#address_list").on("click","#address_edit_mode", function(){
  		if(edit_mode_status){
  			
  		}else{
  			alert("다른 주소정보를 수정하려면 이전 정보를 완료하거나, \n취소 후 수정하세요")
  			return;
  		}
  		var address_member_no = $(this).attr("param");
  		var address_alias = $("#old_address_alias"+address_member_no).text()
  		var data = {address_member_no : address_member_no, address_alias : address_alias}
  		$(this).hide();
  		edit_mode_status = false
  		
  		//해당 주소가 프로젝트 배송지 정보일경우 경고문구 출력+삭제 불가 
  		var delivery_address = $(this).attr("delivery_address")
  		if(delivery_address == "delivery_address"){
  			if(confirm("해당 주소는 프로젝트 배송주소로 설정되어있습니다. " +
  					"\n수정하실 경우 프로젝트에 등록된 배송주소가 수정됩니다." +
  					"\n정말 수정하시겠습니까?")){
  			}else{
  				return;
  			}
  		}
  		
  		var request = $("#request").attr("param");
//  		alert("event_memberAddress.js request : "+request)
  		if(delivery_address != "delivery_address"){
	  		if(request =="address_list"){
	  	  		var source = $("#delete_btn").html();
	  	  		var template = Handlebars.compile(source);
	  	  		$("#delete_btn_area"+address_member_no).html(template(data))  
	  		}
  		}
  		$(this).attr("state","false")
//		edit_mode_status = false; 

			
  		var source = $("#search_btn").html();
  		var template = Handlebars.compile(source);
  		$("#seach_btn_area"+address_member_no).html(template())

  		source = $("#alias_input").html();
  		template = Handlebars.compile(source);
  		$("#alias_input_area"+address_member_no).html(template(data))    

  		source = $("#edit_btn").html();
  		template = Handlebars.compile(source);
  		$("#edit_btn_area"+address_member_no).html(template(data))    
  		
  		$("#address_edit_area"+address_member_no+" > * input:not(.searchArea)").removeAttr("readonly");
  		$("#findAddress").show();
  		
  		$("#address_area"+address_member_no).attr("id","address_area");
  		$("#address_member_name"+address_member_no).attr("id","address_member_name");
  		$("#address_alias"+address_member_no).attr("id","address_alias");
  		
  		$("#post_num1"+address_member_no).attr("id","post_num1");
  		$("#post_num2"+address_member_no).attr("id","post_num2");
  		$("#choiceAddress"+address_member_no).attr("id","choiceAddress");
  		$("#numSector_phone"+address_member_no).attr("id","numSector_phone");
  		
  	});// address_edit_mode click event
  	
  //주소 찾기 버튼 클릭 이벤트
	$("#address_list").on("click","#findAddress", function(){
		$("#addressModal").modal();
		$("#search_address").val(""); 
		$("#search_address").focus();
	});// findAddress click event
      
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
	               "\n등록자 번호 : " +member_no+
	               "\n주소 번호 : " +address_member_no+
	               "\n주소 등록자 : " +addressInfo.address_member_name+
	               "\n주소 별칭 : " +addressInfo.address_alias+
	               "\n우편번호 : " +addressInfo.member_address_zip_code+
	               "\n주소 : " +addressInfo.member_address+
	               "\n상세주소 : " +addressInfo.member_detail_address+
	               "\n등록자 연락처 : "+address_member_phone
	   );
	   
	   update_memberAddress(member_no, address_member_no, addressInfo, address_member_phone, request);
	   
	}); //address_info_edit ajax request
	
	$("#address_list").on("click","#address_info_cancel", function(){
		var address_member_no = $(this).attr("param");
		var request = $("#address_edit_mode").attr("request");
		
		
		if(confirm("취소하시겠습니까? 입력하신 정보는 저장되지 않습니다.")){
			edit_mode_status = true;
			if(request ==""){
				get_memberAddress_list(member_no);		
				return;
			}else{
				get_memberAddress(member_no, request, address_member_no)
			}
		}else{
			return;
		}
	});
	
	$("#address_list").on("click","#address_info_delete", function(){
		if(confirm("삭제하신 정보는 복구되지 않습니다. \n해당 주소지 정보를 삭제 하시겠습니까?")){
			var address_member_no = $(this).attr("param");
			delete_memberAddress(address_member_no, member_no)
		}else{
			return;
		}
	});
      
});



