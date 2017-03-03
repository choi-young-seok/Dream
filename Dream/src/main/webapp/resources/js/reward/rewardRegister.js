$(function(){
	$("#re_Array").click(function(){
		var count = $("#reward_count").val(); //총 생성된 rewardBox의 갯수
		alert("생성된 count : " +count);
		for(var i =0 ; i<count ; i++){ //rewardBox의 갯수만큼 for문을 돌면서
			var reward_title = $("#reward_title"+i).val();
			alert(reward_title);
		}
	});//re_Array click event
});//ready