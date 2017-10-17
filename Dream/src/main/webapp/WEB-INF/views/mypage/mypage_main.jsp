<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Custom CSS -->
<!-- <link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css"> -->

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>마이 페이지</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">

<style type="text/css">
.img_btn {
	height: 210px;
	align : center;
}

.img_btn > div > img{
	width: 350px;
}
</style>
</head>

<header> <%@include file="../mainView/header.jsp"%>
</header>
<article> <%@include file="../mypage/mypage_sidebar.jsp"%>
</article>
<body>
	<div class="col-md-8">
		<div class="row">
			<div class="col-md-12 data_area">
				<h1 class="page-header">마이 페이지</h1>

				<div class="row" align="center">
					<div class="img_btn col-sm-4 col-lg-4 col-md-4" id="member_info">
						<a href="#"><img width="150px" src="resources/img/myUser.png"></a><br><b>회원 정보</b><br>
					</div>
					<div class="img_btn col-sm-4 col-lg-4 col-md-4" id="project_info">
						<a href="#"><img width="150px" src="resources/img/myProject.png"></a><br><b>마이 프로젝트</b><br>
					</div>
					<div class="img_btn col-sm-4 col-lg-4 col-md-4" id="support_info">
						<a href="#"><img width="150px" src="resources/img/mySupport.png"></a><br><b>후원 프로젝트</b><br>
					</div>
					<div class="img_btn col-sm-4 col-lg-4 col-md-4" id="address_info">
						<a href="#"><img width="150px" src="resources/img/myAddress.png"></a><br><b>주소지 조회</b><br>
					</div>
					<div class="img_btn col-sm-4 col-lg-4 col-md-4" id="pay_info">
						<a href="#"><img width="150px" src="resources/img/myInterest.png"></a><br><b>관심 프로젝트</b>
					</div>
				</div>
			</div>
			<!-- </div> -->
		</div>
	</div>
</body>
</html>

<script type="text/javascript" src="resources/js/mypage/mypage_main_forward.js"></script>
