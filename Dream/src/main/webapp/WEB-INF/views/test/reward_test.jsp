<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<header> <%@include file="../mainView/header.jsp"%>
</header>
<body>
					<div class="col col-md-4">
						<div id="reward_info_area"  style="position: fixed;" >리워드 출력 영역7</div>
 						<%@include file="../jsp_piece/reward/supportView_reward_info.jsp"%>
						<%-- <%@include file="../jsp_piece/reward/reward_test.jsp"%> --%>
					</div>
					<div class="col col-md-8">
						<div id="address_list"></div>
						<%@include file="../jsp_piece/address/address_info_area.jsp"%>
					</div>
</body>
</html>

<script type="text/javascript" src="resources/js/reward/reqesut_reward.js"></script>
<script type="text/javascript" src="resources/js/address/address_Pop.js"></script>
<script type="text/javascript" src="resources/js/address/insert_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/event_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/address/request_memberAddress.js"></script>
<script type="text/javascript" src="resources/js/validityCheck/address_value_check.js"></script>
