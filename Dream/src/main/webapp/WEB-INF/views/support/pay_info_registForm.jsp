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
<script type="text/javascript" src="resources/js/support/supportViewValueCheck.js"></script>
<script type="text/javascript" src="resources/js/support/supportRegister.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function getAddressData(zip, address) {

		document.getElementById("post_num1").value = zip.substring(0, 3);
		document.getElementById("post_num2").value = zip.substring(3, 7);
		document.getElementById("choiceAddress").value = address;

		$("#addressModal").modal("hide");
		$("#search_address").val(""); 
		$("#address_area :text:eq(3)").focus();
	}
</script>
</head>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<body>
	<div class="container">
		<div class="col col-md-12" id="inputTest">
			<c:if test="${reward_no != 0}">
				<div class="col col-md-8">
			</c:if>

			<c:if test="${reward_no ==0 }">
				<div class="col col-md-1"></div>
				<div class="col col-md-10">
			</c:if>
			<!-- pay_area -->
			<div class="boxSpace">
				<h1>결제하기
			</div>

			<!-- Project_area -->
			<div class="boxSpace">
				<!--  -->
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<form class="form-horizontal" role="form">
							<fieldset>

								<!-- Form Name -->
								<legend>프로젝트 정보</legend>

								<!-- Text input-->
								<!-- 
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">Line
										1</label>
									<div class="col-sm-9">
										<input type="text" placeholder="Address Line 1"
											class="form-control">
									</div>
								</div>

								Text input
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">Line
										2</label>
									<div class="col-sm-9">
										<input type="text" placeholder="Address Line 2"
											class="form-control">
									</div>
								</div>

								Text input
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">City</label>
									<div class="col-sm-9">
										<input type="text" placeholder="City" class="form-control">
									</div>
								</div>

								Text input
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">State</label>
									<div class="col-sm-3">
										<input type="text" placeholder="State" class="form-control">
									</div>

									<label class="col-sm-3 control-label" for="textinput">Postcode</label>
									<div class="col-sm-3">
										<input type="text" placeholder="Post Code"
											class="form-control">
									</div>
								</div>



								Text input
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">Country</label>
									<div class="col-sm-9">
										<input type="text" placeholder="Country" class="form-control">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="pull-right">
											<button type="submit" class="btn btn-default">Cancel</button>
											<button type="submit" class="btn btn-primary">Save</button>
										</div>
									</div>
								</div> -->

							</fieldset>
						</form>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<!--  -->
				<img height="100"
					src="resources/member/thumbnail/${project.project_thumbnail}">
				프로젝트 정보 ${project.project_no } 프로젝트 타이틀 : ${project.project_title }
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
									<input type="radio" name="radio" id="radio5" value="card" /> <label
										for="radio5">카드 결제</label>
								</div>

								<div class="funkyradio-info">
									<input type="radio" name="radio" id="radio6" value="account" />
									<label for="radio6">무통장 입금</label>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group" id="pay_card_area">
								<label class="col-sm-3 control-label" for="textinput">은행 :</label>
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
									<label class="col-sm-3 control-label" for="textinput">카드번호 :</label>
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
							</div>
			
							
							<!-- Text input-->
							<div id="pay_cash_area">
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">입금자 : </label>
									<div class="col-sm-9">
										<input type="text" placeholder="State" class="form-control" title="textInput">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">계좌번호 : </label>
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
				<div class="boxSpace">
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<form class="form-horizontal" role="form">

								<!-- Form Name -->
								<legend align="center">배송지 입력</legend>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-sm-3 control-label" for="textinput">받으시는분 :</label>
									<div class="col-sm-9">
										<input type="text" id="receiver_name" placeholder="받으시는 분 성함을 입력하세요" class="form-control" title="textInput"> 
									</div>
								</div>

								<div id="address_area">
									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">우편 번호 :</label>
										<div class="col-sm-3">
											<input type="text" class="form-control" id="post_num1" readonly="readonly">
										</div>

										<label class="col-sm-1 control-label" for="textinput"
											style="padding-left: 5px; padding-right: 5px; text-align: center; width: 30px;"> ㅡ </label>
										<div class="col-sm-3">
											<input type="text" class="form-control" id="post_num2" readonly="readonly">
										</div>

										<div class="col-sm-2">
											<input id='findAddress' type='button' type='button' value='주소찾기'>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">배송 주소 :</label>
										<div class="col-sm-9">
											<input type="text" placeholder="배송지 주소를 검색하세요" class="form-control" id="choiceAddress" readonly="readonly">
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">상세 주소 :</label>
										<div class="col-sm-9">
											<input type="text" placeholder="상세주소를 입력하세요" class="form-control" title="textInput">
										</div>
									</div>
								</div>

								<div id="numSector_phone">
									<!-- Text input-->
									<div class="form-group numSector_phone">
										<label class="col-sm-3 control-label" for="textinput">연락처:</label>
										<div class="col-sm-3">
											<input type="text" class="form-control" maxlength="3" title="3">
										</div>
										<!-- <label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 24px;"> ㅡ </label> -->

										<div class="col-sm-3">
											<input type="text" class="form-control" maxlength="4" title="4">
										</div>
										<!-- <label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 24px;"> ㅡ </label> -->

										<div class="col-sm-3">
											<input type="text" class="form-control" maxlength="4" title="4">
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- col-md-8 col-md-offset-2 -->
					</div>
					<!-- /.row -->
				</div>
			</c:if>
			<c:if test="${reward_no == 0 }">
				<div class="col-sm-offset-2 col-sm-10" title="supportBtn">
					<div class="pull-right">
						<button id="payBtn" title="${rewards.total_reward_no}" class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
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
						<div class="row"  id="select_reward">

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
									<input type="hidden" id="support_amount" value="${rewardVO.reward_amount }">
								</div>
							</form>

							<%-- <input type="hidden" id="support_amount" value="${rewards.reward_amount }"> --%>
								
							<div class="col-sm-offset-2 col-sm-8" title="supportBtn">
								<div class="pull-right">
									<button id="payBtn" title="${rewards.total_reward_no}" class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
								</div>
							</div>
						<!-- /.row -->
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<!-- container -->

	<!-- address modal point -->
	<div class="container">
		<div class="row">
			<!-- Login Modal -->
			<div class="modal fade" id="addressModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="loginSpan">
								<span class="glyphicon glyphicon-lock"></span> 주소 찾기
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<form role="form">
								<div class="form-group">
									<label for="search_address"><span
										class="glyphicon glyphicon-user"></span> 주소 검색</label> <input
										type="text" class="form-control" id="search_address"
										placeholder="거주지의 동, 건물명을 입력하세요">
								</div>

								<a id="address_search_btn" class="btn btn-info btn-block"
									role="button">검색</a>

								<div class="form-group">
									<div id="data_count"></div>
									<div id="search_result" class="form-group"></div>
									<!-- <label for="authNum"><span class="glyphicon glyphicon-eye-open"></span> 인증번호 입력</label> -->
									<!-- <input type="text" class="form-control" id="authNum" placeholder="인증번호를 입력하세요"> -->
								</div>

								<!-- 								<a id="authSubmit" class="btn btn-info btn-block" role="button">확인</a> -->
							</form>
							<div class="form-group">
								<div align="center">
									<ul id="paginationReuslt" class="pagination"></ul>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<!-- <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"> -->
							<button id="authCancel" class="btn btn-danger btn-block"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span> 취소
							</button>
						</div>
						<!-- modal-footer -->

					</div>

				</div>
			</div>
		</div>
	</div>


	<input type="hidden" id="project_no" value="${project.project_no }">

	<input type="hidden" id="reward_no" value="${reward_no}"> 

	<input type="hidden" id="support_amount_noReward" value="${support_amount}">

	<input type="hidden" id="나중에이거지워라" value="${session.member_name}">
</body>
<footer> <%@include file="../mainView/footer.jsp"%>
</footer>
</html>
