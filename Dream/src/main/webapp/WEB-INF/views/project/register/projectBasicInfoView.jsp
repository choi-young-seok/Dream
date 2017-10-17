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

<title>프로젝트 기본 정보 등록</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">

<article> <%@include file="projectTabList.jsp"%>
</article>

</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12">
				<div class="col col-md-2"></div>
				<div class="col col-md-8">
					<legend>
						<h2>프로젝트 기본 정보</h2>
					</legend>

					<div>
						<h4>썸네일 사진</h4>
						<div align="center" id="imageZone"
							class="dragSpace thumbnailImage" title="project_thumbnail">
						<h6>점선영역에 프로젝트 썸네일 사진을 드래그하세요</h6>
						</div>
						
						<div id="uploaded_file" align="center">
							<input type="hidden" id="project_thumbnail">
						</div>
					</div>
					

					<div class="boxSpace">
						<span><h4>프로젝트 타이틀</h4></span> <span><input
							class="form-control" type="text" id="project_title"></span>
					</div>

					<div class="boxSpace">
						<span><h4>프로젝트 소개문구</h4></span> <span><textarea rows="10"
								cols="" id="project_summary"></textarea></span>
					</div>

					<div class="boxSpace">
						<span><h4>프로젝트 카테고리</h4></span> <span><select
							id="project_category">
								<option>----</option>
								<option>게임</option>
								<option>과학</option>
								<option>디자인</option>
								<option>사진</option>
								<option>영상</option>
								<option>음식</option>
								<option>패션</option>
								<option>음악</option>
						</select></span>
					</div>
					<div class="boxSpace">
						<span><h4>목표 금액</h4></span> <span><input
							class="form-control" type="text" id="project_goal_amount"
							placeholder="숫자만 입력하세요"></span>
					</div>
					<div class="boxSpace">
						<span><h4>후원 기간</h4></span> <span><input
							class="form-control" type="date" id="project_end_date"></span>
					</div>
					<div>
						<br> <br>
						<button type="button" id="basicInfoRegister"
							class="btn btn-primary pull-right">저장하고 다음으로</button>
					</div>
				</div>

				<div class="col col-md-2"></div>
			</div>
		</div>
	</div>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</footer>
</html>