//주소지 입력
function insert_memberAddress(member_no, addressInfo, address_member_phone, request) {
	 $.ajax({
         url : '/dream/insert_memberAddress',
         type : 'post',
         headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "POST"
         },// headers
         dataType : 'text',
         data : JSON.stringify({
               "member_no" : member_no,
               "address_member_name" : addressInfo.address_member_name,
               "address_alias" : addressInfo.address_alias,
               "member_address_zip_code" : addressInfo.member_address_zip_code,
               "member_address" : addressInfo.member_address,
               "member_detail_address" : addressInfo.member_detail_address,
               "address_member_phone" : address_member_phone
         }), // data
         error : function(request, status, error){
               alert("reqeust.status :" + request.status + "\nerror : " +error )
         },//error
         success : function(result){
         	if(result == "success"){
         		alert("입력되었습니다.")          
         		if(request == "mypage_address"){
         			location.href = "/dream/mypage_address";
         		}
         		location.href="/dream/"+request+"?member_no="+member_no
         	}
         }//success
  });//insert ajax
}

//주소지 수정
function update_memberAddress(member_no, address_member_no, addressInfo, address_member_phone, request) {
	$.ajax({
		url : '/dream/update_memberAddress',
		type : 'put',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PUT"
		},// headers
		dataType : 'text',
		data : JSON.stringify({
			member_no : member_no,
			address_member_no : address_member_no,
			address_member_name : addressInfo.address_member_name,
			address_alias : addressInfo.address_alias,
			member_address_zip_code : addressInfo.member_address_zip_code,
			member_address : addressInfo.member_address,
			member_detail_address : addressInfo.member_detail_address,
			address_member_phone : address_member_phone 
		}),
		error : function(request, status, error){
			alert("reqeust.status :" + request.status + "\nerror : " +error )
		},//error
		success : function(result){
			alert("수정되었습니다.")			
			if(request == "get_laterMemberAddress" || request == "get_memberAddress"){
				get_memberAddress(member_no, "get_memberAddress", address_member_no)
				return;
			}
			get_memberAddress_list(member_no);
		}//success
	});//update ajax
}

//주소지 삭제
function delete_memberAddress(address_member_no, member_no) {
	$.ajax({
		url : '/dream/delete_memberAddress/' +address_member_no,
		type : 'delete',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "DELETE"
		},// headers
		dataType : 'text',
		error : function(request, status, error){
			alert("reqeust.status :" + request.status + "\nerror : " +error )
		},//error
		success : function(result){
			alert("삭제되었습니다.")					
			get_memberAddress_list(member_no);
		}//success
	});//delete ajax
}

function get_memberAddress(member_no, request, address_member_no) {
	//request : get_laterMemberAddress : 최근 배송지
	//reqeust : get_memberAddress : 선택 배송지
	var url = '';
	if(request == "get_laterMemberAddress"){
		url = '/dream/'+request+'/'+member_no
	}else if(request =="get_memberAddress"){
		url = '/dream/'+request+'/'+address_member_no		
	}
	$.getJSON(url, function(result){
		var post_num = result.member_address_zip_code+'';
		var member_phone = result.address_member_phone+'';
		
		var data=[];
			data.push({
				address_member_no : result.address_member_no,
				address_member_name : result.address_member_name,
				address_alias : result.address_alias,
				post_num1 : post_num.substring(0,3),
				post_num2 : post_num.substring(3,6),
				member_address : result.member_address,
				member_detail_address : result.member_detail_address,
				member_phone1 : member_phone.substring(0,3),
				member_phone2 : member_phone.substring(4,8),
				member_phone3 : member_phone.substring(9,13),
				request : request,
				delivery_address : this.delivery_address
			}) //data
		var source = $("#template").html();
		var template = Handlebars.compile(source);
		$("#address_list").html(template(data))        
	});//getJSON
}

//회원 주소지 목록
function get_memberAddress_list(member_no) {
	$.getJSON('/dream/get_memberAddress_list/'+member_no, function(result){
		var data=[];
		$(result).each(function(){
			post_num = this.member_address_zip_code+'';
			member_phone = this.address_member_phone+'';
			
			data.push({
				address_member_no : this.address_member_no,
				address_member_name : this.address_member_name,
				address_alias : this.address_alias,
				post_num1 : post_num.substring(0,3),
				post_num2 : post_num.substring(3,6),
				member_address : this.member_address,
				member_detail_address : this.member_detail_address,
				member_phone1 : member_phone.substring(0,3),
				member_phone2 : member_phone.substring(4,8),
				member_phone3 : member_phone.substring(9,13),
				delivery_address : this.delivery_address
			}) //data
				
		})//each
		var source = $("#template").html();
		var template = Handlebars.compile(source);
		$("#address_list").html(template(data))
		
		var select_btn_check = $("#request").attr("select_btn_check");
	     if(select_btn_check =="select_btn_print"){
	    	 var source = $("#select_btn").html();
	    	 var template = Handlebars.compile(source);
	    	 
	    	 for(var address_count = 0; address_count < data.length; address_count++){
	    		 var address_member_no = JSON.parse(data[address_count].address_member_no);
	    		 $("#select_btn_area"+address_member_no).html(template({address_member_no : address_member_no}))
	    	 }
	     }
	});//getJSON
}

