<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<link href="resources/css/common/commonStyle.css" rel="stylesheet">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/common/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

</head>
<html>
<body>
	<input type="hidden" value="${session_no }" id="session_no">
	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<h1 class="page-header">주소지 추가</h1>
				<%@include file="../../jsp_piece/address/address_insert_area.jsp"%>
				<input class="pull-right btn-primary" type="button" value="등록" id="member_address_insert" param = "get_changeAdress_list">
			</div>
		</div>
	</div>
</body>
</html>

<%@include file="../../jsp_piece/address/address_modal_area.jsp"%>