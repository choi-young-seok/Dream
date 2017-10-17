<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="resources/js/common/jquery.js"></script>
<script src="resources/js/support/supportView.js"></script>
<script src="resources/js/project/projectRegister.js"></script>

<title>${project.project_title }</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<!-- jQuery -->
</head>
<header> <%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
<%@include file="../mainView/header.jsp"%> </header>
<%-- 회원 번호 : ${session.member_no }<br>
등록자 번호 : ${project.member_no }<br>
프로젝트 번호 : ${project.project_no }<br> --%>
<input type="hidden" id="project_no" value="${project.project_no }">


<c:if test="${project.project_register_state eq 'F'}">
	<article> <%@include
		file="../project/register/projectTabList.jsp"%>
	</article>
</c:if>

<body>
	<div class="wrap">
		<div class="container">
			<div class="col-md-12 panel">
				<div class="row" style="margin-bottom: 35px; margin-top: 25px">
					<div class="col col-md-8" style="background-color: white">

						<c:if test="${project.project_video_type eq 'youtube_video' }">
							<embed width="730" height="430"
								src="http://www.youtube.com/v/${project.project_video }"
								type="application/x-shockwave-flash" allowscriptaccess="always"
								allowfullscreen="true"></embed>
						</c:if>
						<%-- <embed src="resources/member/thumbnail${project.project_video }" clickto autoplay="false"></embed> --%>
						<%-- <object [width="485" height="480"] data="resources/member/thumbnail${project.project_video }" showstatusbar="1"> --%>
						<c:if test="${project.project_video_type eq 'member_video' }">
							<video width="730" height="430" controls> <!-- poster속성을 이용하여 동영상 썸네일 이미지 설정 가능-->
							<!-- <video width="320" height="240" poster="/images/w3html5.gif" controls> -->
							<!-- 다음 url의 코드를 이용하여 clickToPlay 구현할것 --> <!--https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_video_js_prop  -->
							<source src="resources${project.project_video }" type="video/mp4">
							<source src="resources${project.project_video }" type="video/ogg">
							<%-- <source src="resources/member/thumbnail${project.project_video }" type="video/mp4">
					<source src="resources/member/thumbnail${project.project_video }" type="video/ogg"> --%></video>
						</c:if>
						<!-- showstatusbar="1" autoplay="false" hidden="false" -->
						<div class='progress'>
								<c:choose>
									<c:when test="${project.projectOperDTO.project_percentage > 100}">
										<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: 100%'></div>
									</c:when>
									<c:otherwise>
										<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: ${project.projectOperDTO.project_percentage}%'></div>
									</c:otherwise>
								</c:choose>
							</div>			
						<div class="col-md-12" align="left">
							<div class="col-md-10">
								<legend>
									<h3>
										<b>${project.project_title }</b>
									</h3>
								</legend>
										<font color="gray">${project.project_summary}</font> 
								<br>
							</div>
							<div class="pull-right">
								조회수 : <b>${project.project_view_count }</b><br> 후원수 : <b>${project.supporting_count }</b><br>
								좋아요 : <b>33</b>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<center>

							<font size="4px"><b>${project.now_amount }원</b></font><br>후원액<br><br>
							<font size="4px"><b>${project.project_goal_amount }원</b></font><br>목표액<br><br>
							<font size="4px"><b>${project.supporting_count}명</b></font><br>후원수<br><br> 
							<font size="4px"><b>${project.projectOperDTO.project_percentage}%</b></font><br>달성률<br> <br>
							<font size="4px"><b>${project.projectOperDTO.project_d_day}일</b></font><br>잔여기간<br><br>
							<font size="4px"><b>${project.project_start_date } ~ ${project.project_end_date }</b></font><br>후원기간 <br> <br>
							

							<c:if
								test="${session.member_no eq null or session.member_no ne project.member_no}">
								<c:if test="${project.project_register_state eq 'T'}">
									<div class="col-md-12">
										<button style="height: 50px; background-color: #CC8FFC" id="support_project_view"
											class="btn btn-basic">후원하기</button>
										<button style="width: 48%; background-color : #ECD3EB; margin-right: 1%; margin-top: 10px" class="btn btn-basic">
											<img height="40px" id="like_project" src="resources/img/like.png">
										</button>

										<button style="width: 48%; background-color : #ECD3EB; margin-left: 1%; margin-top: 10px" class="btn btn-basic	">
											<img height="40px" id="interest_project"
												src="resources/img/interest_not.png">
										</button>
									</div>
								</c:if>
							</c:if>
							<br>
						</center>
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-3" align="center">
							<img src="resources${project.register_profile }" width="120px">
							<legend>${project.register_name }</legend>
						</div>

						<div class="col-md-8">
							<legend>
								<b>등록자 소개</b>
							</legend>
							${project.register_intro}
						</div>

				<%-- 		<div class="col-md-5">
							<legend>
								<b>프로젝트 소개</b>
							</legend>
							${project.project_summary}
						</div> --%>
					</div>
					<div class="row" style="margin-top: 35px">
						<div class="col-md-12">${project.project_content }</div>

					</div>
				</div>

				<div class="col-md-4">
					<legend>
						<b>리워즈</b>
					</legend>
					<c:forEach items="${rewards}" var="rewards">
						<%-- 회원 번호 : ${rewards.member_no}<br>
						프로젝트 번호 : ${rewards.project_no}<br>
						전체 리워드 번호 : ${rewards.total_reward_no}<br>
						번호 : ${rewards.reward_no}<br> --%>
						<div class="row"
							style="background-color: ghostwhite; border-radius: 10px; border-color: lightblue; margin-bottom: 15px; padding-top: 10px; padding-bottom: 10px">
							<legend align="center">${rewards.reward_title}</legend>
							<label class="col-md-5 control-label col-md-offset-1">리워드
								: </label><label class="col-md-5 control-label">${rewards.reward_items}</label>
							<label class="col-md-5 control-label col-md-offset-1">리워드
								가격 : </label><label class="col-md-5 control-label">${rewards.reward_amount}원</label>
							<label class="col-md-5 control-label col-md-offset-1">한정
								수량 : </label><label class="col-md-5 control-label">${rewards.reward_limited_count}개</label>
							<label class="col-md-5 control-label col-md-offset-1">배송
								예정일 : </label><label class="col-md-5 control-label">${rewards.reward_delivery_date}일</label>
						</div>
					</c:forEach>
				</div>

				<c:if test="${project.project_register_state eq '5'}">
					<div class="pull-right row">
						<a href="#" id="cancel_project_register" value="취소"
							class="btn btn-danger">취소</a> <a id="project_register" value="등록"
							class="btn btn-success">등록</a>
					</div>
				</c:if>
			</div>
		</div>
</body>
</html>
<footer> <%@include file="../mainView/footer.jsp"%>
</footer>

