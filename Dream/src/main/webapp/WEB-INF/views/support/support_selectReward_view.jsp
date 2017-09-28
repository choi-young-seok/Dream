<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 후원</title>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<html>
	<body>
		<div class="wrap">
			<div class="container">
				<div class="col col-md-12" id="textArea">
				<h1 class="page-header" param="support_view" id="request">결제하기</h1>
					<div class="col col-md-8">
						<%@include file="../jsp_piece/support/supportView_pay_insert_area.jsp"%>
						<%-- <%@include file="../jsp_piece/address/address_insert_view.jsp"%> --%>
						
						<!-- c:if 주소 갯수가 0이면 출력 -->
						<c:if test="${addressInfo eq 'noMemberAddress'}">
							<%@include file="../jsp_piece/address/address_insert_area.jsp"%>
						
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
							<%@include file="../jsp_piece/address/address_info_area.jsp"%>
						</c:if>
					</div>
					<div class="col col-md-4" >
						<%-- <div id="reward_info_area"  style="position:fixed; width: 18%">리워드 출력 영역</div>
<!-- 						<div id="reward_info_area"  style="width=25%, position: fixed;">리워드 출력 영역</div> -->
						<%@include file="../jsp_piece/reward/supportView_reward_info.jsp"%> --%>
						<div class="boxSpace" style="width: 19%; position: fixed;">
							<!-- <div class="col-md-2 col-md-offset-0" > -->
								<div class="row" id="select_reward">
			
									<form class="form-horizontal" role="form">
										<!-- Form Name -->
										<%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%>
										<legend align="center">${rewardVO.total_reward_no }번 리워드?</legend>
										<input type="hidden" id="reward_no" value="${rewardVO.total_reward_no }">
										
										<!-- Text input-->
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">리워드
												번호 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_no}</label>
										</div>
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">리워드
												제목 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_title}</label>
										</div>
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">리워드
												품목 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_items}</label>
										</div>
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">배송
												예정일 : </label> <label class="col-sm-5 control-label" for="textinput">
												${rewardVO.reward_delivery_date}
											</label>
										</div>
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">한정
												수량 : </label> <label class="col-sm-5 control-label" for="textinput">${rewardVO.reward_limited_count}</label>
										</div>
										<div class="form-group">
											<label class="col-sm-5 control-label" for="textinput">가격
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
						<!-- </div> -->
					</div>
			
					
					<div class="col-sm-offset-2 col-sm-8" title="supportBtn">
						<div class="col-md-3 col-md-offset-0" style="position: fixed;">
							<div class="row" id="select_reward">
								<div class="pull-right">
									<button id="payBtn" title="${rewards.total_reward_no}"
										class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>
						<%@include file="../jsp_piece/address/address_modal_area.jsp"%>

<footer> <%@include file="../mainView/footer.jsp"%>
</footer>

<!-- supportRegister.js -->
<script type="text/javascript" src="resources/js/support/supportViewSetting.js"></script>
<script type="text/javascript" src="resources/js/support/support_selectReward.js"></script>

<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>
<script>
function call_test(member_no, address_member_no){
	//alert("member_no : " +member_no +"\nget_memberAddress : "+get_memberAddress +"\naddress_member_no : " +address_member_no)
	get_memberAddress(member_no, "get_memberAddress", address_member_no)
}
</script>
