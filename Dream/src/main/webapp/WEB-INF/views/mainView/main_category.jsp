<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dream Up</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<style type="text/css">
.mainTest {
	background-color: white;
	border-radius: 30px;
}

.mainTest:hover {
	background-color: lightgray;
}

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
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>프로젝트 카테고리</h1>

					<div class="row">
						<div class="col-sm-12 col-lg-12 col-md-12" align="left">
							<div align="center" id="category_list">

								<c:forEach items="${project_category }" var="project_category">
									<div class="col-sm-3 col-lg-3 col-md-3"
										title="${project_category.project_category }">
										<div class="thumbnail mainTest boxSpace" style="font-size: x-large;">${project_category.project_category }
											(${project_category.category_count })</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-sm-12" align="left">
							<div id="project_category_title"></div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
<header> <%@include file="../mainView/footer.jsp"%>
</body>
</html>
</header>

<script type="text/javascript"
	src="resources/js/mainBody/main_category.js"></script>
<%@include file="../jsp_piece/main/feature_category_project.jsp"%>
<%@include file="../jsp_piece/main/project_point_info.jsp"%>