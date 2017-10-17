<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>결제하기</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">
<header> <%@include file="../mainView/header.jsp"%>
</header>
<html>
	<body>
		<div class="wrap">
			<div class="container">
				<div class="col col-md-12" id="textArea">
				<h1 class="page-header" param="support_view" id="request">결제하기</h1>
					<div class="col col-md-1"></div>
					
					<div class="col col-md-10">
						<%@include file="../jsp_piece/support/supportView_pay_insert_area.jsp"%>
						<div class="boxSpace">
							<h2>결제금액 : <b>${support_amount }원</b></h2>
							<input type="hidden" id="support_amount" value="${support_amount }">
						</div>
						
								<div class="pull-right">
									<button id="payBtn" title="${rewards.total_reward_no}"
										class="btn btn-warning" param="${rewards.total_reward_no}">후원하기</button>
								</div>
					</div>
					
					
					<div class="col col-md-1"></div>
				</div>
			</div>
		</div>
	</body>
</html>

<footer> <%@include file="../mainView/footer.jsp"%>
</footer>

<script type="text/javascript" src="resources/js/support/supportViewSetting.js"></script>
<script type="text/javascript" src="resources/js/support/support_noReward.js"></script>