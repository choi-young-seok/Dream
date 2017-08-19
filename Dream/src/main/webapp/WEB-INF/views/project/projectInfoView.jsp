<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="resources/js/common/jquery.js"></script>
<script src="resources/js/support/supportView.js"></script>

<title>Project Title</title>
<!-- jQuery -->
</head>
<header> <%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
<%@include file="../mainView/header.jsp"%> </header>
<%-- 회원 번호 : ${session.member_no }<br>
등록자 번호 : ${project.member_no }<br>
프로젝트 번호 : ${project.project_no }<br> --%>
<input type="hidden" id="project_no" value="${project.project_no }">


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
				
				<!-- <embed width="640" height="360" src="http://www.youtube.com/v/_0VZc_GwXrE" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed> -->
				<%-- <embed src="resources/member/thumbnail${project.project_video }" clickto autoplay="false"></embed> --%>
				<%-- <object [width="485" height="480"] data="resources/member/thumbnail${project.project_video }" showstatusbar="1"> --%>
				<video width="485" height="480" controls>
				<!-- poster속성을 이용하여 동영상 썸네일 이미지 설정 가능-->
				<!-- <video width="320" height="240" poster="/images/w3html5.gif" controls> -->
				<!-- 다음 url의 코드를 이용하여 clickToPlay 구현할것 -->
				<!--https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_video_js_prop  -->
					<source src="resources${project.project_video }" type="video/mp4">
					<source src="resources${project.project_video }" type="video/ogg">
					<%-- <source src="resources/member/thumbnail${project.project_video }" type="video/mp4">
					<source src="resources/member/thumbnail${project.project_video }" type="video/ogg"> --%>
 				</video>
					<!-- showstatusbar="1" autoplay="false" hidden="false" -->
					</div>
					
					
				<div class="col col-md-2">
					공백</div>
				<div class="col-6 col-md-4">
					<center>
						<font size="5px"><b>${project.supporting_count}명</b></font><br>현재 후원수<br>
						<br> <font size="5px"><b>${project.now_amount }원</b></font><br>
						현재 후원액 <br>
						<br> <font size="5px"><b>${project.project_goal_amount }원</b></font><br>
						목표액 <br>
						<br> <font size="5px"><b>${project_dto.project_d_day} 일</b></font><br>
						잔여기간 <br>	
						<br> <font size="5px"><b>${project.project_end_date }</b></font><br>
						마감일 <br>
						<br>
 				 
 						<c:if test="${session.member_no eq null or session.member_no ne project.member_no}">
							<c:if test="${project.project_register_state eq 'T'}">
								<input type="button" id="support_interest" value="찜하기" class="btn btn-warning">
								<input type="button" id="support_basket" value="장바구니" class="btn btn-warning">
								<input type="button" id="support_project_view" value="후원하기" class="btn btn-warning">
							</c:if>
						</c:if>
						<br>
					</center>
				</div>
			</div>
			<div class="row" style="margin-bottom: 200px;">
				<div class="col-md-4">
					<figure>		
					<%-- <source src="resources/uploadFile${session_member_name }/project_video${project.project_video }" type="video/ogg"> --%>
					<img src="resources${project.register_profile }" width="150" height="200">
<%-- 					<img src="resources/member/thumbnail/${project.register_profile }" width="150" height="200"> --%>
				</figure></div>
				<div class="col-md-4">
					${project.register_name }<br>
					${project.register_sns}<br>
					</div>
				<div class="col-md-4">
					${project.project_summary}</div>
			</div>
			
			<div class="row">
				<div class="col-md-7" style="background-color : white">
					${project.project_content }</div>
				<div class="col-sm-1">
					공백</div>
				<div class="col-md-4" style="background-color : white">
					리워즈 정보 위치
					<br><br>
					<c:forEach items="${rewards}" var="rewards">
						회원 번호 : ${rewards.member_no}<br>
						프로젝트 번호 : ${rewards.project_no}<br>
						전체 리워드 번호 : ${rewards.total_reward_no}<br>
						번호 : ${rewards.reward_no}<br>
						제목 : ${rewards.reward_title}<br>
						품목 : ${rewards.reward_items}<br>
						배송예정일 : ${rewards.reward_delivery_date}<br>
						한정수량 : ${rewards.reward_limited_count}<br>
						가격 : ${rewards.reward_amount}<br>
						<br><br>
						</c:forEach>
						</div>
			</div>
			<c:if test="${project.project_register_state eq 'F'}">
				<div class="pull-right row">
					<a href="#" id="cancel_project_register" value="취소" class="btn btn-danger">취소</a>
					<a href="#" id="project_register" value="등록" class="btn btn-success">등록</a>
				</div>
			</c:if>
		</div>
	</div> 
	

</body>
</html>