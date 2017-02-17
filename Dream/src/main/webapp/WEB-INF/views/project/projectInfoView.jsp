<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="resources/js/common/jquery.js"></script>

<title>Project Title</title>
<!-- jQuery -->
</head>
<header> <%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
<%@include file="../mainView/header.jsp"%> </header>
<c:if test="${project.project_register_state eq 'F'}">
	<article>
		<%@include file="../project/register/projectTabList.jsp" %>
	</article>
</c:if>
<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row" style="margin-bottom: 200px;">
				<div class="col col-md-6" style="background-color: white">
				
				<embed width="640" height="360" src="http://www.youtube.com/v/_0VZc_GwXrE" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed>
					<%-- <embed src="resources/member/thumbnail${project.project_video }" showstatusbar="1" autoplay="false" hidden="false"></embed> --%>
					</div>
				<div class="col col-md-2" style="background-color: gray;">
					공백</div>
				<div class="col-6 col-md-4" style="background-color : white">
					<center>
						<font size="5px"><b>${project.supporting_count}명</b></font><br>현재 후원수<br>
						<br> <font size="5px"><b>${project.now_amount }원</b></font><br>
						현재 후원액 <br>
						<br> <font size="5px"><b>${project.project_goal_amount }원</b></font><br>
						목표액 <br>
						<br> <font size="5px"><b>14일</b></font><br>
						잔여기간 <br>	
						<br> <font size="5px"><b>${project.project_end_date }</b></font><br>
						마감일 <br>
						<br>
						<c:if test="${project.project_register_state eq 'T'}">
							<input type="button" name="supponrt" id="interest" value="찜하기" class="btn btn-warning">
							<input type="button" name="supponrt" id="basket" value="장바구니" class="btn btn-warning">
							<input type="button" name="supponrt" id="supponrt" value="후원하기" class="btn btn-warning">
						</c:if>
						<br>
					</center>
				</div>
			</div>
			<div class="row" style="margin-bottom: 200px;">
				<div class="col-md-4" style="background-color : gray;">
					<figure>		
					<img src="resources/member/thumbnail/${project.register_profile }" width="150" height="200">
				</figure></div>
				<div class="col-md-4" style="background-color : fuchsia;">
					${project.register_name }<br>
					${project.register_sns}<br>
					</div>
				<div class="col-md-4" style="background-color : silver;">
					${project.project_summary}</div>
			</div>
			
			<div class="row">
				<div class="col-md-6" style="background-color : white">
					${project.project_content }</div>
				<div class="col-md-2" style="background-color: gray;">
					공백</div>
				<div class="col-md-4" style="background-color : white">
					리워즈 정보 위치</div>
			</div>
				<div class="pull-right row">
					<a href="#" id="cancel_project_register" value="취소" class="btn btn-danger">취소</a>
					<a href="#" id="project_register" value="등록" class="btn btn-success">등록</a>
				</div>
		</div>
	</div> 
	

</body>
</html>