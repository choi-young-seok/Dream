<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>
<script type="text/javascript" src="resources/js/project/event_projectProfileView.js"></script>
<script type="text/javascript" src="resources/js/support/support_selectReward.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/support/support_selectReward.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>
<script type="text/javascript">
	function getAddressData(zip, address) {

		document.getElementById("post_num1").value = zip.substring(0, 3);
		document.getElementById("post_num2").value = zip.substring(3, 7);
		document.getElementById("choiceAddress").value = address;

		$("#addressModal").modal("hide");
		$("#search_address").val("");
		$("#address_area :text:eq(5)").focus();
	}
</script>
<title>프로젝트 프로필 정보 등록1</title>
</head>

<article> <%@include file="projectTabList.jsp"%>
</article>
<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12 panel panel-default">
				<div class="col col-md-2"></div>
				<div class="col col-md-8">
						<legend>
								<h2 id="request" param="project_profileView">프로젝트 프로필 정보</h2>
							</legend>

					<span><h4>프로필 사진</h4></span>
					<div id="imageZone"title="register_profile" class="dragSpace thumbnailImage" align="center">
					</div>
					<input type="hidden" id="register_profile">

					<div class="boxSpace">
						<span><h4>이름</h4></span> <span><input class="form-control"
							type="text" id="register_name" readonly="readonly"value="${session.member_name }"></span>
					</div>


					<div class="boxSpace">
						<span><h4>소개문구</h4></span> <span><textarea rows="10"
								cols="" id="register_intro"></textarea></span>
					</div>

					<!-- c:if 주소 갯수가 0이면 출력 -->
					<c:if test="${addressInfo eq 'noMemberAddress'}">
						<%@include file="../../jsp_piece/address/address_insert_area.jsp"%>
					
					</c:if>
					
					<!-- c:if 주소 갯수가 0이 아니면 출력 -->
					<c:if test="${addressInfo ne 'noMemberAddress'}">
						<div class="row">
							<div class="col-sm-12">
								<div class="pull-right">
									<input type="button" class="btn-info" value="주소지 변경" id="change_memberAddress">
								</div>
							</div>
						</div>
						
						<div id="address_list"></div>
						<%@include file="../../jsp_piece/address/address_info_area.jsp"%>
					</c:if>
						
					<%-- <di v class="boxSpace">
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								<div class="form-horizontal" role="form">

									<!-- Form Name -->
									<legend>발송지 입력</legend>

									<!-- Text input-->

									<div id="address_area">
										<div class="form-group">
											<label class="col-sm-3 control-label" for="textinput">보내시는분
												:</label>
											<div class="col-sm-9">
												<input type="text" id="address_member_name"
													value="${session.member_name }" class="form-control"
													title="textInput">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="textinput">주소지 별칭
												:</label>
											<div class="col-sm-9">
												<input type="text" id="address_alias" class="form-control"
												placeholder="예) 집, 직장, 학교"	title="textInput">
											</div>
										</div>
										<!-- Text input-->
										<div class="form-group">
											<label class="col-sm-3 control-label" for="textinput">우편
												번호 :</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" id="post_num1"
													readonly="readonly">
											</div>

											<label class="col-sm-1 control-label" for="textinput"
												style="padding-left: 5px; padding-right: 5px; text-align: center; width: 30px;">
												ㅡ </label>
											<div class="col-sm-3">
												<input type="text" class="form-control" id="post_num2"
													readonly="readonly">
											</div>

											<div class="col-sm-2">
												<input id='findAddress' type='button' type='button'
													value='주소찾기'>
											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-sm-3 control-label" for="textinput">발송지
												주소 :</label>
											<div class="col-sm-9">
												<input type="text" placeholder="발송지 주소를 검색하세요"
													class="form-control" id="choiceAddress" readonly="readonly">
											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-sm-3 control-label" for="textinput">상세
												주소 :</label>
											<div class="col-sm-9">
												<input type="text" placeholder="상세주소를 입력하세요"
													class="form-control" title="textInput">
											</div>
										</div>

										<div id="numSector_phone">
											<!-- Text input-->
											<div class="form-group numSector_phone">
												<label class="col-sm-3 control-label" for="textinput">연락처:</label>
												<div class="col-sm-3">
													<input type="text" class="form-control" maxlength="3"
														title="3">
												</div>
												<!-- <label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 24px;"> ㅡ </label> -->

												<div class="col-sm-3">
													<input type="text" class="form-control" maxlength="4"
														title="4">
												</div>
												<!-- <label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 24px;"> ㅡ </label> -->

												<div class="col-sm-3">
													<input type="text" class="form-control" maxlength="4"
														title="4">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- col-md-8 col-md-offset-2 -->
						</div>
						<!-- /.row -->
					</div> --%>

					<input type="button" id="profileInfoRegister"
						class="btn btn-primary pull-right" value="저장하고 다음으로">
				</div>

				<div class="col col-md-2"></div>
			</div>
		</div>
	</div>

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
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</footer>
</html>

<script>
function call_test(member_no, address_member_no){
	//alert("member_no : " +member_no +"\nget_memberAddress : "+get_memberAddress +"\naddress_member_no : " +address_member_no)
	get_memberAddress(member_no, "get_memberAddress", address_member_no)
}
</script>