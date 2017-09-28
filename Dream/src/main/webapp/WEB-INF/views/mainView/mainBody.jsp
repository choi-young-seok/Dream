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

</head>
<header> 
<%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
	<%@include file="../mainView/header.jsp" %>
</header>
<body>
<div class="wrap">
	<!-- Page Content -->
	<div class="container">
		<div class="row">
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
				<div id="mainResultView">등록된 프로젝트가 없습니다.</div>

				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->
	</div>
<footer><%@include file="../mainView/footer.jsp" %></footer>
</body>

</html>
