<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 정보</title>
</head>
<header><%@include file="../mainView/header.jsp"%> </header>
<body>
<div class="wrap">
	<div class="container">
		<div class="col col-md-12">
		<%-- <c:if test="${addressVO.shipping_address_no}"> --%>
		<c:if test="${noReward ne 'noReward'}">
		
			<div class="col col-md-6">
				<div id="reward_List" class="boxSpace">
					<div class="row">
						<form class="form-horizontal" role="form">
						    <!-- Form Name -->
						    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
						    <legend align="center">배송 정보</legend>
						    <!-- Text input-->

						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">주문번호 :</label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.shipping_address_no}</label>
						    </div>
						    
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">보내는 사람 :</label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.sender_name}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">발송지 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.sender_address}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">문의처 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.sender_phone}</label>
						    </div> 
						    
						     <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">받는 사람 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.receiver_name}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">연락처 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.receiver_phone}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">우편번호 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.zip_code}</label>
						    </div> 
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">배송지 주소 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.receiver_address}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">상세 주소 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${addressVO.detail_address}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">배송 예정일 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${itemsVO.reward_delivery_date}</label>
						    </div>
						    
						</form>
						
						<%-- <input type="hidden" id="support_amount" value="${rewards.reward_amount }"> --%>
					</div><!-- /.row --> 
				</div><!-- boxSpace -->
			</div><!-- col col-md-6 -->	
		</c:if>
		<%-- </c:if> --%>
				
			<div class="col col-md-6">
				<div id="reward_List" class="boxSpace">
					<div class="row">
						<form class="form-horizontal" role="form">
						    <!-- Form Name -->
						    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
						    <legend align="center">결제 정보</legend>
						    <!-- Text input-->
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">결제 번호 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${supportVO.support_no}</label>
						    </div>
							<c:if test="${noReward ne 'noReward'}">
						    <%-- <c:if test="${itemsVO.reward_items}">	 --%>					    
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">결제 품목 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${itemsVO.reward_items}</label>
							    </div>
						    </c:if>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">결제 가격 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${supportVO.support_amount}</label>
						    </div>
						    <div class="form-group">
					      		<label class="col-sm-5 control-label" for="textinput">결제 수단 : </label>
					      		<label class="col-sm-3 control-label" for="textinput">${supportVO.pay_method}</label>
						    </div>
						</form>
						<%-- <input type="hidden" id="support_amount" value="${rewards.reward_amount }"> --%>
						
					</div><!-- /.row --> 
				</div><!-- boxSpace -->
			</div><!-- col col-md-6 -->		
			
			<div class="col-sm-offset-2 col-sm-10" title="supportBtn">
				<div class="pull-right">
	      			<button class="btn btn-warning"><a href="/dream">첫 화면 가기</a></button>
				</div><!-- pull-right -->
			</div><!-- col-sm-offset-2 col-sm-10 -->
			
		</div><!-- col col-md-12 -->
	</div><!-- container -->
	</div>
</body>
</html>