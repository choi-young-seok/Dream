<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- custom javascript -->
<script type="text/javascript" src="resources/js/validityCheck/validityCheck.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.thumbnail{
	height: 210px;
}

</style>
</head>

<header> 
	<%@include file="../mainView/header.jsp" %>
</header>

<body>
<div class="col-md-12">
    <div class="container">
        <div class="row">
			<aside> 
				<%@include file="../mainView/sidebar.jsp"%>
			</aside>

			<div class="col-md-9" style="padding-top: 60px;">        
			마이 페이지 메인
			
				<div class="row"> 
					<div class="thumbnail col-sm-4 col-lg-4 col-md-4" id="member_Info_Edit">회원 정보</div>
					<div class="thumbnail col-sm-4 col-lg-4 col-md-4" id="project_Info">마이 프로젝트</div>
					<div class="thumbnail col-sm-4 col-lg-4 col-md-4" id="support_Info">후원 프로젝트</div>
					<div class="thumbnail col-sm-4 col-lg-4 col-md-4" id="delivery_Info">배송 조회</div>
					<div class="thumbnail col-sm-4 col-lg-4 col-md-4" id="pay_Info">결제 내역</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>