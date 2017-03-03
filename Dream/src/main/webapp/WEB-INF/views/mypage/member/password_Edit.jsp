<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/common/dividerStyle.css">

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<script type="text/javascript"
	src="resources/js/validityCheck/validityCheck.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.thumbnail {
	height: 210px;
}
</style>
</head>

<header> 
	<%@include file="../../mainView/header.jsp"%>
</header>

<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row">
				<aside> 
					<%@include file="../../mainView/sidebar.jsp"%>
				</aside>

				<div class="col-md-9" style="padding-top: 60px;">
					<h1 class="page-header">비밀번호 변경</h1>
					<%@include file="../../mypage/member/member_Tab.jsp"%>
					
					<div class="form-group check_form">
						<label class="col-md-3 control-label">비밀번호를 입력하세요 : </label>
						<div class="col-md-8">
							<input class="form-control" value="" type="password"
								id="check_password">
						</div>
					</div>

					<div class="form-group edit_form">
						<label class="col-md-3 control-label">변경 비밀번호 :</label>
						<div class="col-md-8">
							<input class="form-control" value="" type="password"
								id="member_pass">
						</div>
					</div>

					<div class="form-group edit_form">
						<label class="col-md-3 control-label">비밀번호 확인 :</label>
						<div class="col-md-8">
							<input class="form-control" value="" type="password"
								id="member_pass_check">
						</div>
					</div>
					<div><span id="pass_check" ></span></div>
					
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<input id="pass_check_btn" class="btn btn-primary" value="확인" type="button">
							<input id="pass_edit_btn" class="btn btn-primary" value="변경" type="button">
							<span></span> 
							<input class="btn btn-default" value="취소" type="reset">
						</div>
					</div>
							
				</div>
			</div>
		</div>
	</div>
</body>
</html>