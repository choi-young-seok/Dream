<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
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
				<div class="col-md-9" style="padding-top: 60px;"
					id="project_condition">
		
					<h1 class="page-header">주소 등록</h1>
					<%@include file="../../jsp_piece/address/address_insert_area.jsp"%>
					<input class="pull-right btn-primary" type="button" value="등록" id="member_address_insert" param = "address_Info_View">
				</div>
			</div>
		</div>
	</div>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</html>