<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="support_point_info_noReward" type="text/x-handlebars-template">
			{{#each .}}
			<div class="row boxSpace">

				<table class="table">
					<tbody>
						<tr>
							<td rowspan="5">
								<a href='/dream/projectInfoView?project_no={{project_no}}'>
								<div>
									<img height="155" src="resources{{projectPointDTO.project_thumbnail}}"> 
								<br>
									{{projectPointDTO.project_title}}
								</div>
								</a>
							</td>
						</tr>
						<tr>
							<th>									
								리워드 없는 후원
							</th>
							<td>
								결제가격 : {{support_amount}}
							</td>
						</tr>
						
						<tr>
							<td>
								결제 수단 : {{pay_method}}
							</td>
							<td>
								결제 일자 : {{support_date}}
							</td>
						</tr>

						<tr>
							<input class="pull-right" type="button" value="상세보기" param="{{support_no}}" id="noreward_support_detail_info">
						</tr>
					</tbody>
				</table>
				<div>
				</div>
			</div>
			{{/each}}
		</script>