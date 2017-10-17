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