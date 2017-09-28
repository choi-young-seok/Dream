<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="boxSpace">
		<div class="row">
			<div class="col-md-9 col-md-offset-1">
				<div class="form-horizontal" role="form">

					<!-- Form Name -->
					<div class="col-sm-12" align="left">
						<div class="col-sm-9">
							<legend id="member_address_request" state="register">배송정보 입력</legend>
						</div>
						<!-- <div class="pull-right">

							<input type="button" class="btn-info" value="주소지 변경" id="change_memberAddress">
						</div> -->
					</div>

					<!-- Text input-->

					<div id="address_area">
						<div class="form-group">
							<label class="col-sm-3 control-label" for="textinput">받으시는분
								:</label>	
							<div class="col-sm-9">
								<input type="text" id="address_member_name"
									value="${session.member_name }" class="form-control"
									title="textInput">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="textinput">주소지
								별칭 :</label>
							<div class="col-sm-9">
								<input type="text" id="address_alias" class="form-control"
									placeholder="예) 집, 직장, 학교" title="textInput">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-3 control-label" for="textinput">우편 번호 :</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="post_num1"
									readonly="readonly">
							</div>

							<label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 30px;"> ㅡ </label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="post_num2"
									readonly="readonly">
							</div>

							<div class="col-sm-2">
								<input id='findAddress' type='button' type='button' value='주소찾기'>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-3 control-label" for="textinput">배송지
								주소 :</label>
							<div class="col-sm-9">
								<input type="text" placeholder="배송지 주소를 검색하세요"
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
					</div>
				</div>
			</div>
			<!-- col-md-8 col-md-offset-2 -->
		</div>
		<!-- /.row -->
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
										class="glyphicon glyphicon-user"></span> 주소 검색</label>
										<input type="text" class="form-control" id="search_address" title="textInput"
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