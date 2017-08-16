<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/common/bootstrap.min.js"></script>

<link href="resources/css/common/commonStyle.css" rel="stylesheet">

<script src="resources/js/common/jquery.js"></script>
<script src="resources/js/address/address_Pop.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>주소찾기</title>
</head>
<body>
	<div class="container">
		<div class="boxSpace">
			<table align="center">
				<tbody>
					<tr>
						<th>주소 : </th>
						<td><input id="search_address" type='text' size='35'><button class="btn btn-primary" onclick="test(aa,bb)">검색</button> </td>
					</tr>
		
					<tr> 
						<th></th>
						<td>
							<div id="data_count"></div>
							<div id="search_result"></div>
						</td>
					</tr> 
					
					<tr>
						<th></th>
						<td></td>
					</tr>
		
					<tr>
						<th></th>
						<td></td>
					</tr>
		
					<tr>
						<th></th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="text-center">
			<ul id="paginationReuslt" class="pagination"></ul>
		</div>
	</div>
</body>
</html>