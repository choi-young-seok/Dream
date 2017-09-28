<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<link href="resources/css/common/commonStyle.css" rel="stylesheet">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/common/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/get_addressList.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/address_select_event.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

</head>
<html>
<body>
	<input type="hidden" value="${session_no }" id="session_no">
	<div class="container">
		<div class="col-md-12">
		<h1 class="page-header" id="request" param="address_list" select_btn_check="select_btn_print">주소지 선택</h1>
		<div class="row">
			<input type="button" value="주소 추가" id="choice_address_insert"
						class="pull-right btn-primary">
		</div>
			<div class="row">
					<div id="address_list"></div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="../../jsp_piece/address/address_modal_area.jsp"%>
<%@include file="../../jsp_piece/address/address_info_area.jsp"%>