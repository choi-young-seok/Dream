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
<title>회원 정보</title>
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
				<div class="col-md-10 data_area">
					<h1 class="page-header">회원 정보</h1>
					<!-- left column -->
					<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="text-center">
							<div id="profileArea">
								<div id="imageZone" class="member_profile" style="height: 240px;"
									title="member_profile">
								<h6>점선영역에 프로필 사진을 드래그하세요</h6>									
									</div>
								<input type="hidden" id="member_profile">
							</div>
							<div id="uploaded_file" align="center">
								<input id="member_profile_value" type="hidden" value="${member.member_profile }">
							</div>
						

							<c:if test="${member.member_profile != 'NO PROFILE'}">
								<div id="proFileZone">
									<div>
										<img src="displayFile?fileName=${member.member_profile}"
											class="avatar img-circle img-thumbnail"
											alt="drag your profile Image"> <input
											id="member_profile_value" type="hidden"
											value="${member.member_profile }">
									</div>
									<a id="profileEdit" class="btn btn-success">수정</a>
									<a id="profileEdit" class="btn btn-danger">삭제</a>
								</div>
							</c:if>
						</div>
					</div>

					<!-- edit form column -->
					<div class="col-md-8 col-sm-6 col-xs-12 personal-info" style="margin-top: 75px">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-lg-3 control-label">이름 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${session.member_name }"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">생년월일 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${member.member_birth }"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">이메일 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${session.member_mail}"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">가입일 :</label>
								<div class="col-lg-8">
									<input class="form-control"
										value="<fmt:formatDate pattern='yyyy-MM-dd' value='${member.member_regdate }'/>"
										type="text" readonly="readonly">
									<%-- ${member.member_regdate } --%>
								</div>
							</div>

							<!-- <div class="form-group">
									<label class="col-md-3 control-label">닉네임 :</label>
									<div class="col-md-8">
										<input class="form-control" value="" type="text">
									</div>
								</div> -->

					<!-- 			 <div class="form-group">
									<label class="col-lg-3 control-label">주소 :</label>
									<div class="col-lg-8">
										<div class="ui-select">
											<select id="user_time_zone" class="form-control">
												<option value="Hawaii">(GMT-10:00) Hawaii</option>
												<option value="Alaska">(GMT-09:00) Alaska</option>
												<option value="Pacific Time (US & Canada)">(GMT-08:00)
													Pacific Time (US & Canada)</option>
												<option value="Arizona">(GMT-07:00) Arizona</option>
												<option value="Mountain Time (US & Canada)">(GMT-07:00)
													Mountain Time (US & Canada)</option>
												<option value="Central Time (US & Canada)"
													selected="selected">(GMT-06:00) Central Time (US &
													Canada)</option>
												<option value="Eastern Time (US & Canada)">(GMT-05:00)
													Eastern Time (US & Canada)</option>
												<option value="Indiana (East)">(GMT-05:00) Indiana
													(East)</option>
											</select>
										</div>
									</div>
								</div> -->

							<!-- 			<span id="pass_check"></span>
								<div class="form-group">
									<label class="col-md-3 control-label"></label>
									<div class="col-md-8">
										<input id="memberInfoEdit" class="btn btn-primary"
											value="변경사항 저장" type="button"> <span></span> <input
											class="btn btn-default" value="취소" type="reset">
									</div>
								</div> -->
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>
