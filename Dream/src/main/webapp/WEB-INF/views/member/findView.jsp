<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/member/findView.css">
<link rel="stylesheet" type="text/css" href="resources/css/member/findViewCustom.css">

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<script type="text/javascript" src="resources/js/validityCheck/validityCheck.js"></script>
<script type="text/javascript" src="resources/js/mailAuth/mailAuth.js"></script>
<script type="text/javascript" src="resources/js/member/findLoginInfo.js"></script>

<!-- Dream Up custom Style-->
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<title>아이디 / 비밀번호 찾기</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<style type="text/css">

</style>
</head>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<body>
<div class="wrap">
	<div class="container">
		<div class="row">
			<h2>아이디 찾기 / 비밀번호 찾기</h2>
		</div>
	</div>
	<br>
	<br>
	<div class="container sector">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-body">
					<ul class="nav nav-tabs final-login">
						<li class="active"><a data-toggle="tab" href="#sectionA">아이디 찾기</a></li>
						<li><a data-toggle="tab" href="#sectionB">비밀번호 찾기</a></li>
					</ul>
					<div class="tab-content">
						<div id="sectionA" class="tab-pane fade in active">
							<div class="innter-form">
								<form class="sa-innate-form" method="post">
									<label>이름</label> <input type="text" id="member_name">
									<div id="mail_check"></div>
									<label>생년월일</label> <input type="text" id="member_birth">
									<div id="birth_check"></div>
									<div id="findMailInfo"></div>
									<a id="findMailBtn">확인</a>
								</form>
							</div>
							<div class="clearfix"></div>
						</div>
						<div id="sectionB" class="tab-pane fade">
							<div class="innter-form">
								<form class="sa-innate-form" method="post">
									<label>아이디</label> <input type="text" id="member_mail">
									<label>비밀번호</label> <input type="password" id="member_pass">
									<label>비밀번호 재입력</label> <input type="password" id="member_pass_check">
									<div id="pass_check"></div>
									<a id="findPassBtn">비밀번호 변경</a>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<!-- Login Modal -->
			<div class="modal fade" id="mailAuthModal" role="dialog">
				<div class="modal-dialog">
	
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="loginSpan">
								<span class="glyphicon glyphicon-lock"></span> 인증번호 입력
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<form role="form">
								<div class="form-group">
									<label for="member_authMail"><span class="glyphicon glyphicon-user"></span> 이메일</label> 
										<input type="email" class="form-control" id="member_authMail" placeholder="이메일을 입력하세요">
								</div>
								
								<div id="checkMemberMail"></div>
	
								<a id="mailAuthNumBtn" class="btn btn-info btn-block" role="button">인증번호 발송</a>
	
								<div class="form-group">
									<label for="authNum"><span class="glyphicon glyphicon-eye-open"></span> 인증번호 입력</label> 
										<input type="text" class="form-control" id="authNum" placeholder="인증번호를 입력하세요">
								</div>
								<a id="authSubmit" class="btn btn-info btn-block" role="button">확인</a>
							</form>
						</div>
						
						<div class="modal-footer">
							<!-- <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"> -->
							<button class="btn btn-danger btn-block" data-dismiss="modal">
								<span id="authCancel" class="glyphicon glyphicon-remove"></span> 취소
							</button>
						</div><!-- modal-footer -->
						
					</div>
	
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
