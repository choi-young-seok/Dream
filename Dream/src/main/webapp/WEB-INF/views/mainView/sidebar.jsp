<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common/category.css">

<script type="text/javascript" src="resources/js/mainBody/sidebarEffect.js"></script>
</head>
<body>
	<div class="col-md-3 sidebar">
	<div class="container col-md-12 categoryList">
		<p class="lead">마이 페이지</p>
  <div class="list-group">
    
    <ul id="member_info_toggle_title" class="nav nav-pills nav-stacked">
  	  <li class="list-group-item"><b><font size="3" color="gray">회원 정보</font></b><span class="caret"></span></li>
	</ul>
    <ul class="nav nav-pills nav-stacked" id="member_info_toggle_item">
      <li><a class="list-group-item" id="member_Info_View"> - 회원정보 수정</a></li>
      <li><a class="list-group-item" id="password_Info_Edit_View"> - 비밀번호 수정</a></li>
      <li><a class="list-group-item" > - 배송정보 수정</a></li>
      <li><a class="list-group-item" > - 회원 탈퇴</a></li>
      <br>
    </ul>

    <ul id="project_info_toggle_title" class="nav nav-pills nav-stacked">
  	  <li class="list-group-item"><b><font size="3" color="gray">마이 프로젝트</font></b><span class="caret"></span></li>
	</ul>
    <ul class="nav nav-pills nav-stacked" id="project_info_toggle_item">
      <li><a class="list-group-item" > - 등록 중 프로젝트</a></li>
      <li><a class="list-group-item"  id="processing_project_list"> - 진행 중 프로젝트</a></li>
      <li><a class="list-group-item" > - 만료 프로젝트</a></li>
      <li><a class="list-group-item" > - 완료 프로젝트</a></li>
      <br>
    </ul>

    <ul id="support_info_toggle_title" class="nav nav-pills nav-stacked">
  	  <li class="list-group-item"><b><font size="3" color="gray">후원 프로젝트</font></b><span class="caret"></span></li>
	</ul>
    <ul class="nav nav-pills nav-stacked" id="support_info_toggle_item">
      <li><a class="list-group-item" > - 후원 완료 프로젝트</a></li>
      <li><a class="list-group-item" > - 환불 프로젝트</a></li>
      <br> 
    </ul>

    <ul id="delivery_info_toggle_title" class="nav nav-pills nav-stacked">
  	  <li class="list-group-item"><b><font size="3" color="gray">배송 조회</font></b><span class="caret"></span></li>
	</ul>
    <ul class="nav nav-pills nav-stacked" id="delivery_info_toggle_item">
      <li><a class="list-group-item" > - 배송 예정 조회</a></li>
      <li><a class="list-group-item" > - 배송 중 조회</a></li>
      <li><a class="list-group-item" > - 배송 완료 조회</a></li>
      <br>
    </ul>

    <ul id="pay_info_toggle_title" class="nav nav-pills nav-stacked">
  	  <li class="list-group-item"><b><font size="3" color="gray">결제 내역</font></b><span class="caret"></span></li>
	</ul>
    <ul class="nav nav-pills nav-stacked" id="pay_info_toggle_item">
      <li><a class="list-group-item" > - 결제 내역</a></li>
      <li><a class="list-group-item" > - 환불 내역</a></li>
      <br>
    </ul>
		</div>
	</div>
	</div>
</body>