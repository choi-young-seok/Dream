<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title>Dream Up</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">

<!-- Dream Up Custom.css  -->
<link href="resources/css/custom/index.css" rel="stylesheet"
	type="text/css" />
<!-- Dream Up Login.css -->
<link href="resources/css/common/login.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="resources/js/common/jquery-3.0.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#loginBtn").click(function() {
			$("#loginModal").modal();
		});//click event

		$("#loginBtn2").click(function() {
			$("#loginModal").modal();
		});//click event

	});//ready
</script>

</head>
<header> 
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
			<a class="navbar-brand" href="#">DreamUp</a>
		</div>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">카테고리별 프로젝트</a></li>
	
				<c:if test="${session.email ne null || session.email ==''}">
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
				<li class="dropdown">
					<%-- <c:if test="${session.email != '' || session.email ne null}"> --%>
					<%-- <c:if test="${session.email }"> --%> <a class="dropdown-toggle"
					data-toggle="dropdown" href="#">최용석<span class="caret"></span></a>
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
						<li><a href="#">로그아웃</a></li>
					</ul> <%-- </c:if> --%>
				</li>
				<c:if test="${session.eamil =='' || session.eamil eq null}">
					<li id="loginBtn"><a href="#"><span
							class="glyphicon glyphicon-log-in"></span>로그인</a></li>
				</c:if>
			</ul>
		<!-- /.navbar-collapse -->
		</div>
		
	<!-- /.container --> 
	</div>

	<!-- nav -->
	</nav> 
	
</header>
<body>
	<!-- Page Content -->
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
										<input type="email" class="form-control" id="member_email" placeholder="이메일을 입력하세요">
								</div>
								
								<div class="form-group">
									<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
									 <input type="text" class="form-control" id="member_pwd"
										placeholder="비밀번호를 입력하세요">
								</div>
						
								<a href="#" class="btn btn-info btn-block" role="button">로그인</a>
								<hr><div class="text-muted center-block">or?</div>
								<a href="#" class="btn btn-info btn-block" role="button">facebook</a>
								<a href="memberJoinForm" class="btn btn-info btn-block" role="button">회원가입</a>
								<a href="#" class="btn btn-info btn-block" role="button">기업 회원가입</a>
		 
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
		</div>


		<div class="row">
			<div class="col-md-12">
				<!-- Main carousel -->
				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="resources/img/sample.jpg" alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="resources/img/sample.jpg" alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="resources/img/sample.jpg" alt="">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>
				<!-- Main Projcet List -->
				<div class="row">

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$24.99</h4>
								<h4>
									<a href="#">First Product</a>
								</h4>
								<p>
									See more snippets like this online store item at <a
										target="_blank" href="http://www.bootsnipp.com">Bootsnipp
										- http://bootsnipp.com</a>.
								</p>
							</div>
							<div class="ratings">
								<p class="pull-right">15 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$64.99</h4>
								<h4>
									<a href="#">Second Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">12 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$74.99</h4>
								<h4>
									<a href="#">Third Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">31 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$84.99</h4>
								<h4>
									<a href="#">Fourth Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">6 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$94.99</h4>
								<h4>
									<a href="#">Fifth Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">18 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="http://placehold.it/320x150" alt="">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="70"
									aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
							</div>
							<div class="caption">
								<h4 class="pull-right">$94.99</h4>
								<h4>
									<a href="#">Fifth Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">18 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<hr>
					<h4>최다 후원 프로젝트</h4>
					<span class="text-right"><button>more</button></>
						<hr>

						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>

						<hr>
						<h4>오늘 마감 프로젝트</h4>
						<button>more</button>
						<hr>

						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>

						<hr>
						<h4>신규 등록 프로젝트</h4>
						<button>more</button>
						<hr>

						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="http://placehold.it/320x150" alt="">
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="70"
										aria-valuemin="0" aria-valuemax="100" style="width: 70%">70%</div>
								</div>
								<div class="caption">
									<h4 class="pull-right">$94.99</h4>
									<h4>
										<a href="#">Fifth Product</a>
									</h4>
									<p>This is a short description. Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.</p>
								</div>
								<div class="ratings">
									<p class="pull-right">18 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star-empty"></span>
									</p>
								</div>
							</div>
						</div>
				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Your Website 2014</p>
			</div>
		</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

</body>

</html>
