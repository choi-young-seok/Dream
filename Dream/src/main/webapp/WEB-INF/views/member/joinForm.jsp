<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">

<!-- Dream Up memberJoin.css and custom Style-->
<link rel="stylesheet" type="text/css" href="resources/css/member/memberJoin.css">
<link rel="stylesheet" type="text/css" href="resources/css/member/joinForm.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/common/bootstrap.min.js"></script>

<!-- custom javascript -->
<script type="text/javascript" src="resources/js/member/join.js"></script>
<script type="text/javascript" src="resources/js/mailAuth/mailAuth.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/validityCheck.js"></script>

<title>회원가입</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">

</head>
<header> <%@ include file="../mainView/header.jsp"%></header>
<div class="wrap">
	<div class="container allSector">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h2 class="title">
						회원가입
						</h1>
						<hr />
				</div>
			</div>
			<div class="main-login main-center panel">
				<form class="form-horizontal" method="post" action="#">
	
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">이메일</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon">
									<i class="fa fa-envelope fa" aria-hidden="true"></i>
								</span> 
								<input type="text" class="form-control" id="member_mail" placeholder="이메일을 입력하세요">
							</div>
						</div>
					</div>
	
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">비밀번호</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="member_pass"
									id="member_pass" placeholder="비밀번호를 입력하세요" />
							</div>
						</div>
					</div>
	
					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">비밀번호
							재입력</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="member_pass_check"
									id="member_pass_check" placeholder="비밀번호를 다시 입력하세요" />
							</div>
						</div>
					</div>
					<div id="pass_check"></div>
	
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">이름</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="member_name" id="member_name" placeholder="이름을 입력하세요" />
							</div>
						</div>
					</div>
	
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">생년월일</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="member_birth" id="member_birth" placeholder="생년월일을 입력하세요" />
							</div>
						</div>
					</div>
	
					<div class="well well-sm text-center">
	
     						<div class="btn-group" data-toggle="buttons">
						
							<label class="btn btn-default">남 
								<input type="radio" name="member_gender" id="member_gender" value="M" > 
								<span class="glyphicon glyphicon-ok"></span>
							</label> 
							<label class="btn btn-default">여 
								<input type="radio" name="member_gender" id="member_gender" value="F"> 
								<span class="glyphicon glyphicon-ok"></span>
							</label>
							
							<input id="authCheck" type="hidden" value="fail">
							<input id="passCheck" type="hidden" value="fail">
						</div><!-- btn-group -->
	
					</div>
					<div class="form-group ">
						<button type="button" id="joinBtn"
							class="btn btn-primary btn-lg btn-block login-button">회원가입</button>
					</div>
	
					<div class="form-group ">
						<button type="button" id="cancelBtn"
							class="btn btn-danger btn-lg btn-block login-button">취소</button>
					</div>
				</form>
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
								
								<div id="idDuplicationCheck"></div>
	
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
							<button id="authCancel" class="btn btn-danger btn-block" data-dismiss="modal">
								<span  class="glyphicon glyphicon-remove"></span> 취소
							</button>
						</div><!-- modal-footer -->
						
					</div>
	
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- /.container -->
	<footer> <%@ include file="../mainView/footer.jsp"%>
	</footer>