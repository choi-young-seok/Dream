$(function(){
	

//	for(var nRow = 1 ; nRow <= 2 ; nRow++){
//		arrTestList.push({name:'name'+nRow});
//		arrTestList.push({phone:'phone'+nRow});
////		arrTestList.push({"arrTestVO["+nRow+"].name" : arrTestVO[0].name});
////		arrTestList.push({"arrTestVO["+nRow+"].phone":arrTestVO[0].name});
//	};//end for
	
	
	var arrTestList = [];
	arrTestList.push(
			{'arrTestVO.name': "name1",'arrTestVO.phone':"phone1"}
			);
	
	arrTestList.push(
			{'arrTestVO[1].name': "name2",'arrTestVO[1].phone':"phone2"}
			);
	
	arrTestList.push(
			{'arrTestList.name': "name3",'arrTestList.phone':"phone2"}
	);
	
	arrTestList.push(
			{'arrTestList[2].name': "name4",'arrTestList[2].phone':"phone2"}
	);

	arrTestList.push(
			{'name': "name5",'phone':"phone5"}
	);
	
	arrTestList.push(
			{'name': "name6",'phone':"phone6"}
	);
	
	arrTestList.push(
			{'name': "name7",'phone':"phone7"}
	);
	
	arrTestList.push(
			{'name': "name8",'phone':"phone8"}
	);

	arrTestList.push(
			{'name[0]': "name6",'phone[0]':"phone2"}
	);
	
	arrTestList.push(
			{'name[0].name': "name7",'phone[0].phone':"phone2"}
	);
	
//	arrTestList.push({'arrTestList[2].name': "name3"},{'arrTestList[2].phone':"phone3"});
//	arrTestList.push({'arrTestList[3].name': "name4"},{'arrTestList[3].phone':"phone4"});
	alert("??")
//	arrTestList.push({'arrTestList[0].phone':'111'});
//	arrTestList.push({'arrTestList[1].name':'name2'});
//	arrTestList.push({'arrTestList[1].phone':'444'});

//		arrTestList.push({'name':'name1'});
//		arrTestList.push({'phone':'phone1'});

	alert("arrTestList.values : " +JSON.stringify(arrTestList))
	
	jQuery.ajaxSettings.traditional = true;
	$.ajaxSettings.traditional = true;
	
	 $.ajax({
			type : 'post',
			url : '/dream/arrTestRegister',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify(
//					{'name':"name1"},
//					{'phone':333}
					{'arrTestList' : arrTestList}
				), // data
			//traditional: true,
			success : function(result) {
				
			}// success
		});// ajax
});//ready