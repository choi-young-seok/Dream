<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- supportRegister.js -->
<script type="text/javascript" src="resources/js/support/supportRegister.js"></script>
<script type="text/javascript" src="resources/js/support/getPayReward.js"></script>
<title>Insert title here</title>

<link href="resources/css/project/projectRegister.css" rel="stylesheet">

</head>	
<header>
<%@include file="../mainView/header.jsp"%> </header>
<body>
<div class="wrap">
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-3" style="background-color: orange;"></div>
			<div class="col col-md-6" style="background-color: yellow;">
				<div class="boxSpace">
					<h1>결제하기
				</div> 
				
				<div class="boxSpace">
				<img src="resources/member/thumbnail/${project.project_thumbnail}">
					프로젝트 정보
					${project.project_no }
					${project.project_title }
				</div>				
				
				<div class="boxSpace">
				개인 정보 수집 동의<br>
					
				</div>
				
				<div class="boxSpace">
					결제 정보 확인<br> 
					결제자 : <input type="text"><br>
					배송 주소 : <input type="text">-<input type="text"><br>
					<input type="text">
					받으시는분 : <input type="text"><br>
					연락처 : <input type="text">-<input type="text">-<input type="text"><br>
					결제 방법 : <input type="text"><br>
					결제 금액 :<input type="text"><br>
					리워드 품목 : <input type="text"><br>
					상품 도착 예정일 :<input type="text"><br>
					<input type="button" value="결제하기1">
					
				</div>
				
			</div>
				
				<input type="button" id="pay" value="결제하기2">
			</div>
			<div class="col col-md-3" style="background-color: orange;"></div>
		</div>
	</div>
	프로젝트 번호 : <input type="text" id="project_no" value="${project.project_no}">
	리워드 번호 : <input type="text" id="reward_no" value="${reward_no}">
	후원 금액 : <input type="text" value="${support_amount}원">
	
</body>   
<footer> 
	<%@include file="../mainView/footer.jsp" %>
</footer>
</html>