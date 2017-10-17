function get_address_value(){
	var addressInfo =[];
	
	var address_member_name = $("#address_member_name").val();
	if(address_member_name == ""){
		alert("받으시는분 이름을 입력하세요")
		$("#address_member_name").focus();
		return false;
	}//address_member_name if end

	//주소지 별칭
	var address_alias =$("#address_alias").val();	
	if(address_alias ==""){
		alert("주소지 별칭을 입력하세요")
		$("#address_alias").focus();
		return false;
	}// address_alias if end
	
	//주소
	var member_address_zip_code = "";
	for(var i=2; i<4; i++){
		if($("#address_area :text:eq("+i+")").val() ==""){
			alert("주소지 정보를 입력하세요")
			$("#findAddress").click();
			return false;
		}
		member_address_zip_code += $("#address_area :text:eq("+i+")").val();
	}//member_address_zip_code if end
	
	var member_address = $("#address_area :text:eq(4)").val();
	
	var member_detail_address = $("#address_area :text:eq(5)").val();
	if(member_detail_address ==""){
		alert("상세 주소를 입력하세요")
		$("#address_area :text:eq(5)").focus();
		return false;
	}//member_detail_address if end

	var addressInfo = ({
	               address_member_name : address_member_name,
	               address_alias : address_alias,
	               member_address_zip_code : member_address_zip_code,
	               member_address : member_address,
	               member_detail_address : member_detail_address,
	})
	return addressInfo;
}

function get_address_print_value(address_member_no){
	var addressInfo =[];
	//주소지 회원 이름
	var address_member_name = $("#address_member_name"+address_member_no).val();
		
	if(address_member_name == ""){
		alert("받으시는분 이름을 입력하세요")
		$("#address_member_name"+address_member_no).focus();
		return false;
	}//address_member_name if end
	
	//주소지 별칭
	var address_alias =$("#old_address_alias"+address_member_no).text();	
	if(address_alias ==""){
		alert("주소지 별칭을 입력하세요")
		$("#address_alias"+address_member_no).focus();
		return false;
	}// address_alias if end
	
	//주소
	var member_address_zip_code = "";
	for(var i=1; i<3; i++){
		if($("#address_area"+address_member_no+" :text:eq("+i+")").val() ==""){
			alert("주소지 정보를 입력하세요")
			$("#findAddress").click();
			return false;
		}
		member_address_zip_code += $("#address_area"+address_member_no+" :text:eq("+i+")").val();
	}//member_address_zip_code if end
	
	var member_address = $("#address_area"+address_member_no+" :text:eq(3)").val();

	var member_detail_address = $("#address_area"+address_member_no+" :text:eq(4)").val();
	if(member_detail_address ==""){
		alert("상세 주소를 입력하세요")
		$("#address_area"+address_member_no+" :text:eq(5)").focus();
		return false;
	}//member_detail_address if end

	var addressInfo = ({
	               address_member_name : address_member_name,
	               address_alias : address_alias,
	               member_address_zip_code : member_address_zip_code,
	               member_address : member_address,
	               member_detail_address : member_detail_address,
	})
	return addressInfo;
}


//연락처 정보
function get_phone_value(){
    var address_member_phone ="";
    var phone_area_length = $("#numSector_phone :text").length;
    for(var i=0; i<phone_area_length; i++){
          address_member_phone += $("#numSector_phone :text:eq("+i+")").val();
          if($("#numSector_phone :text:eq("+i+")").val() ==""){
                alert("연락처를 입력하세요")
                $("#numSector_phone :text:eq("+i+")").focus();
                return false;
          }else{
                if(i==0 && $("#numSector_phone :text:eq("+i+")").val().length != 3){
                      alert("연락처 앞자리 3자리를 입력하세요")
                      $("#numSector_phone :text:eq("+i+")").focus();
                      return false;
                }else if(i != 0 && $("#numSector_phone :text:eq("+i+")").val().length != 4){
                      alert("연락처 자리수를 확인하세요")
                      $("#numSector_phone :text:eq("+i+")").focus();
                      return false;
                }
          }
          if(i < phone_area_length-1){
                address_member_phone += "-";
          }
    }//receiver phone_num if end
    return address_member_phone;
}


function get_phone_print_value(address_member_no){
	var address_member_phone ="";
	var phone_area_length = $("#numSector_phone"+address_member_no+" :text").length;
	for(var i=0; i<phone_area_length; i++){
		address_member_phone += $("#numSector_phone"+address_member_no+" :text:eq("+i+")").val();
		if($("#numSector_phone"+address_member_no+" :text:eq("+i+")").val() ==""){
			alert("연락처를 입력하세요")
			$("#numSector_phone"+address_member_no+" :text:eq("+i+")").focus();
			return false;
		}else{
			if(i==0 && $("#numSector_phone"+address_member_no+" :text:eq("+i+")").val().length != 3){
				alert("연락처 앞자리 3자리를 입력하세요")
				$("#numSector_phone"+address_member_no+" :text:eq("+i+")").focus();
				return false;
			}else if(i != 0 && $("#numSector_phone"+address_member_no+" :text:eq("+i+")").val().length != 4){
				alert("연락처 자리수를 확인하세요")
				$("#numSector_phone"+address_member_no+" :text:eq("+i+")").focus();
				return false;
			}
		}
		if(i < phone_area_length-1){
			address_member_phone += "-";
		}
	}//receiver phone_num if end
	return address_member_phone;
}


