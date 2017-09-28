$(function() {
	var member_no = $("#session_no").val()
      
      //주소 추가
      $("#member_address_insert").click(function(){
    	  var request = $(this).attr("param")
    	  alert("request : " + request)
//    	  request : address_Info_View
//    	  request : get_changeAdress_list
    	  
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
                        "\n주소 등록자 : " +addressInfo.address_member_name+
                        "\n주소 별칭 : " +addressInfo.address_alias+
                        "\n우편번호 : " +addressInfo.member_address_zip_code+
                        "\n주소 : " +addressInfo.member_address+
                        "\n상세주소 : " +addressInfo.member_detail_address+
                        "\n등록자 연락처 : "+address_member_phone
            );
            
            insert_memberAddress(member_no, addressInfo, address_member_phone, request);
      });//member_address_insert click event
});