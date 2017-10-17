<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col col-md-1"></div>

	<div class="col col-md-10">
		<div class="printSpace">
			<legend><h1 align="center">결제완료 화면</h1></legend>
			<input type="hidden" value="${support_no }" id="support_no">
		</div>
	</div>
	<div class="col col-md-1"></div>
</div>

<div class="row">
	<div class="col col-md-1"></div>

	<div class="col col-md-10">
		<div id="support_project_info" class="printSpace">
<!-- 			    <legend align="center">프로젝트 정보123</legend> -->
			    <h3>프로젝트 정보</h3>
			    
				<table class="table">
					<tbody>
						<tr>
							<td rowspan="5" align="center">
								<a href='/dream/projectInfoView?project_no=${supportDetail.projectPointDTO.project_no}'>
									<img height="155" src="resources${supportDetail.projectPointDTO.project_thumbnail}"> <br>
								</a>
									<B>${supportDetail.projectPointDTO.project_title }</B>
							</td>
						</tr>
						<tr>
							<th >									
								목표금액 : ${supportDetail.projectPointDTO.project_goal_amount }원<br>
							</th>
							<td>
								조회수 : ${supportDetail.projectPointDTO.project_view_count }<br>
							</td>
						</tr>
						
						<tr>
							<td>
								현재 후원액 : ${supportDetail.projectPointDTO.now_amount }원<br>
							</td>
							<td>
								후원수 : ${supportDetail.projectPointDTO.supporting_count }
							</td>
						</tr>
						
						<tr>
							<td>
								잔여기간 : ${supportDetail.projectPointDTO.projectOperDTO.project_d_day}일
							</td>
							<td>
								마감일 : ${supportDetail.projectPointDTO.project_end_date }<br>
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								<div class='progress'>
									<c:choose>
										<c:when test="${supportDetail.projectPointDTO.projectOperDTO.project_percentage > 100}">
											<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: 100%'></div>
										</c:when>
										<c:otherwise>
											<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: ${supportDetail.projectPointDTO.projectOperDTO.project_percentage}%'></div>
										</c:otherwise>
									</c:choose>
								</div>								
							</td>
						</tr>						
					</tbody>
				</table>
			</div><!-- /.row --> 
		</div><!-- printSpace -->
	<div class="col col-md-1"></div>
</div><!-- col col-md-10-->	

<div class="row">
	<div class="col col-md-1"></div>
	<div class="col col-md-10">
		<div id="reward_List" class="printSpace">
			<div class="row">
				<form class="form-horizontal" role="form">
				    <!-- Form Name -->
				    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
				    <legend align="center">결제 정보</legend>
				    <!-- Text input-->
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">결제자 : </label>
			      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.member_name}</label>
				    </div>
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">결제 가격 : </label>
			      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.support_amount}</label>
				    </div>
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">결제 은행 : </label>
			      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.pay_bank}</label>
				    </div>
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">결제 수단 : </label>
			      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.pay_method}</label>
				    </div>
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">결제 일자 : </label>
			      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.support_date}</label>
				    </div>
				</form>
				
			</div><!-- /.row --> 
		</div><!-- printSpace -->
	</div>	
	<div class="col col-md-1"></div>
</div>

<div class="row">
	<div class="col col-md-1"></div>
	<div class="col col-md-10">
		<div id="reward_List" class="printSpace">
			<div class="row">
				<form class="form-horizontal" role="form">
				    <!-- Form Name -->
				    <div class="col-sm-10">
				    	<legend align="center">환불정보</legend>
				    </div>
				    <div class="pull-right">
				    	<input type="button" class="btn btn-success" value="수정" id="payback_info_update_btn">
				    </div>
				    <!-- Text input-->
				    <div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">환불 은행 : </label>
			      		<div class="col-sm-5">
			      			<input type="text" id="payback_bank" class="form-control" title="textInput" readonly="readonly" value="${supportDetail.payInfoDTO.payback_bank }">
			      		</div>
				    </div>
			    	<div class="form-group">
			      		<label class="col-sm-4 control-label" for="textinput">환불 계좌 : </label>
			      		<div class="col-sm-5">
			      			<input type="text" id="payback_account" class="form-control" title="textInput" readonly="readonly" value="${supportDetail.payInfoDTO.payback_account }">
			      		</div>
				    </div>
				</form>
				
			</div><!-- /.row --> 
		</div><!-- printSpace -->
	</div><!-- col col-md-5 -->	
	<div class="col col-md-1"></div>
</div>