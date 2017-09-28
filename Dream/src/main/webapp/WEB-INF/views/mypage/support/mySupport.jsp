<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<header> <%@include file="../../mainView/header.jsp"%>
</header>
<body>
	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<aside><%@include file="../../mainView/sidebar.jsp"%>
				</aside>
				
				<div class="col-md-9" style="padding-top: 60px;" id="project_condition">
					<h1 class="page-header">후원내역</h1>
					
					<div class="row pull-right">
						<ul class="nav nav-pills" id="mySupport_list_tab">
							<li id="reward_support_list" class="active"><a>리워드 후원 내역</a></li>
							<li id="noReward_support_list"><a>리워드 없는 후원 내역</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-9" style="padding-top: 60px;" id="project_condition">
					<div class="row">
						<div class="row" id="mySupportList"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%@include file="../../jsp_piece/support/support_point_info.jsp"%>
<%@include file="../../jsp_piece/support/support_point_info_noReward.jsp"%>
<script type="text/javascript" src="resources/js/mypage/get_mySupport_list.js"></script>