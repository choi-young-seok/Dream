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

<title>프로젝트 계좌 정보 등록</title>
<header> 
	<%@include file="../../mainView/header.jsp" %>
</header>
<article>
	<%@include file="projectTabList.jsp" %>
</article>

</head>
<body>
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-1"></div>
			<div class="col col-md-10">
				<h1>프로젝트 계좌 정보 등록</h1>
				
				<div class="boxSpace">
					<span><h4 align="center">이용약관 동의</h4></span> <span><div id="imageZone" class="thumbnailImage" title="project_thumbnail">이용 약관 소개</div></span>
					<div class="pull-right">
						<input type="radio" id="access_terms_agree" name="access_terms_agree" value="T">동의
						<input type="radio" id="access_terms_agree" name="access_terms_agree" value="F">동의 않함
					</div>
				</div>
				
				<div class="boxSpace">
					<span><h4 align="center">등록자 주소</h4></span>
					<span><input type="text" id="register_address"></span>
				</div>

				<div class="boxSpace">
					<span><h4 align="center">은행</h4></span>
					<span><select id="account_bank_list">
						<option>----</option>
						<option>영상</option>
						<option>과학</option>
						<option>교육</option>
						<option>뷰티</option>
						<option>패션</option>
						<option>음식</option>
					</select></span>	  				
					<span><h4 align="center">프로젝트 계좌번호</h4></span>
					<span><input type="text" id="project_account"></span>
				</div>

				 <button type="button" id="accountInfoRegister" class="btn btn-primary pull-right">저장하고 다음으로</button>
			</div>

			<div class="col col-md-1"></div>
		</div>
	</div>
</body>
<footer> 
	<%@include file="../../mainView/footer.jsp" %>
</footer>
</html>