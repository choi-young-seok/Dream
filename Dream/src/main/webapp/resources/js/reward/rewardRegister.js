$(function(){
	$("#rewardInfoRegister").click(function(){
		
		//array in json for multiple-row insert to rewards
		var rewardsList = [];
		var listSize = $( "#reward_count").val();
		   for(var nRow = 1; nRow <= listSize; nRow++) {
			   
			   var reward_title = $("#reward_title"+nRow).val();
			   var reward_items = $("#reward_items"+nRow).val();
			   var reward_delivery_date = $("#reward_delivery_date"+nRow).val();
			   var reward_limited_count = $("#reward_limited_count"+nRow).val();
			   var reward_amount = $("#reward_amount"+nRow).val();
			   var reward_no  = $("#reward_no"+nRow).val();
			   var project_no = $("#project_no").val();
			   
			   	if(reward_title==""){
			   		alert("리워드 타이틀을 입력하세요");
			   		$("#reward_title"+nRow).focus();
			   		return;
			   	}
			   	
			   	if(reward_items ==""){
			   		alert("리워드 품목을 입력하세요");
			   		$("#reward_items"+nRow).focus();
			   		return;
			   	}
			   	if( reward_limited_count==""){
			   		alert("리워드 한정수량을 입력하세요");
			   		$("#reward_limited_count"+nRow).focus();
			   		return;
			   	}
			   	if(reward_amount ==""){
			   		alert("리워드 금액을 입력하세요");
			   		$("#reward_amount"+nRow).focus();
			   		return;
			   	}
			   	if(reward_delivery_date ==""){
			   		alert("리워드 베송예정일을 입력하세요");
			   		$("#reward_delivery_date"+nRow).focus();
			   		return;
			   	}
				   
			   rewardsList.push({
				   reward_title : reward_title,
				   reward_items : reward_items,
				   reward_delivery_date : reward_delivery_date,
				   reward_limited_count : reward_limited_count,
				   reward_amount : reward_amount,
				   reward_no : reward_no,
				   project_no : project_no,
				   member_no : $('#session_no').val()
			   });
		   }
		
		//배열전송을 위한 ajax 설정 변경
//		alert(JSON.stringify(rewardsList))
		$.ajaxSettings.traditional = true;
		
	   $.ajax({
			type : 'post',
			url : '/dream/projectRewardRegister',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},// headers
			dataType : 'text',
			data : JSON.stringify(
					{'rewardsList' : rewardsList}
				), // data
			//traditional: true,
			success : function(result) {
				if(result == "fail"){
					alert("입력값을 다시 확인해 주세요")
				}else{
//					alert("프로젝트 번호 : " +result)
					location.href="/dream/projectStoryView?project_no="+result;
				}
			}// success
		});// ajax
	
	})//rewardInfoRegister click event
	
});//ready