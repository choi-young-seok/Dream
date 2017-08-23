<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>
<title>프로젝트 기본 정보 등록</title>
</head>

<article>
	<%@include file="projectTabList.jsp" %>
</article>
<body>
<div class="wrap">
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-2"></div>
			<div class="col col-md-8">
				<h1>프로젝트 기본 정보 등록</h1>
				
				<div class="boxSpace" align="center">
					<span><h4>프로필 사진</h4></span> <span><div id="imageZone" title="register_profile" class="thumbnailImage"></div></span>
					<input type="hidden" id="register_profile">
				</div>
				
				<div class="boxSpace">
					<span><h4>이름</h4></span>
					<span><input type="text" id="register_name"></span>
				</div>
				
				<div class="boxSpace">
					<span><h4>연착처</h4></span>
					<span><input type="text" id="register_phone"></span>
				</div>
				
				<div class="boxSpace">
					<span><h4>소개문구</h4></span>
					<span><textarea rows="10" cols="" id="register_intro"></textarea></span>
				</div>
				
				<div class="boxSpace">
					<span><h4>SNS 주소</h4></span>
					<span><div><input type="text" id="register_sns"></div></span>
				</div>
				   <button type="button" id="profileInfoRegister" class="btn btn-primary pull-right">저장하고 다음으로</button>
			</div>

			<div class="col col-md-2"></div>
		</div>
	</div>
	</div>
</body>
<footer> 
	<%@include file="../../mainView/footer.jsp" %>
</footer>
</html>