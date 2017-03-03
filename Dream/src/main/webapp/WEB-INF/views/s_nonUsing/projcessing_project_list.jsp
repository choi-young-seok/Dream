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

<header> 
<%-- 	<%@include file="../../mainView/header.jsp"%> --%>
</header>

<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row">
				<aside> 
<%-- 					<%@include file="../../mainView/sidebar.jsp"%> --%>
				</aside>

				진행중 프로젝트 리스트
				<div class="col-md-9" style="padding-top: 60px;">
					<c:forEach items="${projcessing_project_list}" var="projcessing_project_list">
					${projcessing_project_list.project_title}
					
					</c:forEach>
							
				</div>
			</div>
		</div>
	</div>
</body>
</html>