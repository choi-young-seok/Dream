<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>
<title>Insert title here</title>
<style type="text/css">
#imageZone {
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}
</style>
</head>
<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row">
				<aside> <%@include file="../mainView/sidebar.jsp"%>
				</aside>
				<div class="col-md-9" style="padding-top: 60px;">
					<!-- 	<div class="container" > -->
					<h1 class="page-header">회원 정보</h1>
					<div class="row">
						<!-- left column -->
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="text-center">

								<!-- <div id="imageZone" style="border: inset;"> -->
									<img id="imageZone" src="${member.member_profile}"
										class="avatar img-circle img-thumbnail"
										alt="drag your profile Image">
								<!-- </div> -->
									<div id='uploadedList'></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>