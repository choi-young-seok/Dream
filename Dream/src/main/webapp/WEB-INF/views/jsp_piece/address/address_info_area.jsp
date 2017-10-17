<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="template" type="text/x-handlebars-template">
			{{#each .}}
				<form class="form-horizontal boxSpace" role="form" id="member_address_request" state="print_address">
					<div id="address_edit_area{{address_member_no }}">
					<div id="address_area{{address_member_no }}">
						
							<div class="col-sm-12" align="left">
								<div class="col-sm-8 col-sm-offset-2">
									<legend id="old_address_alias{{address_member_no }}">{{address_alias}}</legend>
								</div>

								<div class="pull-right">
									<input type="button" value="수정" id="address_edit_mode"  class="btn-success" 
							param="{{address_member_no }}" request="{{request}}" state="true" delivery_address={{delivery_address}}>
									<div id="delete_btn_area{{address_member_no}}"></div>
									<div id="select_btn_area{{address_member_no}}"></div>
									
								</div>
							</div>
						<div class="row"></div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="textinput">받으시는분 :</label>
							<div class="col-sm-6">
								<input type="text" id="address_member_name{{address_member_no}}"
									value="{{address_member_name}}" class="form-control"
									readonly="readonly" title="textInput">
							</div>
						</div>
						
						<div id="alias_input_area{{address_member_no}}"></div>					

						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-4 control-label" for="textinput">우편 번호 :</label>
							<div class="col-sm-2">
								<input type="text" class="form-control searchArea" id="post_num1{{address_member_no}}"
									readonly="readonly" value="{{post_num1}}">
							</div>

							<label class="col-sm-1 control-label" for="textinput" style="padding-left: 5px; padding-right: 5px; text-align: center; width: 30px;"> ㅡ </label>
							<div class="col-sm-2">
								<input type="text" class="form-control searchArea" id="post_num2{{address_member_no}}"
									readonly="readonly" value="{{post_num2}}">
							</div>
				
							<div id="seach_btn_area{{address_member_no }}"></div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-4 control-label" for="textinput">배송지 주소 :</label>
							<div class="col-sm-6">
								<input type="text" placeholder="배송지 주소를 검색하세요"
									class="form-control searchArea" id="choiceAddress{{address_member_no}}" readonly="readonly" value="{{member_address }}">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-4 control-label" for="textinput">상세 주소 :</label>
							<div class="col-sm-6">
								<input type="text" placeholder="상세주소를 입력하세요"
									class="form-control" title="textInput" readonly="readonly" value="{{member_detail_address }}">
							</div>
						</div>

						<div id="numSector_phone{{address_member_no }}">
							<!-- Text input-->
							<div class="form-group numSector_phone">
								<label class="col-sm-4 control-label" for="textinput">연락처:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" maxlength="3" title="3" readonly="readonly" value="{{member_phone1}}">
								</div>

								<div class="col-sm-2">
									<input type="text" class="form-control" maxlength="4" title="4" readonly="readonly" value="{{member_phone2}}">
								</div>

								<div class="col-sm-2">
									<input type="text" class="form-control" maxlength="4" title="4" readonly="readonly" value="{{member_phone3}}">
								</div>
							</div>
						</div>
						
						<div id="edit_btn_area{{address_member_no }}"></div>

					</div>
					</div>
				</form>
			{{/each}}
		</script>

		<script id="delete_btn" type="text/x-handlebars-template">
			<input type="button" value="삭제" id="address_info_delete" class="btn-danger" param={{address_member_no }}>
		</script>
		
		<script id="select_btn" type="text/x-handlebars-template">
			<input type="button" value="선택" id="address_info_select" class="btn-primary" param={{address_member_no }}>
		</script>
		
		<script id="search_btn" type="text/x-handlebars-template">
			<div class="col-sm-2">
				<input id="findAddress" type="button" type="button" value="주소찾기">
			</div>
		</script>
		
		<script id="alias_input" type="text/x-handlebars-template">
			<div class="form-group">
				<label class="col-sm-4 control-label" for="textinput">주소지 별칭 :</label>
				<div class="col-sm-6">
					<input type="text" id="address_alias{{address_member_no}}" value="{{address_alias}}" class="form-control" title="textInput">
				</div>
			</div>
		</script>
		
		<script id="edit_btn" type="text/x-handlebars-template">
			<div class="form-group">
				<div class="col-sm-10">
					<div class="pull-right">
						<input type="button" value="수정" id="address_info_edit"  class="btn-success" param={{address_member_no}}>
						<input type="button" value="취소" id="address_info_cancel" class="btn-danger">
					</div>
				</div>
			</div>
		</script>

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