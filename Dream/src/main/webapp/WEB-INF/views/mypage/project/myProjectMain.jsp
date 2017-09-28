<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이 프로젝트</title>
<script type="text/javascript">
window.onload = function(){
	var request = "${condition.request}"
	var state = '${condition.success_state}'
	//if(request == ""){
		//$("#projects > li:eq(0)").attr("class","active");
		//return;
	//}

	$("#projects > li").removeAttr("class");
	$("#projects > li[title^="+request+"]").attr("class","active");
	if(state ==""){
	if(request == "during_registration"){
		$("#project_state > li").hide();
		$("#project_state > li").removeAttr("class");
	}else{
		$("#project_state > li").show()
	}
		return;
	}
	$("#project_state > li").removeAttr("class");
	$("#project_state > li[title^="+state+"]").attr("class","active");
	
}
	
</script>
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>

<body>
	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<aside> <%@include file="../../mainView/sidebar.jsp"%>
				</aside>
				<div class="col-md-9" style="padding-top: 60px;"
					id="project_condition">
					<h1 class="page-header">마이 프로젝트</h1>
					<ul class="nav nav-tabs" id="projects">
						<li title="processing_project" class="active"><a>진행 프로젝트</a></li>
						<li title="last_project"><a>지난 프로젝트</a></li>
						<li title="during_registration"><a>등록 중</a></li>
					</ul>

					<div id="condition_result" class="dropdown pull-right"></div>

					<ul class="nav nav-tabs pull-right" id="project_state">
						<li class="active" title="T"><a>달성</a></li>
						<li title="F"><a>미달성</a></li>
					</ul>
					
					<table class="table table-striped">
						<tbody>
						<c:forEach items="${ myProject}" var="myProject">
							<tr>
							
								<td><a href='/dream/projectInfoView?project_no=${myProject.project_no }'>
									<img height="155" src="resources${myProject.project_thumbnail }"> 
									${myProject.project_title } <br>
									등록일 : ${myProject.project_start_date }
									</a>
								</td>
								<td>									
									목표금액 : ${myProject.project_goal_amount }원<br>
									현재 후원액 : ${myProject.now_amount }원<br>
									마감일 : ${myProject.project_end_date }<br>
									잔여기간 : ${myProject.projectOperDTO.project_d_day}일
	
								</td>
								<td>
									조회수 : ${myProject.project_viewcnt }<br>
									후원수 : ${myProject.supporting_count }
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<div class='progress'>
										<c:choose>
											<c:when test="${myProject.projectOperDTO.project_percentage > 100}">
												<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: 100%'>${myProject.projectOperDTO.project_percentage}%</div>
											</c:when>
											<c:otherwise>
												<div class='progress-bar' role='progressbar' aria-valuenow='100' aria-valuemin='0' aria-valuemax='100' align='center' style='width: ${myProject.projectOperDTO.project_percentage}%'>${myProject.projectOperDTO.project_percentage}%</div>
											</c:otherwise>
										</c:choose>
									</div>								
								</td>
							</tr>						
						</c:forEach>
							<c:if test="${during_registration.project_title ne null }">
								<tr>
									<td>${during_registration.project_title }</td>
									<td>Doe</td>
									<td>john@example.com</td>
								</tr>	
						</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>