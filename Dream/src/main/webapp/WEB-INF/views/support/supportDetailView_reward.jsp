<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 정보</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
</head>
<header><%@include file="../mainView/header.jsp"%> </header>
<body>
<div class="wrap">
	<div class="container">
		<div class="col col-md-12 panel panel-default">
			<%@include file="../jsp_piece/support/support_detail.jsp"%>
			<div class="row">
				<div class="col col-md-1"></div>
				<div class="col col-md-10">
					<div id="reward_List" class="printSpace">
						<div class="row">
							<form class="form-horizontal" role="form">
							    <!-- Form Name -->
							    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
							    <legend align="center">리워드 정보</legend>
							    <!-- Text input-->
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">리워드 타이틀 :</label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.supportRewardDTO.reward_title}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">리워드 아이템 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.supportRewardDTO.reward_items}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">리워드 가격 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.supportRewardDTO.reward_amount}</label>
							    </div> 
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">배송 예정일 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.supportRewardDTO.reward_delivery_date}</label>
							    </div>
							</form>
							
						</div><!-- /.row --> 
					</div><!-- printSpace -->
				</div><!-- col col-md-10-->	
				<div class="col col-md-1"></div>	
			</div>
			
			<div class="row">
				<div class="col col-md-1"></div>
				<div class="col col-md-10">
					<div id="reward_List" class="printSpace">
						<div class="row">
							<form class="form-horizontal" role="form">
							    <!-- Form Name -->
							    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
							    <legend align="center">배송 정보</legend>
							    <!-- Text input-->
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">보내는 사람 :</label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.senderAddressVO.address_member_name}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">발송지 우편번호 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.senderAddressVO.member_address_zip_code}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">발송지 주소 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.senderAddressVO.member_address}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">발송지 상세주소 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.senderAddressVO.member_detail_address}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-4 control-label" for="textinput">문의처 : </label>
						      		<label class="col-sm-5 control-label" for="textinput">${supportDetail.supportDeliveryDTO.senderAddressVO.address_member_phone}</label>
							    </div> 
							    <hr>
							    <div id="address_list"></div>
								<%@include file="../jsp_piece/address/address_info_area.jsp"%>
							</form>
							
						</div><!-- /.row --> 
					</div><!-- printSpace -->
				</div><!-- col col-md-10-->	
				<div class="col col-md-1"></div>
			</div>

			<div class="row"> 			
				<div class="col col-md-1"></div>
				
				<div class="col col-md-10" title="supportBtn">
					<div class="pull-right">
						<input type="text" class="btn btn-warning" value="결제목록">
						<input type="text" class="btn btn-warning" value="메인화면">
					</div><!-- pull-right -->
				</div><!-- col col-md-10 -->
				
				<div class="col col-md-1"></div>
			</div>
		</div><!-- col col-md-12 -->
	</div><!-- container -->
</div>
			<%@include file="../jsp_piece/address/address_modal_area.jsp"%>
</body>
<footer> <%@include file="../mainView/footer.jsp"%>
</footer>
</html>

<script type="text/javascript" src="resources/js/address/request_receiverAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<!-- <script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script> -->
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>