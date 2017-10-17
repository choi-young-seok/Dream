<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script id="support_point_info" type="text/x-handlebars-template">
	{{#each .}}
 		<div class="boxSpace">
			<div class="row">
					<form class="form-horizontal" role="form">
						<table class="table">
							<tbody>
								<tr>
									<td rowspan="5"><a
										href='/dream/projectInfoView?project_no={{project_no}}'> <img
											height="155"
											src="resources{{projectPointDTO.project_thumbnail}}"><br>
									</a> <b>{{projectPointDTO.project_title}}</b></td>
								</tr>
								<tr>
									<td>리워드 타이틀 :
										{{supportDeliveryDTO.supportRewardDTO.reward_title}}</td>
									<td>결제 수단 : {{pay_method}}</td>
								</tr>
		
								<tr>
									<td>리워드 아이템 :
										{{supportDeliveryDTO.supportRewardDTO.reward_items}}</td>
									<td>결제가격 : {{support_amount}}</td>
								</tr>
		
								<tr>
									<td>배송 예정일 :
										{{supportDeliveryDTO.supportRewardDTO.reward_delivery_date}}</td>
									<td>결제 일자 : {{support_date}}</td>
								</tr>
		
								<tr>
									<input class="pull-right" type="button" value="상세보기"
										param="{{support_no}}" id="reward_support_detail_info">
								</tr>
							</tbody>
						</table>
					</form>
			</div>
		</div>
	{{/each}}
</script>


