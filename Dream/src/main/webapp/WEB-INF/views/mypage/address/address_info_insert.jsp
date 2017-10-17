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
	src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript"
	src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript"
	src="resources/js/validityCheck/address_value_check.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>주소지 입력</title>
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

					<h1 class="page-header">주소 등록</h1>
						<%@include file="../../jsp_piece/address/address_insert_area.jsp"%>
					<input class="pull-right btn-primary" type="button" value="등록"
						id="member_address_insert" param="mypage_address">
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
</body>
</html>