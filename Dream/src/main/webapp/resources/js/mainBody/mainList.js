$(function(){
	$.ajax({
		url:'/dream/mainList',
		type: 'post',
		success : function(resultList){
			var mainList = "";
			var i=0;
			$(resultList).each(function(){
				var percentage = this.infoDto.project_percentage;
				if(this.infoDto.project_percentage > 100){
					percentage = 100;
				}
				mainList += "<div class='col-sm-4 col-lg-4 col-md-4'>"+
								"<div class='thumbnail'>"+
									"<input type='hidden' value='"+this.project_no+"'>"+
									"<a href='/dream/projectInfoView?project_no="+this.project_no+"'><img src='resources"+this.project_thumbnail+"' style='height: 350px'></a>"+
									"<div class='progress'>"+
										"<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: "+percentage+"%'>"+this.infoDto.project_percentage+"%</div>"+
									"</div>"+
									"<div class='caption'>"+
										"<!-- <h4 class='pull-right'>$24.99</h4> -->"+
										"<h4>"+
											"<a href='/dream/projectInfoView?project_no="+this.project_no+"'>"+this.project_title+"</a>"+
										"</h4>"+
										"<p>"+this.project_summary+
										"</p>"+
									"</div>"+
									"<div>"+  
										"</p>"+
										 "<div class='col-md-4'><b>"+this.infoDto.project_percentage+"%</b><br/><small>달성도</small></div>"+
							             "<div class='col-md-4'><b>"+this.project_goal_amount+"원</b><br/><small>목표금액</small></div>"+
							             "<div class='col-md-4'><b>"+this.project_end_date+"</b><br/><small>마감일</small></div>"+
							             "</p>"+
							             "<p>"+
							             "<div class='col-md-4'><b>"+this.infoDto.project_d_day+"일</b><br/><small>잔여기간</small></div>"+
							             "<div class='col-md-4'><b>"+this.supporting_count+"</b><br/><small>후원수</small></div>"+
							             "<div class='col-md-4'><b>"+this.project_viewcnt+"</b><br/><small>조회수</small></div>"+
							             "</p>"+
									"</div>"+
									"<div class='ratings'>"+
										"<p class='pull-right'>15 reviews</p>"+
										"<p>"+
											"<span class='glyphicon glyphicon-star'></span>"+
											"<span class='glyphicon glyphicon-star'></span>"+									 
											"<span class='glyphicon glyphicon-star'></span>"+										
											"<span class='glyphicon glyphicon-star'></span>"+			
											"<span class='glyphicon glyphicon-star'></span>"+
										"</p>"+
									"</div>"+
								"</div>"+
							"</div>";
				$('#mainResultView').html(mainList);
			});// each
//			$('#mainResultView').html(mainList);
		}// success
	});// ajax
});// ready