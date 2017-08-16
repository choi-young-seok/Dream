/*$(function(){
	$("#re_Array").click(function(){
		
		for(var i =1 ; i<=reward_count ; i++){ //rewardBox의 갯수만큼 for문을 돌면서
			var reward_title = $("#reward_title"+i).val();
//			var reward_title = $("#reward_title"+i).val();
//			var reward_title = $("#reward_title"+i).val();
//			var reward_title = $("#reward_title"+i).val();
//			var reward_title = $("#reward_title"+i).val();
			alert(reward_title);
		}
		
		

		var reward_json ={
				reward1 : vlaue,
				reward2 : vlaue,
				reward3 : vlaue,
				reward4 : vlaue,
				reward5 : vlaue
		};
	});//re_Array click event
});//ready*/


$(function(){
	$("#rewardInfoRegister").click(function(){
		alert("리워드 입력")
		alert("프로젝트 번호:"+$("#project_no").val())
		
		//array in json for multiple-row insert to rewards
		var rewardsList = [];
		var listSize = $( "#reward_count").val();
		alert("리워드 개수"+listSize)
		   for(var nRow = 1; nRow <= listSize; nRow++) {
			   rewardsList.push({
				   reward_title : $("#reward_title"+nRow).val(),
				   reward_items : $("#reward_items"+nRow).val(),
				   reward_delivery_date : $("#reward_delivery_date"+nRow).val(),
				   reward_limited_count : $("#reward_limited_count"+nRow).val(),
				   reward_amount : $("#reward_amount"+nRow).val(),
				   reward_no : $("#reward_no"+nRow).val(),
				   project_no : $("#project_no").val(),
				   member_no : $('#session_no').val()
			   });
		   }
		
		//배열전송을 위한 ajax 설정 변경
		alert(JSON.stringify(rewardsList))
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
					alert("프로젝트 번호 : " +result)
					location.href="/dream/projectStoryView?project_no="+result;
				}
			}// success
		});// ajax
	
	})//rewardInfoRegister click event
	
});//ready