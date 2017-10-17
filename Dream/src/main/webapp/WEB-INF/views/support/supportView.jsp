<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- supportRegister.js -->
<script type="text/javascript" src="resources/js/support/supportView.js"></script>
<title>프로젝트 후원</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">

</head>
<header><%@include file="../mainView/header.jsp"%>
</header>
<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12">
				<h1 class="page-header" param="support_view" id="request">후원하기</h1>
				<div class="col col-md-2"></div>
				<div class="col col-md-8">
	
					<div class="boxSpace">
						<div class="row">
							<div class="col-md-12 col-md-offset-0">
								<form class="form-horizontal" role="form">
									<h3>${project.project_title }</h3>
									<table class="table">
										<tbody>
											<tr>
												<td rowspan="5"><a
													href='/dream/projectInfoView?project_no=${project.project_no}'>
														<img height="155"
														src="resources${project.project_thumbnail}"> <br>
														<input type="hidden" id="project_no"
														value="${project.project_no }">
												</a></td>
											</tr>
											<tr>
												<th>목표금액 : ${project.project_goal_amount }원<br>
												</th>
												<td>조회수 : ${project.project_view_count }<br>
												</td>
											</tr>

											<tr>
												<td>현재 후원액 : ${project.now_amount }원<br>
												</td>
												<td>후원수 : ${project.supporting_count }</td>
											</tr>

											<tr>
												<td>잔여기간 : ${project.projectOperDTO.project_d_day}일</td>
												<td>마감일 : ${project.project_end_date }<br>
												</td>
											</tr>

											<tr>
												<td colspan="2">
													<div class='progress'>
														<c:choose>
															<c:when
																test="${project.projectOperDTO.project_percentage > 100}">
																<div class='progress-bar' role='progressbar'
																	aria-valuenow='100' aria-valuemin='0'
																	aria-valuemax='100' align='center' style='width: 100%'></div>
															</c:when>
															<c:otherwise>
																<div class='progress-bar' role='progressbar'
																	aria-valuenow='100' aria-valuemin='0'
																	aria-valuemax='100' align='center'
																	style='width: ${project.projectOperDTO.project_percentage}%'></div>
															</c:otherwise>
														</c:choose>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>

					</div>
					<%-- 		<div class="boxSpace">
					<div align="center">
						<img src="resources${project.project_thumbnail}">
						<input type="hidden" id="project_no" value="${project.project_no }">
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
					</div>
					<div class="center-block pull-rihgt">
						<div class="row">
							<label class="control-label">등록자 : </label> <label
								class="control-label">${project.register_name }</label>
						</div>
						<div class="row ">
							<label class="control-label">목표액 : </label> <label
								class="control-label">${project.project_goal_amount }원</label>
						</div>
						<div class="row ">
							<label class="control-label">현재 후원액 : </label> <label
								class="control-label">${project.now_amount }원</label>
						</div>
						<div class="row ">
							<label class="control-label">마감일 : </label> <label
								class="control-label">${project.project_end_date }</label>
						</div>
						<div class="row ">
							<label class="control-label">잔여기간 : </label> <label
								class="control-label">${project.projectOperDTO.project_d_day}일</label>
						</div>
					</div>
				</div> --%>

					<div class="boxSpace" align="center">
						후원 금액 : <input type="text" id="support_input_amount">원 <input
							type="button" id="support_project_input" title="input"
							value="후원하기" class="btn btn-warning pull-right">
					</div>
					<c:forEach items="${rewards}" var="rewards">
						<div id="reward_List" class="boxSpace">
							<div class="row" title="test">

								<form class="form-horizontal" role="form">
									<!-- Form Name -->
									<%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%>
									<legend align="center">${rewards.reward_no }번 리워드</legend>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">리워드
											번호 : </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_no}</label>
									</div>
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">리워드
											제목 : </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_title}</label>
									</div>
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">리워드
											품목 : </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_items}</label>
									</div>
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">배송
											예정일 : </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_delivery_date}</label>
									</div>
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">한정
											수량 : </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_limited_count}</label>
									</div>
									<div class="form-group">
										<label class="col-sm-5 control-label" for="textinput">가격
											: </label> <label class="col-sm-3 control-label" for="textinput">${rewards.reward_amount}</label>
										<input type="hidden" id="support_amount"
											value="${rewards.reward_amount }">
									</div>
								</form>

								<input type="hidden" id="support_amount"
									value="${rewards.reward_amount }">
								<div class="col-sm-offset-2 col-sm-10" title="supportBtn">
									<div class="pull-right">
										<button id="support_project_choice"
											title="${rewards.total_reward_no}" class="btn btn-warning"
											param="${rewards.total_reward_no}">후원하기</button>
									</div>
								</div>

							</div>
							<!-- /.row -->
						</div>
					</c:forEach>
				</div>
				<div class="col col-md-2"></div>
			</div>
		</div>
	</div>
</body>
<footer> <%@include file="../mainView/footer.jsp"%>
</footer>
</html>