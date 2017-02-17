<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>

<title>리워드 정보 등록</title>
<script type="text/javascript">
$(function(){

 	var i = 0;
    addReward();
    
    function addReward(){
    
		i++;
		var rewardBox = "";
		rewardBox = +i
				+ "<br><div class='boxSpace' id='rewardList"+i+"'>"
				+ "<a id='deleteRewardBox"+i+"'>삭제</a><br>" 
				+ "<h6>리워드"
				+ i
				+ "</h6>"
				+ "<div>제목 :<input type='text' id='reward_title"+i+"'></div>"
				+ "<div>아이템 :<input type='text' id='reward_items"+i+"'></div>"
				+ "<div>배송예정일 :<input type='date' id='reward_delivery_date"+i+"'></div>"
				+ "<div>한정수량 :<input type='number' id='reward_limited_count"+i+"'></div>"
				+ "<div>서약금액 :<input type='text' id='reward_amount"+i+"'></div>"
				+ "</div>";

		$("#rewardArea").append(rewardBox);
	}

		$("#addRewardBox").click(function() {
			addReward();
		});//

		$("#deleteRewardBox"+i).click(function() {
			alert(i);
			$(this).parent().remove();
			//$("#rewardList"+i).remove();
		});//
	});//ready
</script>
<header> 
	<%@include file="../../mainView/header.jsp" %>
</header>
<article>
	<%@include file="projectTabList.jsp" %>
</article>
</head>
<body>
	<div class="container">
		<div class="col col-md-12">
			<div class="col col-md-2"></div>
			<div class="col col-md-8">
				<h1>프로젝트 리워드 정보 등록</h1>
				
				<div id="rewardArea"></div>
				<a id="addRewardBox">추가</button>
				<button type="button" id="rewardInfoRegister" class="btn btn-primary pull-right">저장하고 다음으로</button>
			</div>
			<div class="col col-md-2"></div>
		</div>
	</div>
</body>
<footer> 
	<%@include file="../../mainView/footer.jsp" %>
</footer>
</html>