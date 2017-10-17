<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<script type="text/javascript" src="resources/js/validityCheck/validityCheck.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
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
			<form class="form-horizontal" role="form">
				<div class="col-md-10 data_area">
					<h1 class="page-header">비밀번호 변경</h1>
					<div class="form-group check_form" >
						<label class="col-sm-4 control-label" for="textinput">비밀번호 입력 :</label>
						<div class="col-sm-5">
							<input type="password" id="check_password" class="form-control">
						</div>
						<div class="col-sm-2">
							<input id="pass_check_btn" class="btn btn-primary" value="확인" type="button">
						</div>
					</div>

					<div class="form-group edit_form">
						<label class="col-md-4 control-label">변경 비밀번호 :</label> 
						<div class="col-md-5">
							<input class="form-control" type="password" id="member_pass">
						</div>
					</div>

					<div class="form-group edit_form">
						<label class="col-md-4 control-label">비밀번호 확인 :</label>
						<div class="col-md-5">
							<input class="form-control" type="password" id="member_pass_check">
						</div>
						<div class="col-sm-2">
							<input id="pass_edit_btn" class="btn btn-primary" value="변경" type="button"> <span></span>
						</div>
					</div>
					
					<div class="form-group edit_form">
						<div class="col-md-4">
						</div>
						<div class="col-md-5">
							 <span id="pass_check"></span>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
