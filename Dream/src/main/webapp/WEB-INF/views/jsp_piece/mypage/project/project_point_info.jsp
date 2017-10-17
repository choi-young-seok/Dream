<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="project_point_info" type="text/x-handlebars-template">
{{#each .}}
 	<div class="boxSpace">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<form class="form-horizontal" role="form">
					<table class="table">
						<tbody>
							<tr>
								<td rowspan="5">
									<a href='/dream/projectInfoView?project_no={{project_no}}'>
										<img height="155" src="resources{{project_thumbnail}}"><br>
									</a>
										<b>{{project_title }}</b>
								</td>
							</tr>
							<tr>
								<td>목표금액 : {{project_goal_amount }}원<br></td>
								<td>조회수 : {{project_view_count }}<br></td>
							</tr>
	
							<tr>
								<td>현재 후원액 : {{now_amount }}원<br></td>
								<td>후원수 : {{supporting_count }}</td>
							</tr>
	
							<tr>
								<td>잔여기간 : {{projectOperDTO.project_d_day}}일</td>
								<td>마감일 : {{project_end_date }}<br>
								</td>
							</tr>
	
							<tr>
								<td colspan="2">
									<div class='progress'>
										<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0'
											aria-valuemax='100' align='center' style='width: {{projectOperDTO.project_percentage}}%'></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
{{/each}}

</script>

<!-- 								<th>목표금액 : <th><td align ="center">{{project_goal_amount }}원<br></td> -->