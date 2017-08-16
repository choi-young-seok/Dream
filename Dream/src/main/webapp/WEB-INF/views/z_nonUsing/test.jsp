<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/common/jquery.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
$(function(){
	$('#testvideo').hide();
	
	$('#testimg').click(function(){
		alert("이미지 클릭 이벤트")
		$('#testimg').hide();
		$('#testvideo').show();
	});//testimg click event
	
});//ready

</script>
</head>
<body>
<img src="resources/img/test.jpg" id="testimg">

<embed id="testvideo" width="640" height="360" src="http://www.youtube.com/v/Z3RbKW4uKgI" 
					type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed>

</body>
</html>