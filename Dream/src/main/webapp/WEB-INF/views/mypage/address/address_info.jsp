<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript"
	src="resources/js/address/get_addressList.js"></script>
<script type="text/javascript"
	src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript"
	src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript"
	src="resources/js/validityCheck/address_value_check.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>주소지 목록</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>
<article> <%@include file="../../mypage/mypage_sidebar.jsp"%>
</article>

<body>
	<div class="col-md-8">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10 data_area" id="project_condition">
				<h1 class="page-header" param="address_list" id="request">주소지 정보</h1>
	
				<div class="row">
					<input type="button" value="주소 추가" id="address_info_insert" class="pull-right btn-primary">
				</div>
				<div class="row">
					<div id="address_list">
						등록된 주소가 없습니다.<br>
					</div>
	
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

		<!-- address modal point -->
		<%@include file="../../jsp_piece/address/address_modal_area.jsp"%>
		<%@include file="../../jsp_piece/address/address_info_area.jsp"%>
</body>
</html>

