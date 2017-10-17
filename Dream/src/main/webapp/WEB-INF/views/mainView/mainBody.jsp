<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <footer><%@include file="../mainView/footer.jsp" %></footer> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- jquery -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<script type="text/javascript" src="resources/js/mainBody/mainList.js"></script>

<title>Dream Up</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<style type="text/css">
.mainTest {
	background-color: orange;
}

.mainTest_data {
	background-color: blue;
}

.row {
	margin-top: 25px;
	margin-bottom: 25px;
}
</style>
</head>
<header> <%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
<%@include file="../mainView/header.jsp"%> </header>
<body>
	<div class="wrap">
		<!-- Page Content -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Main carousel -->
					<!-- 		<div class="row carousel-holder">

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

				</div> -->
					<div class="row">
						<div class="col-md-11">
							<legend style="font-size: xx-large;">최다 후원 프로젝트</legend>
						</div>
						<div id="max_support_project_list"></div>
					</div>
					
					<div class="row">
						<div class="col-sm-12" align="left">
							<div class="col-md-10" >
								<legend style="font-size: xx-large;">실시간 핫이슈</legend>
							</div>
							<div class="pull-right" style="font-size: xx-large;">더보기 >></div>
						</div>
						<div id="hot_project_list"></div>
					</div>

					<div class="row">
						<div class="col-sm-12" align="left">
							<div class="col-md-10" >
								<legend style="font-size: xx-large;">신규 등록 프로젝트</legend>
							</div>
							<div class="pull-right" style="font-size: xx-large;">더보기 >></div>
						</div>
						<div id="new_project_list"></div>
					</div>

					<div class="row">
						<div id="loading-mask">
							<img src='resources/img/loading.gif'>
						</div>

					</div>

				</div>

			</div>

		</div>
		<!-- /.container -->
	</div>
	<footer><%@include file="../mainView/footer.jsp"%></footer>
</body>

</html>
<%@include file="../jsp_piece/main/project_point_info.jsp"%>
<%@include file="../jsp_piece/main/max_support_project.jsp"%>
