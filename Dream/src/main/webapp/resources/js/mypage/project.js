$(function(){
	
	$("#project_Info").click(function(){
		var member_no = $("#session_no").val();
		location.href="/dream/myProject?member_no="+member_no;
	});//project_Info click event

	function get_state(event){
		
//		if(event.target.nodeName = 'A'){
//			var request = event.target.title;			
//		}
//		document.getElementBy
//		var request = $("projects >li:[class='active']".target);
//		var aa = request.title;
		var state = $("#project_state > option:selected").val();
		alert("request : "+request +"\nstate : " +state)
	}
	
	$("#project_condition > #projects >li , #project_state > li").click(function(event){
//		$(this).
//		get_state(event);
//		alert(event.target.title)
		$("#projects > li").removeAttr("class");
		$(this).attr("class","active");
		var request = event.target.title;
		var member_no = $("#session_no").val();
		
		if(request == "")
		
		var dropdown_condition ="";
		dropdown_condition += 
//			'<div class="dropdown pull-right">'+
				'<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">'+
				'Tutorials <span class="caret"></span>'+
				'</button>'+
				'<ul class="dropdown-menu" id="project_state">'+
						'<li title="success"><a href="#">달성</a></li>'+
						'<li title="fail"><a href="#">미달성</a></li>'+
				'</ul>';
//			'</div>';
		
	$("#condition_result").html(dropdown_condition);
	
		$.getJSON('/dream/myProjectList/'+request+'/'+member_no, function(result){
//			
//			var dropdown_condition ="";
//			dropdown_condition += 
////				'<div class="dropdown pull-right">'+
//				'<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">'+
//				'Tutorials <span class="caret"></span>'+
//				'</button>'+
//				'<ul class="dropdown-menu" id="project_state">'+
//				'<li title="success"><a href="#">달성</a></li>'+
//				'<li title="fail"><a href="#">미달성</a></li>'+
//				'</ul>';
////				'</div>';
//			
//			$("#condition_result").html(dropdown_condition);
//			$("#resultView").html(dropdown_condition);
//			$("#resultView2").text("1234");
	
					});//getJSON
	});//click event;
	//
//	alert(result)
//	//			var get_pay_reward = "";
////	$(result).each(function(){
////
////		get_pay_reward += 
////			'<div class="boxSpace" style="position : fixed;">'+
////            '상품 번호 : '+this.rewardVO.reward_no+'<br>'+
////            '후원 금액 : '+this.rewardVO.reward_amount+"<br>"+
////            '결제 품목 : '+this.rewardVO.reward_title + this.rewardVO.reward_items+"<br>"+
////            '배송 예정일 :'+this.rewardVO.reward_delivery_date+
////			'<input type="button" id="pay" class="btn btn-primary btn-sm pull-right" value="결제하기">'+
////			'</div>';
////	});//each
//
//		
////	$("#select_reward").html(get_pay_reward);
////	$("#address_frame").html(address_frame);
		
	
//	$("#projects > li").click(function(event){
//		var request = event.target.title;

//		member_no = $("#session_no").val();
//		
//		var state = $("#project_state > option:selected").val();
//		alert("reqeust : "+request+"\nmember_no : " +member_no+"\nstate : " +state);
//		
//		
//		
//	});//project List request click event
	
//	$("#processing_project_list").click(function(){
//		var member_no = $('#session_no').val();
//		location.href= "/dream/myProjectList/"+member_no;
//	});//processing_project_list click event
});//ready 