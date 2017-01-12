<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<!-- Bootstrap Core CSS -->
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="resources/css/shop-homepage.css" rel="stylesheet">
		
		<!-- Dream Up memberJoin.css -->
		<link rel="stylesheet" type="text/css" href="resources/css/member/memberJoin.css">
		<link rel="stylesheet" type="text/css" href="resources/css/member/joinForm.css">
				
		<!-- jQuery -->
		<script src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/member/join.js"></script>
		<title>회원가입</title>
		
	</head>
	<header>
		<%@ include file="../mainView/header.jsp"%>
	</header>
		<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h2 class="title">회원가입</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" method="post" action="#">
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">이메일</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="member_mail" id="member_mail"  placeholder="이메일을 입력하세요">
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">비밀번호</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="member_pass" id="member_pass"  placeholder="비밀번호를 입력하세요"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">비밀번호 재입력</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="member_pass_check" id="member_pass_check"  placeholder="비밀번호를 다시 입력하세요"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">이름</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="member_name" id="member_name"  placeholder="이름을 입력하세요"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">생년월일</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="member_birth" id="member_birth"  placeholder="생년월일을 입력하세요"/>
								</div>
							</div>
						</div>
			
						<div class="well well-sm text-center">
					
							<label for="password" class="cols-sm-2 control-label">성별 : </label>
							<div class="btn-group" data-toggle="buttons">
												
								<label class="btn btn-default">남
									<input type="radio" name="member_gender" id="member_gender" value="M">
									<span class="glyphicon glyphicon-ok"></span>
								</label>

								<label class="btn btn-default">여
									<input type="radio" name="member_gender" id="member_gender" value="F">
									<span class="glyphicon glyphicon-ok"></span>
								</label>
							
							</div>
					
						</div>
						<div class="form-group "> 	
							<button type="button" id="joinBtn" class="btn btn-primary btn-lg btn-block login-button">회원가입</button>
						</div>
						
						<div class="form-group ">
							<button type="button" id="cancelBtn" class="btn btn-danger btn-lg btn-block login-button">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<footer>
			<%@ include file="../mainView/footer.jsp" %>
		</footer>