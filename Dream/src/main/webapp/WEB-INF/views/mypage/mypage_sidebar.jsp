<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="resources/css/mypage/side_menu.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/common/tabList.css">
<div class="col-md-3"> 
	<div class="row">
		<!-- uncomment code for absolute positioning tweek see top comment in css -->
		<!-- <div class="absolute-wrapper"> </div> -->
		<!-- Menu -->
		<div class="side-menu">

			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<div class="brand-wrapper">
					<!-- Hamburger -->
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<!-- Brand -->
					<div class="brand-name-wrapper">
						<a class="navbar-brand" href="" id="mypage_main_side"> 마이페이지 </a>
					</div>
				</div>
	
			</div>

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">
					<!-- Dropdown-->
					<li class="panel panel-default" id="dropdown">
						<a data-toggle="collapse" href="#dropdown-lvl1"> 
							<span class="glyphicon glyphicon-user"></span>회원 정보
							<span class="caret"></span>
						</a> <!-- Dropdown level 1 -->
						
						<div id="dropdown-lvl1" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li><a href="#" id="member_info_side"><span class="glyphicon glyphicon-user"></span>회원 정보</a></li>
									<li><a href="#" id="password_info_edit_side"><span class="glyphicon glyphicon-lock"></span>비밀번호 수정</a></li>
									<li><a href="#" id="member_withdraw_side">회원 탈퇴</a></li>
								</ul>
							</div>
						</div>
					</li>
					
					<li class="panel panel-default" id="dropdown">
						<a data-toggle="collapse" href="#dropdown-lvl2"> 
							<span class="glyphicon glyphicon-list-alt"></span>마이 프로젝트
							<span class="caret"></span>
						</a> <!-- Dropdown level 1 -->
						
						<div id="dropdown-lvl2" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li><a href="#" id="processing_project_list_side"><span class="glyphicon glyphicon-user"></span>진행 프로젝트</a></li>
									<li><a href="#" id="last_project_side"><span class="glyphicon glyphicon-lock"></span>지난 프로젝트</a></li>
									<li><a href="#" id="during_registration_side">등록중 프로젝트</a></li>
								</ul>
							</div>
						</div>
					</li>

					<li><a href="#" id="support_info_side"><span class="glyphicon glyphicon-gift"></span>후원 내역</a></li>
					<li><a href="#" id="address_info_side"><span class="glyphicon glyphicon-home"></span> 배송 주소</a></li>
					<li><a href="#" id="interest_project_side"><span class="glyphicon glyphicon-heart"></span> 관심 프로젝트</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse --> </nav>

		</div>
	</div>
</div>

<script type="text/javascript" src="resources/js/mypage/mypage_side_forward.js"></script>
<script type="text/javascript" src="resources/js/mypage/member.js"></script>