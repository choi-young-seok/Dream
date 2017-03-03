<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<style type="text/css">
.thumbnail {
	height: 210px;
}
</style>
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>

<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row">
				<aside> <%@include file="../../mainView/sidebar.jsp"%>
				</aside>

				진행중 프로젝트 리스트
				<div class="col-md-9" style="padding-top: 60px;">
					<c:forEach items="${processing_project_list}" var="processing_project_list">
						<hr>
						<a href="/dream/projectInfoView?project_no=${processing_project_list.project_no}">
							<img src="resources/member/thumbnail${processing_project_list.project_thumbnail}">
						</a>
							<div class='progress'>
								<div class='progress-bar' role='progressbar' aria-valuenow='70' aria-valuemin='0' aria-valuemax='100' style='width: 70%'>70%</div>
							</div>
						<hr>
							
						<a href="/dream/projectInfoView?project_no=${processing_project_list.project_no}">
							<img src="resources/member/thumbnail${processing_project_list.project_thumbnail}">
						</a>
							<div class='progress'>
								<div class='progress-bar' role='progressbar' aria-valuenow='70' aria-valuemin='0' aria-valuemax='100' style='width: 70%'>70%</div>
							</div>
						<hr>
							
					
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>