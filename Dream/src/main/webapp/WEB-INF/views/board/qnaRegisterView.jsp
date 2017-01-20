<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- aside 고정 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<!-- qna.js -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<script type="text/javascript" src="resources/js/board/qna.js"></script>

<style>
.fileDrop {
  width: 80%;
  height: 100px;
  border: 1px dotted gray;
  background-color: lightslategrey;
  margin: auto;
  
}
</style>
<header> 
	<%@include file="../mainView/header.jsp" %>
</header>

<div class="container">
	<div class="row content">
		<aside>
			<%@include file="../mainView/boardSidebar.jsp" %>
		</aside>
		
		<div class='box col-sm-9' style="padding-top: 60px;">
		<!-- Main content -->
			<section class="content">
				<div class="row">
						<!-- left column -->
					<div class="col-md-12">
						<!-- general form elements -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">문의 사항</h3>
							</div>
							<!-- /.box-header -->
						
							<form id='registerForm' role="form" method="post">
								<div class="box-body">
									<div class="form-group">
										<label>제목</label> 
										<input type="text" id='qna_title' class="form-control">
									</div>
									<div class="form-group">
										<label>내용</label>
										<textarea class="form-control" id="qna_content" rows="25"></textarea>
									</div>
									<div class="form-group">
										<label>작성자</label>
										<input type="text" id="member_name" class="form-control" value="${session.member_name}" readonly="readonly">
										<input type="hidden" id="member_mail" value="${session.member_mail }">
									</div>
								</div>
							<!-- /.box-body -->
							
								<div class="box-footer">
									<div>
										<hr>
									</div>
									<!-- <a id="qnaRegister" class="btn btn-primary pull-right">문의하기</a> -->
									<a id="qnaRegister">문의하기</a>
								</div>
							</form>
						
						</div>
						<!-- /.box -->
					</div>
					<!--/.col (left) -->
				
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
	</div>
</div>


 
