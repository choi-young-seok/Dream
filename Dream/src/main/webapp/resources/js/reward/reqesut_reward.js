function get_rewardInfo(total_reward_no) {
	$.getJSON('/dream/get_rewardInfo/'+total_reward_no, function(result){
		
		var data=[];
		$(result).each(function(){
			data.push({
				project_no : this.project_no,
				total_reward_no : this.total_reward_no,
				reward_no : this.reward_no,
				reward_title : this.reward_title,
				reward_items : this.reward_items,
				reward_delivery_date : this.reward_delivery_date,
				reward_limited_count : this.reward_limited_count,
				reward_amount : this.reward_amount
			}) //data
		})//each
		
		var source = $("#reward_select").html();
		var template = Handlebars.compile(source);
		$("#reward_info_area").html(template(data))        
	});//getJSON
}

function get_rewardInfo_list(project_no) {
	$.getJSON('/dream/get_rewardInfo_list/'+project_no, function(result){
		var data=[];
		$(result).each(function(){
			data.push({
				project_no : this.project_no,
				total_reward_no : this.total_reward_no,
				reward_no : this.reward_no,
				reward_title : this.reward_title,
				reward_items : this.reward_items,
				reward_delivery_date : this.reward_delivery_date,
				reward_limited_count : this.reward_limited_count,
				reward_amount : this.reward_amount
			}) //data
		})//each
		var source = $("#reward_select").html();
		var template = Handlebars.compile(source);
		$("#reward_info_area").html(template(data))
	});//getJSON
}