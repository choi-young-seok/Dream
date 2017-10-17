<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 후원내역</title>
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
					<h1 class="page-header">후원내역</h1>
					
					<div class="tabbable-panel">
						<div class="tabbable-line col-md-12">
							<ul class="nav nav-tabs ">
								<li id="reward_support_list"  class="active">
									<a href="#tab_default_1" data-toggle="tab">
									리워드 후원 </a>
								</li>
								<li id="noReward_support_list">
									<a href="#tab_default_2" data-toggle="tab">
									리워드 없는 후원 </a>
								</li>
								<div class="pull-right">
									<select>
										<option>결제 금액</option>
										<option>결제 일자</option>
									</select>
								</div>
							</ul>
							<hr>
						</div>
					</div>
					<div class="row" style="padding-top: 60px">
						<div class="row" id="mySupportList"></div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
</body>
</html>

<%@include file="../../jsp_piece/support/support_point_info.jsp"%>
<%@include file="../../jsp_piece/support/support_point_info_noReward.jsp"%>
<script type="text/javascript" src="resources/js/mypage/get_mySupport_list.js"></script>
<script type="text/javascript" src="resources/js/mypage/support.js"></script>