<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<!-- supportRegister.js -->
<script type="text/javascript" src="resources/js/support/supportView.js"></script>
<title>Insert title here</title>

</head>
<header><%@include file="../mainView/header.jsp"%> </header>
<body>
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-2" style="background-color: orange;"></div>
			<div class="col col-md-8">
				<div class="boxSpace">
					<h1>후원하기
				</div> 
				<div class="boxSpace">
				<img src="resources/member/thumbnail/${project.project_thumbnail}">
					${project.project_no }
					${project.project_title }
					<input type="text" id="project_no" value="${project.project_no}">
				</div>
				
				<div class="boxSpace">
					후원 금액 : <input type="text" id="support_input_amount">
					<input type="button" id="support_project_input" title="input" value="후원하기" class="btn btn-warning">
				</div>
				<c:forEach items="${rewards}" var="rewards">
					<div id="reward_List" class="boxSpace">
						<div class="row" title="test" >
					
							<form class="form-horizontal" role="form">
							    <!-- Form Name -->
							    <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%> 
							    <legend align="center">${rewards.reward_no }번 리워드</legend>
							
							    <!-- Text input-->
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">리워드 번호 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_no}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">리워드 제목 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_title}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">리워드 품목 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_items}</label>
							    </div> 
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">배송 예정일 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_delivery_date}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">한정 수량 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_limited_count}</label>
							    </div>
							    <div class="form-group">
						      		<label class="col-sm-5 control-label" for="textinput">가격 : </label>
						      		<label class="col-sm-3 control-label" for="textinput">${rewards.reward_amount}</label>
									<input type="hidden" id="support_amount" value="${rewards.reward_amount }">
							    </div>
							</form>
							
							<input type="hidden" id="support_amount" value="${rewards.reward_amount }">
							<div class="col-sm-offset-2 col-sm-10" title="supportBtn">
								<div class="pull-right">
					      			<button id="support_project_choice" title="${rewards.total_reward_no}" class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
								</div>
							</div>
							 
						</div><!-- /.row --> 
					</div>
				</c:forEach>
			</div>
			<div class="col col-md-2" style="background-color: orange;"></div>
		</div>
	</div>
</body>   
<footer> 
	<%@include file="../mainView/footer.jsp" %>
</footer>
</html>