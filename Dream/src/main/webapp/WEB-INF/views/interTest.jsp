<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#postTest').click(function(){
		$.ajax({
			url :"/dream/doA",
			type:'post',
			success:function(){
				
			}
		});//ajax
	});//postTest click event
	
	$('#postTest2').click(function(){
		$.ajax({
			url :"/dream/doA",
			type:'post',
			success:function(){
				
			}
		});//ajax
	});//click event
});//ready
</script>
</head>
<header>
<%@include file="../views/mainView/header.jsp" %>
</header>
<body>
	인터셉터 테스트
	<a id="postTest" href="/dream/doA">ajax테스트</a>
	<button id="postTest2">ajax테스트2</button>
<!-- 	<form action="/dream/doA" method="post">
		<button type="submit">post테스트</button>
	</form> -->
	${msg}
</body>
</html>