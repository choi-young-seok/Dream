<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Custom CSS -->
<!-- <link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css"> -->

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이 프로젝트</title>
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
			<div class="col-md-10 data_area" id="project_condition">
				<h1 class="page-header">마이 프로젝트</h1>
				<div class="tabbable-panel">
					<div class="col-sm-8">
					
						<div class="tabbable-line">
							<ul class="nav nav-tabs" id="projects">
								<li id="processing_project" class="active" title="processing_project">
									<a href="#tab_default_1" data-toggle="tab"> 진행 프로젝트 </a>
								</li>

								<li id="last_project" title="last_project">
									<a href="#tab_default_2" data-toggle="tab"> 지난 프로젝트 </a>
								</li>

						<!-- 		<li id=during_registration title="during_registration">
									<a href="#tab_default_2" data-toggle="tab" > 등록 중 프로젝트 </a>
								</li> -->
							</ul>
						</div>
					</div>
					
					<div class="pull-right">
						<ul class="nav nav-pills" id="project_state">
							<li class="active" title="T"><a>달성</a></li>
							<li title="F"><a>미달성</a></li>
						</ul>
					</div>
				</div>

				<div class="row" style="padding-top: 60px">
					<div class="row" id="project_list">
					</div>
				</div>

			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript" src="resources/js/mypage/project.js"></script>
<%@include file="../../jsp_piece/mypage/project/project_point_info.jsp"%>