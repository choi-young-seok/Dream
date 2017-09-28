<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="boxSpace">
	<div align="center">
		<img src="resources${project.project_thumbnail}">
		<input type="hidden" id="project_no" value="${project.project_no }">
	</div>
	<div class="center-block">
		<div class="row">
			<label class="control-label">목표액 : </label> <label
				class="control-label">${project.project_goal_amount }원</label>
		</div>
		<div class="row">
			<label class="control-label">현재 후원액 : </label> <label
				class="control-label">${project.now_amount }원</label>
		</div>
		<div class="row">
			<label class="control-label">마감일 : </label> <label
				class="control-label">${project.project_end_date }</label>
		</div>
		<div class="row">
			<label class="control-label">잔여기간 : </label> <label
				class="control-label">${project.projectOperDTO.project_d_day}일</label>
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
						<input type="radio" name="radio" id="radio5" value="card" />
						<label for="radio5">카드 결제</label>
					</div>

					<div class="funkyradio-info">
						<input type="radio" name="radio" id="radio6" value="account" />
						<label for="radio6">무통장 입금</label>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group" id="pay_card_area">
					<label class="col-sm-3 control-label" for="textinput">은행
						:</label>
					<div class="col-sm-9 " align="center">
						<select class="form-control" style="margin-left: -43px; width: 93%"> 
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

					<!-- Text input-->
					<div class="form-group" id="numSector_card">
						<label class="col-sm-3 control-label" for="textinput">카드번호
							:</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" maxlength="4"
								title="4">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" maxlength="4"
								title="4">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" maxlength="4"
								title="4">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" maxlength="4"
								title="4">
						</div>
					</div>
				</div>


				<!-- Text input-->
				<div id="pay_cash_area">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="textinput">입금자
							: </label>
						<div class="col-sm-9">
							<input type="text" placeholder="입급자명을 입력하세요" class="form-control"
								title="textInput">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label" for="textinput">계좌번호
							: </label>
						<div class="col-sm-9">
							<input type="text" placeholder="계좌번호를 입력하세요" class="form-control">
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
					<label class="col-sm-3 control-label" for="textinput">은행
						: </label>
					<div class="col-sm-9">
						<select class="form-control">
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
							placeholder="숫자만 입력하세요">
					</div>
				</div>
			</form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>