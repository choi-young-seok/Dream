<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script> -->
	<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="/dream/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/js/project/projectRegister.js"></script>
<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>

<script type="text/javascript">
	$(function() {
		//전역변수
		var obj = [];
		//스마트에디터 프레임생성
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : obj,
			elPlaceHolder : "editor",
			sSkinURI : "/dream/resources/smarteditor/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});
		//전송버튼
		$("#savebutton").click(function() {
			//id가 editor인 textarea에 에디터에서 대입
			var editor = $('#editor').val();
			obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
			//폼 submit
			$("#frm").submit();
		})
	})
</script>
<title>스토리 정보 등록</title>
</head>
<header> 
	<%@include file="../../mainView/header.jsp" %>
</header>
<article>
	<%@include file="projectTabList.jsp" %>
</article>
<body>
	<div class="col-md-12">
		<div class="container">
			<div class="row">
				<div class="col col-md-2"></div>				
				<div class="col col-md-10">
					<div class="boxSpace" style="width: 766px;">
						<span><h4>프로젝트 소개영상</h4>
							<input type="radio" id="video_upload" name="project_video_type">직업 업로드
							<input type="radio" id="youtube" name="project_video_type">유투브 주소
							
						</span>
					</div>
				
					<form action="/dream/projectProfileView" method="post" id="frm">
						1111<input type="text" value="${project_no}" name="project_no">1111+${project_no}
						<span><div class="thumbnailImage" name="project_video" title="project_video" id="imageZone" style="width: 760px;"></div></span>
						<div id="youtube_address"></div>
						<textarea name="project_content" id="editor" rows="10" cols="100"
							style="width: 766px; height: 412px;"></textarea>
						<input type="button" id="savebutton" value="다음" />
					</form>
					

				</div>
		</div>
		</div>
	</div>
</body>
<footer> 
	<%@include file="../../mainView/footer.jsp" %>
</footer>
</html>