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

<%-- <header> 
	<%@include file="../../mainView/header.jsp" %>
</header> --%>
<article> <%@include file="projectTabList.jsp"%>
</article>

</head>
<body>
	<div class="container">
		<div class="col col-md-12 panel panel-default">
			<div class="col col-md-1"></div>
			<div class="col col-md-10">
				<h1>프로젝트 기본 정보 등록</h1>

				<div>
					<span><h4>썸네일 사진</h4></span> 
					<span>
						<div align="center" id="imageZone" class="thumbnailImage" title="project_thumbnail"></div>
						<input type="hidden" id="project_thumbnail">
					</span>
				</div>

				<div>
					<span><h4>프로젝트 타이틀</h4></span> <span><input
						class="form-control" type="text" id="project_title"></span>
				</div>

				<div>
					<span><h4>프로젝트 소개문구</h4></span> <span><textarea rows="10"
							cols="" id="project_summary"></textarea></span>
				</div>

				<div>
					<span><h4>프로젝트 카테고리</h4></span> <span><select
						id="project_category">
							<option>----</option>
							<option>영상</option>
							<option>과학</option>
							<option>교육</option>
							<option>뷰티</option>
							<option>패션</option>
							<option>음식</option>
					</select></span>
				</div>
				<div>
					<span><h4>목표 금액</h4></span> <span><input
						class="form-control" type="text" id="project_goal_amount"></span>
				</div>
				<div>
					<span><h4>후원 기간</h4></span> <span><input
						class="form-control" type="date" id="project_end_date"></span>
				</div>
				<!--  <div>
					<span><h4>후원기간</h4></span>
					<div class="col-md-10 col-md-offset-1">
						<form class="form-horizontal" role="form">
							<div class="funkyradio form-group" id="pay_method">
								<div class="funkyradio-info">
									<input type="radio" name="radio" id="radio5" value="due_date" />
									<label for="radio5">기간 </label>
								</div>

								<div class="funkyradio-info">
									<input type="radio" name="radio" id="radio6"
										value="select_date" /> <label for="radio6">마감일</label>
								</div>
							</div>
						</form>
					</div>
					<div class="btn-group" data-toggle="buttons">
						<span> 						<label class="btn btn-success active">
								기간 : <input type="radio" name="project_term" id="project_end_date_input" autocomplete="off" chacked>
								<span class="glyphicon glyphicon-ok"></span>
							</label> 
				
							<label class="btn btn-danger">
								마감일 : <input type="radio" name="project_term" id="project_end_date_select" >
								<span class="glyphicon glyphicon-ok"></span>
							</label> 						
								<input type="radio" name="project_term" id="project_end_date_input" value="기간">기간
								<input type="radio" name="project_term" id="project_end_date_select" value="마감일">마감일
							<div id="dateArea"></div>
						</span>
					</div>
				</div> -->



				<div>
					<br> <br>
					<button type="button" id="basicInfoRegister"
						class="btn btn-primary pull-right">저장하고 다음으로</button>
				</div>
			</div>

			<div class="col col-md-1"></div>
		</div>
	</div>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</footer>
</html>