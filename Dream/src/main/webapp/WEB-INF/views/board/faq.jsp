<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<header> 
<%-- 	<%@include file="../views/mainView/header.jsp" %> --%>
	<%@include file="../mainView/header.jsp" %>
</header>
<body>
<div class="container">
  <div class="row content">
    <div class="col-sm-3 sidenav" style="background-color: white">
      <h4>고객센터</h4>
      <ul class="nav nav-pills nav-stacked" >
        <li class="active"><a href="#section1">공지사항</a></li>
        <li><a href="#section2">자주 묻는 질문 (FAQ)</a></li>
        <li><a href="#section3">문의 사항 (QNA)</a></li>
      </ul><br>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="검색어를 입력하세요">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

	<div class='box col-sm-9'>
				<div class="box-header with-border">
					<h3 class="box-title">Board List</h3>
				</div>

				<div class='box-body'>

					<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							Title</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							Content</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							Writer</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							Title OR Content</option>
						<option value="cw"
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							Content OR Writer</option>
						<option value="tcw"
							<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							Title OR Content OR Writer</option>
					</select> 
					<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
					<button id='searchBtn'>Search</button>
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
					<button id='newBtn'>New Board</button>

				</div>
			</div>
			
    <div class="col-sm-9 box" style="background-color: white">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>

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

				</div>
				<!-- /.box-footer-->
			</div>
  </div>
</div>
</body>
<footer><%@include file="../mainView/footer.jsp" %></footer>
</html>