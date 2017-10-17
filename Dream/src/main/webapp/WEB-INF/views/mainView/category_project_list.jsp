<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${category }</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<style type="text/css">
.row {
	margin-top: 25px;
	margin-bottom: 25px;
}
</style>
</head>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<body>
	<div class="wrap">
		<!-- Page Content -->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-12 col-md-12">
					<div class="col-sm-10 col-lg-10 col-md-10">
						<legend id="category">
							<b>${category }</b>
						</legend>
					</div>
					<div class="pull-right">
						<select>
							<option>후원금액 순</option>
							<option>조회 순</option>
							<option>달성률 순</option>
						</select>
					</div>
				</div>

				<div id="category_project_list"></div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
<script type="text/javascript"
	src="resources/js/mainBody/get_project_category_list.js"></script>
<%@include file="../jsp_piece/main/project_point_info.jsp"%>