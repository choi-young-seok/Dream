<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript"
	src="/dream/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript"
	src="resources/js/project/projectRegister.js"></script>

<script type="text/javascript" src="resources/js/upload/dragDrop.js"></script>
<script type="text/javascript" src="resources/js/upload/upload.js"></script>
<script type="text/javascript"
	src="resources/js/project/event_projectStoryView.js"></script>

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
			//var editor = $('#editor').val();
			if ($("#project_video").val() == "") {
				alert("프로젝트 소개 동영상을 등록하세요")
				return;
			}
			obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
			//폼 submit
			$("#frm").submit();
		})
	})
</script>
<title>스토리 정보 등록</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<article> <%@include file="projectTabList.jsp"%>
</article>
</head>

<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12">
				<div class="row">
					<div class="col col-md-2"></div>
					<div class="col col-md-10">
						<div style="width: 766px;">
							<legend>
								<h2>프로젝트 스토리 정보</h2>
							</legend>

							<ul id="video_tabs" class="nav nav-pills nav-justified"
								role="tablist">
								<li class="active" id="member_video_tab"><a>직접 업로드</a></li>
								<li id="youtube_vedio_tab"><a>유튜브 URL</a></li>
							</ul>
						</div>

						<div id="youtube_url_area"
							style="margin-top: 20px; margin-bottom: 20px">
							<input type="text" id="youtube_url" style="width: 766px"
								placeholder="youtube 동영상 URL을 입력하세요">
						</div>

						<form action="/dream/projectProfileView" method="post" id="frm">


							<!-- 					<form method="post" id="frm"> -->
							<input type="hidden" value="${project_no}" name="project_no">
							<span>
								<div align="center" class="dragSpace thumbnailImage"
									name="project_video" title="project_video" id="imageZone"
									style="width: 766px; margin-top: 20px; margin-bottom: 20px">
									<h6>점선영역에 프로젝트 동영상을 드래그하세요</h6>
								</div> <input type="hidden" id="project_video" name="project_video">
								<input type="hidden" id="project_video_type"
								name="project_video_type"> <input type="hidden"
								name="member_no" value="${session.member_no }">
								<div id="uploaded_file" align="center"
									style="width: 766px; margin-top: 20px; margin-bottom: 20px">
								</div>
							</span>
							<div id="youtube_address"></div>
							<textarea name="project_content" id="editor" rows="10" cols="100"
								style="width: 766px; height: 412px;"></textarea>
							<div class="row" style="width: 783px;">
								<input class="pull-right btn-primary" type="button"
									id="savebutton" value="다음" />
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div id="youtubeVideo_manualModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">유튜브 URL로 동영상 첨부</h4>
				</div>
				<div class="modal-body" align="center">
					1.참조하려는 yoube영상 상단의 <b>공유</b>버튼을 클릭하세요. <img class="modal_img"
						src="resources/img/youtube_modal_1.png"> 2.youtube URL주소를 <b>복사</b>하세요.
					<img class="modal_img" src="resources/img/youtube_modal_2.png">
					3.youtube URL입력란에 복사한 주소를 <B>붙여넣기</B>하세요. <img class="modal_img"
						src="resources/img/youtube_modal_3.png"> 4.복사한 URL의 youtube
					영상이 다음과 같이 로드됩니다. <img class="modal_img"
						src="resources/img/youtube_modal_4.png">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">닫기</button>
				</div>
			</div>

		</div>
	</div>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</footer>
</html>

<script type="text/javascript" src="resources/js/upload/upload.js"></script>

