<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/get_addressList.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>
<body>
	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<aside> <%@include file="../../mainView/sidebar.jsp"%>
				</aside>
				<div class="col-md-9" style="padding-top: 60px;" id="project_condition">
					<h1 class="page-header" param="address_list" id="request">배송 정보</h1>
					
					<div class="row">
						<input type="button" value="주소 추가" id="address_info_insert"
						class="pull-right btn-primary">
					</div>	
					<div class="row">
						<div id="address_list">
							등록된 주소가 없습니다.<br>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- address modal point -->
		<%@include file="../../jsp_piece/address/address_modal_area.jsp"%>
		<%@include file="../../jsp_piece/address/address_info_area.jsp"%>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</html>
		
