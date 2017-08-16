<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/common/jquery.js"></script>
<script src="resources/js/arrTest/arrTest.js"></script>
<title>Insert title here</title>
</head>
<body>
arrTest Page!
<br>
	이름 : <input type="text" id="arrTestVO[1]" value="name[1]">
	번호 : <input type="text" id="arrTestVO[1].phone" value="phone[1]">
<br>
	이름 : <input type="text" id="arrTestVO[2].name" value="name[2]">
	번호 : <input type="text" id="arrTestVO[2].phone" value="phone[2]">
	
<br>

	이름 : <input type="text" id="arrTestVO1.name" value="name1">
	번호 : <input type="text" id="arrTestVO1.phone" value="phone1">
<br>
	이름 : <input type="text" id="arrTestVO2.name" value="name2">
	번호 : <input type="text" id="arrTestVO2.phone" value="phone2">
	
<br>
	<input type="text" id="test1" value="selectorTest">
	
	
	
	<!-- <input type="text" id="arrTestVO[2]" value="selectorTest2"> -->
	
</body> 
</html>