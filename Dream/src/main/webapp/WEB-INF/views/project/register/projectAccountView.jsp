<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>



<title>프로젝트 계좌 정보 등록</title>

<article>
	<%@include file="projectTabList.jsp" %>
</article>
</head>
<body>
<div class="wrap">
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-1"></div>
			<div class="col col-md-10">
			<legend>
				<h2>프로젝트 계좌 정보 등록</h2>
							</legend>
				
				 <div class="boxSpace">
					<span><h4 align="center">이용약관 동의</h4></span> <span><div id="imageZone" class="thumbnailImage" title="project_thumbnail">이용 약관 소개</div></span>
					<div class="pull-right">
						<input type="radio" id="access_terms_agree" name="access_terms_agree" value="T">동의
						<input type="radio" id="access_terms_agree" name="access_terms_agree" value="F">동의 않함
					</div>
				</div>
				
<!-- 				<div class="boxSpace">
					<span><h4 align="center">등록자 주소</h4></span>
					<span><input class="form-control" type="text" id="register_address"></span>
				</div>ㅇㅇ
				 -->
				
	

<!-- 				<div class="boxSpace">
					<span><h4 align="center">은행</h4></span>
					<span><select id="account_bank_list">
						<option>----</option>
						<option>신한</option>
						<option>농협</option>
						<option>우체국</option>
						<option>국민</option>
						<option>새마을</option>
						<option>기업</option>
					</select></span>	  				
					<span><h4 align="center">프로젝트 계좌번호</h4></span>
					<span><input class="form-control" type="text" id="project_account"></span>
				</div> -->
				
				<div id="numSector_payback_account" class="boxSpace">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<form class="form-horizontal" role="form">

							<!-- Form Name -->
							<legend>계좌 정보 입력</legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-3 control-label" for="textinput">은행
									: </label>
								<div class="col-sm-9">
									<select id="account_bank_list">
										<option>----</option>
										<option>신한</option>
										<option>농협</option>
										<option>하나</option>
										<option>조흥</option>
										<option>국민</option>
										<option>우리</option>
										<option>신협</option>
										<option>우체국</option>
										<option>새마을</option>
									</select>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-3 control-label" for="textinput">계좌번호
									:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="project_account"
										placeholder="숫자만 입력하세요">
								</div>
							</div>
						</form>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>

				 <button type="button" id="accountInfoRegister" class="btn btn-primary pull-right">저장하고 다음으로</button>
			</div>

			<div class="col col-md-1"></div>
		</div>
	</div>
	</div>
</body>
<footer> 
	<%@include file="../../mainView/footer.jsp" %>
</footer>
</html>