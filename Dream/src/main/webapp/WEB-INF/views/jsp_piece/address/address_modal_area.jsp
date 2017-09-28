<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
											title="textInput" placeholder="거주지의 동, 건물명을 입력하세요">
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
