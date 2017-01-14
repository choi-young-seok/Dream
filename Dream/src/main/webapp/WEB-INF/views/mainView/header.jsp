<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- jstl core libary -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<head>
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">

<!-- Dream Up Custom.css  -->
<link href="resources/css/custom/index.css" rel="stylesheet" type="text/css" />

<!-- Dream Up Login.css -->
<link href="resources/css/common/login.css" rel="stylesheet"type="text/css" />

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/common/bootstrap.min.js"></script>

<!-- header.js -->
<script type="text/javascript" src="resources/js/header/header.js"></script>
<!-- login.js -->
<script type="text/javascript" src="resources/js/login/login.js"></script>

</head>
<body>
<!-- Navigation --> 
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/dream">DreamUp</a>
		</div>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">카테고리별 프로젝트</a></li>
	
				<c:if test="${session.member_mail ne null || session.member_mail ==''}">
					<li><a href="#">프로젝트 등록</a></li>
				</c:if>
	
				<%-- <c:if test="${session.Progressing_Project_Count > 0}"> --%>
				<li><a href="#">마이 프로젝트</a></li>
				<%-- </c:if> --%>
			</ul>
	
			<!--navbar 우측 정렬 -->
			<ul class="nav navbar-nav navbar-right">
				<!-- search bar  -->
				<!-- <form class="navbar-form navbar-left">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>  -->
	
				<!-- 로그인 버튼 및 로그인 완료시 사용자 드롭다운 메뉴 -->
				<c:if test="${session.member_name != '' || session.member_name ne null}">
					<li class="dropdown">
					<c:if test="${session.member_name ne null}">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">${session.member_name }<span class="caret"></span></a>
					</c:if>
						<ul class="dropdown-menu">
							<li><a href="#">마이페이지</a></li>
							<li class="divider"></li>
		
							<%-- <c:if test="${session.Total_Project_Count > 0}"> --%>
							<li><a href="#">마이 프로젝트</a></li>
							<%-- </c:if> --%>
		
							<%-- <c:if test="${session.Supporting_Count > 0 }"> --%>
							<li><a href="#">후원 프로젝트</a></li>
							<li><a href="#">결제 내역</a></li>
							<%-- </c:if> --%>
		
							<li><a href="#">내 정보 수정</a></li>
		
							<li class="divider"></li>
							<li><a id="logout">로그아웃</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${session.member_mail =='' || session.member_mail eq null}">
					<li id="loginBtn"><a href="#"><span
							class="glyphicon glyphicon-log-in"></span>로그인</a></li>
				</c:if> 
			</ul>
		
		</div><!-- /.navbar-collapse -->
	
	</div><!-- /.container --> 

	<!-- nav -->
	</nav> 
	
	<div class="container">
		<div class="row">
			<!-- Login Modal -->
			<div class="modal fade" id="loginModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="loginSpan">
								<span class="glyphicon glyphicon-lock"></span> Login
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<form role="form">
								<div class="form-group">
									<label for="usrname"><span class="glyphicon glyphicon-user"></span> 이메일</label>
										<input type="email" class="form-control" id="login_mail" placeholder="이메일을 입력하세요">
								</div>
								
								<div class="form-group">
									<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
									 <input type="password" class="form-control" id="login_pass"
										placeholder="비밀번호를 입력하세요">
								</div>
						
								<a id="login" class="btn btn-info btn-block" role="button">로그인</a>
								<hr><div class="text-muted center-block" style="text-align: center;"><h2>or</h2></div>
								<a href="#" class="btn btn-info btn-block" role="button">facebook</a>
								<a href="memberJoinForm" class="btn btn-info btn-block" role="button">회원가입</a>
								<a href="companyJoinForm" class="btn btn-info btn-block" role="button">기업 회원가입</a>
		 
								<div class="checkbox">
									<label class="pull-left"><input type="checkbox" value="" checked>자동 로그인</label>
									<label class="pull-right"><a href="#">아이디 / 비밀번호 찾기</a></label>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<!-- <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"> -->
							<button type="submit" class="btn btn-danger btn-block" data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span> 취소
							</button>
						</div>
					</div>

				</div>
			</div>
		</div><!-- /.container --> 
	</div>
	</body>
