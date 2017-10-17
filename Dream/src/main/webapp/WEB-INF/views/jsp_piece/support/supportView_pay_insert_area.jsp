<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="boxSpace">
	<div class="row">
		<div class="col-md-12 col-md-offset-0">
			<form class="form-horizontal" role="form">
				<h3>${project.project_title }</h3>
				<table class="table">
					<tbody>
						<tr>
							<td rowspan="5"><a
								href='/dream/projectInfoView?project_no=${project.project_no}'>
									<img height="155" src="resources${project.project_thumbnail}">
									<br> <input type="hidden" id="project_no"
									value="${project.project_no }">
							</a></td>
						</tr>
						<tr>
							<th>목표금액 : ${project.project_goal_amount }원<br>
							</th>
							<td>조회수 : ${project.project_view_count }<br>
							</td>
						</tr>

						<tr>
							<td>현재 후원액 : ${project.now_amount }원<br>
							</td>
							<td>후원수 : ${project.supporting_count }</td>
						</tr>

						<tr>
							<td>잔여기간 : ${project.projectOperDTO.project_d_day}일</td>
							<td>마감일 : ${project.project_end_date }<br>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<div class='progress'>
									<c:choose>
										<c:when
											test="${project.projectOperDTO.project_percentage > 100}">
											<div class='progress-bar' role='progressbar'
												aria-valuenow='100' aria-valuemin='0' aria-valuemax='100'
												align='center' style='width: 100%'></div>
										</c:when>
										<c:otherwise>
											<div class='progress-bar' role='progressbar'
												aria-valuenow='100' aria-valuemin='0' aria-valuemax='100'
												align='center'
												style='width: ${project.projectOperDTO.project_percentage}%'></div>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</div>

<div class="boxSpace cardSector">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<form class="form-horizontal" role="form">

				<!-- Form Name -->
				<legend>결제 정보 입력</legend>
				<div class="funkyradio form-group" id="pay_method">
					<div class="funkyradio-info">
						<input type="radio" name="radio" id="radio5" value="card" /> <label
							for="radio5">카드 결제</label>
					</div>

					<div class="funkyradio-info" >
						<input type="radio" name="radio" id="radio6" value="account" /> <label
							for="radio6">무통장 입금</label>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group" id="pay_card_area">
					<label class="col-sm-3 control-label" for="textinput"
						style="margin-left: -7px">은행 :</label>
					<div class="col-sm-9 " align="center">
						<select class="form-control"
							style="margin-left: -33px; width: 88%">
							<option>신한</option>
							<option>농협</option>
							<option>하나</option>
							<option>조흥</option>
							<option>국민</option>
							<option>우리</option>
							<option>신협</option>
							<option>우체국</option>
							<option>새마을</option>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group" id="numSector_card">
					<label class="col-sm-3 control-label" for="textinput">카드번호
						:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" maxlength="4" title="4">
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" maxlength="4" title="4">
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" maxlength="4" title="4">
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" maxlength="4" title="4">
					</div>
				</div>

				<!-- Text input-->
				<div id="pay_cash_area">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="textinput">입금자
							: </label>
						<div class="col-sm-9">
							<input type="text" placeholder="입급자명을 입력하세요" class="form-control"
								title="textInput" style="width: 88%">
						</div> 
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label" for="textinput">계좌번호
							: </label>
						<div class="col-sm-9">
							<input type="text" placeholder="계좌번호를 입력하세요" class="form-control" style="width: 88%">
						</div>
					</div>
				</div>

			</form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>

<div id="numSector_payback_account" class="boxSpace">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<form class="form-horizontal" role="form">

				<!-- Form Name -->
				<legend>환불 정보 입력</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-sm-3 control-label" for="textinput">은행 :
					</label>
					<div class="col-sm-9">
						<select class="form-control" style="width: 88%">
							<option>----</option>
							<option>신한</option>
							<option>농협</option>
							<option>하나</option>
							<option>조흥</option>
							<option>국민</option>
							<option>우리</option>
							<option>신협</option>
							<option>우체국</option>
							<option>새마을</option>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-sm-3 control-label" for="textinput">계좌번호
						:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="member_account"
							placeholder="숫자만 입력하세요" style="width: 88%">
					</div>
				</div>
			</form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>