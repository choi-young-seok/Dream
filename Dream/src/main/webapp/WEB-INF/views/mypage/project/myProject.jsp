<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>

<body>
	<div class="wrap">
		<div class="col-md-12">
			<div class="container">
				<div class="row">
					<aside> <%@include file="../../mainView/sidebar.jsp"%>
					</aside>

					<div class="col-md-9" style="padding-top: 60px;"
						id="project_condition">
						<ul class="nav nav-tabs" id="projects">
							<li class="active"><a title="processing_project"
								id="processing_project" href="#">진행 프로젝트</a></li>
							<li><a title="success_project" id="success_project" href="#">지난 프로젝트</a></li>

							<li><a title="expire_project" id="expire_project" href="#">만료</a></li>

							<li><a title="during_registration" id="during_registration"
								href="#">등록 중</a></li>
						</ul>
						<div id="condition_result" class="dropdown pull-right"></div>

					</div>
					<div class="col-md-9" id="resultView"></div>
					<div class="row"></div>
					<div class="col-md-9" id="resultView2"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>