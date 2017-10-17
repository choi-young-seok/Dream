<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${search_keyword } : 검색결과</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<style type="text/css">
.row {
	margin-top: 25px;
	margin-bottom: 25px;
}
</style>
</head>
<header> <%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
<%@include file="../mainView/header.jsp"%> </header>
<body>
	<div class="wrap">
		<!-- Page Content -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-11">
							<legend><b>${search_keyword }</b> : 프로젝트 타이틀 검색결과 <b><span id="title_search_count_area"></span></b></legend>
						</div>
						<div id="project_title_result"></div>
					</div>
					
					<div class="row">
						<div class="col-md-11">
							<legend><b>${search_keyword }</b> : 프로젝트 카테고리 검색결과 <b><span id="category_search_count"></span></b></legend>
						</div>
						<div id="project_category_result"></div>
					</div>
					<input type="hidden" id="search_keyword" value="${search_keyword }">
				</div>
			</div>
		</div>
	</div><script type="text/javascript" src="resources/js/header/project_search.js"></script>
</body>
</html>
<%@include file="../jsp_piece/main/project_point_info.jsp"%>
<script type="text/javascript" src="resources/js/mainBody/project_search_result.js"></script>