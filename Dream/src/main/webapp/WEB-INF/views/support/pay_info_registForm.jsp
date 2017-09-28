<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- supportRegister.js -->
<script type="text/javascript" src="resources/js/support/supportViewSetting.js"></script>
<script type="text/javascript" src="resources/js/support/supportRegister.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>
<title>프로젝트 후원</title>
</head>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12" id="textArea">
				<c:if test="${reward_no != 0}">
					<div class="col col-md-8">
				</c:if>

				<c:if test="${reward_no ==0 }">
					<div class="col col-md-1"></div>
					<div class="col col-md-10">
				</c:if>
				<!-- pay_area -->
					<h1 class="page-header" param="support_view" id="request">결제하기</h1>

				<!-- Project_area -->
				<div class="boxSpace">
					<!--  -->
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<form class="form-horizontal" role="form">
								<fieldset>

									<!-- Form Name -->
									<legend>프로젝트 정보</legend>

								</fieldset>
							</form>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<!--  -->
					<img height="100" src="resources${projectPointInfo.project_thumbnail}">
					프로젝트 타이틀 : ${projectPointInfo.project_title }<br> 
					<%-- 프로젝트 등록자 : ${projectPointInfo.register_name }<br> --%>
					<%-- 등록자 주소 : ${project.register_address }<br> --%>
					<%-- 등록자 연락처 : ${projectPointInfo.register_phone } <input type="hidden" --%>
						<%-- id="sender_name" value="${projectPointInfo.register_name }"> --%>
					<%-- 등록자 주소 : <input type="hidden" id="sender_address" value="${project.register_address }">
				등록자 주소 : <input type="hidden" id="sender_address" value="${project.register_address }"> --%>
			<%-- 		<input type="hidden" id="sender_phone" value="${projectPointInfo.register_phone }"> --%>
				</div>

				<!-- pay_info_area -->
				<div class="boxSpace cardSector">
					<!--  -->
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
										<select class="form-control" style="width: 82%">
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
											<input type="text" placeholder="State" class="form-control"
												title="textInput">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">계좌번호
											: </label>
										<div class="col-sm-9">
											<input type="text" placeholder="State" class="form-control">
										</div>
									</div>
								</div>

							</form>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
				</div>

				<!-- payback_area -->
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
										<select>
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

				<!-- address area -->
				<c:if test="${reward_no != 0}">
					<%@include file="../jsp_piece/address/address_insert_area.jsp"%>
						<div class="pull-right">
							<input type="button" class="btn-info" value="주소지 변경" id="change_memberAddress">
						</div>
							<div id="address_list"></div>
					</div>
			</div>
			<%@include file="../jsp_piece/address/address_info_area.jsp"%>
			</c:if>
			<c:if test="${reward_no == 0 }">
				<div class="col-sm-offset-2 col-sm-10" title="supportBtn">
					<div class="pull-right">
						<button id="payBtn" title="${rewards.total_reward_no}"
							class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
					</div>
				</div>
			</c:if>
		</div>
		<!-- col col-md-12 -->

		<c:if test="${reward_no ==0 }">
			<div class="col col-md-1"></div>
		</c:if>

		<!-- reaward info area -->
		<c:if test="${reward_no != 0}">
			<div class="col col-md-4">
				<div class="col-md-2 col-md-offset-0" style="position: fixed;">
					<div class="row" id="select_reward">

						<form class="form-horizontal" role="form">
							<!-- Form Name -->
							<%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%>
							<legend align="center">${rewardVO.reward_no }번 리워드</legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">리워드
									번호 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_no}</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">리워드
									제목 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_title}</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">리워드
									품목 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_items}</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">배송
									예정일 : </label> <label class="col-sm-5 control-label" for="textinput">
									<fmt:formatDate pattern="yy-MM-dd"
										value="${rewardVO.reward_delivery_date}" />
								</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">한정
									수량 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_limited_count}</label>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="textinput">가격
									: </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_amount}</label>
								<input type="hidden" id="support_amount"
									value="${rewardVO.reward_amount }">
							</div>
						</form>

						<%-- <input type="hidden" id="support_amount" value="${rewards.reward_amount }"> --%>

						<div class="col-sm-offset-2 col-sm-8" title="supportBtn">
							<div class="pull-right">
								<button id="payBtn" title="${rewards.total_reward_no}"
									class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
							</div>
						</div>
						<!-- /.row -->
					</div>
				</div>
			</div>
		</c:if>
	<!-- container -->

	<input type="hidden" id="project_no" value="${project.project_no }">

	<input type="hidden" id="reward_no" value="${reward_no}">

	<input type="hidden" id="support_amount_noReward"
		value="${support_amount}">

	<input type="hidden" id="나중에이거지워라" value="${session.member_name}">
	</div>
</body>
<footer> <%@include file="../mainView/footer.jsp"%>
</footer>
</html>

<script>
function call_test(member_no, address_member_no){
	//alert("member_no : " +member_no +"\nget_memberAddress : "+get_memberAddress +"\naddress_member_no : " +address_member_no)
	get_memberAddress(member_no, "get_memberAddress", address_member_no)
}
</script>
