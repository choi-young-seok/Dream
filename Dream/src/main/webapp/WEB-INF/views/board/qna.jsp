<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- aside 고정 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/dividerStyle.css">

<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>

<title>Insert title here</title>

<script type="text/javascript">
$(function(){
	$('#registerBtn').click(function(){
		location.href = "/dream/qnaRegisterView"
	});//
});//
</script>
</head>

<!-- header -->
<header> 
	<%@include file="../mainView/header.jsp" %>
</header>

<body>
	<div class="container">
	 	<div class="row content">
			<!-- aside -->
			<aside>
				<%@include file="../mainView/boardSidebar.jsp" %>
			</aside>
		
			<div class='box col-sm-9' style="padding-top: 60px;">
			
				<div class="box-header with-border">
					<h3 class="box-title">문의 사항</h3>
				</div>
				<div class='box-body'>
					
					<input type="text" name='keyword' id="keywordInput">
					<button id='searchBtn'>검색</button>
					<!-- select 태그의 option태그가 3항 연산자인 이유 -->
					<!-- 검색 후 상세조회 페이지에 들어갈때 searchType를 물고 들어가며 -->
					<!-- 상세조회 페이지에서 다시 목록 페이지를 요청할때  -->
					<!-- 물고들어간 searchType을 검사하여 selected속성을 적용하기 위함 -->
					<!-- ex) 처음에 목록 페이지 요청시 select option 태그내의 값에 해당하는 searchType는 null이므로 -->
					<!-- <c:out value="${cri.searchType == null?'selected':''}"/>> -->
					<!-- 에 해당되어 selected속성이 적용되므로 	'---'의 값을 가짐 -->
					
					<!-- ex2) title로 검색한 경우 searchType의 값은 title에 mapping하는 't'로 설정되어  -->
					<!-- listSearch를 수행한 결과를 목록 화면에 출력하고  -->
					<!-- listSearchCount를 수행한 결과를 pageMaker객체의 setTotalCount에 파라미터로 넘겨  -->
					<!-- 하단 페이징에 필요한 변수 prev, next, startPage, endPage, totalCount의 값을 설정한다. -->
					<!-- 해당결과는 searchTpye변수가 title에 mapping되는 t의 값으로 설정된 목록이며 -->
					<!-- 해당 목록 중 하나 행에 대한 상세조회를 실시 했을시, searchType을 파라미터로 물고 들어가게되며 -->
					<!-- 상세조회 화면에서 다시 목록 페이지를 요청시 물고 들어간 searchType을 검사하게 되며, -->
					<!-- <c:out value="${cri.searchType eq 't'?'selected':''}"/>> 해당 3항연산자에 걸리게 되어  -->
					<!-- select option 태그의 값이 title인 항목에 selected속성이 적용되므로 'title'의 값을 가짐 -->
					<button id='registerBtn'>글쓰기</button>
					
		    		<div class="col box">

						<div class="box-body" style="margin-top: 30px;">
							<table class="table">
							<thead>
								<tr>
									<th style="width: 50px">번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
		
								<c:forEach items="${list}" var="boardVO">
		
									<tr>
										<td>${boardVO.bno}</td>
										<td><a
											href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page) }&bno=${boardVO.bno}'>
												${boardVO.title} <strong>[ ${boardVO.replycnt} ]</strong></a></td>
										<td>${boardVO.writer}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
												value="${boardVO.regdate}" /></td>
										<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
									</tr>
		
								</c:forEach>
		
							</table>
						</div>
						<!-- /.box-body -->
		
						<div class="box-footer">
		
							<div class="text-center">
								<ul class="pagination">
		
									<c:if test="${pageMaker.prev}">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
									</c:if>
		
									<c:forEach begin="${pageMaker.startPage }"
										end="${pageMaker.endPage }" var="idx">
										<li
											<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
											<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>
		
									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
									</c:if>
		
								</ul>
							</div>
							<!-- /.text-center -->
						</div>
						<!-- /.box-footer-->
					</div>
					<!-- /.col-sm-9 body -->
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.	box col-sm-9 -->
	 	</div>
	 	<!-- /. row content -->
	</div>
	<!-- /.container -->
	
</body>
<!-- footer -->
<footer><%@include file="../mainView/footer.jsp" %></footer>

</html>