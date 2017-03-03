<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>
<script src="resources/js/reward/rewardRegister.js"></script>

<title>리워드 정보 등록</title>
<script type="text/javascript">
$(function() {
	$('#rewardOk').click(function() {
		if ($('#re_money').val() == "") {
			alert('서약금액을 입력하세요');
			$('#re_money').focus();
			return false;
		}  else if ($('#title').val() == "") {
			alert('리워드 타이틀을 입력하세요');
			$('#title').focus();
			return false;
		} else if ($('#item').val() == "") {
			alert('리워드 아이템을 입력하세요');
			$('#item').focus();
			return false;
		} else if ($('#duedate').val() == "") {
			alert('배송 예정일을 입력하세요');
			$('#duedate').focus();
			return false;
		} else if ($('#amount').val() == "") {
			alert('리워드 한정수량을 입력하세요');
			$('#amount').focus();
			return false;
		} 
		nextStep();
	});//click event
});

	var reward_count =0;
	//var i = 0;
	var deleteList = [];
	
	function addItem() {
		
		reward_count++;
		$("#reward_count").val(reward_count);
		
		var newDiv = document.createElement("div"); //<div></div>
		newDiv.setAttribute('id', 'item_' + reward_count); //<div id="item_1"></div>

		newDiv.innerHTML = '<center>'

		/* 		+ '<h1>리워즈</h1>' */
				+ '<fieldset>'

				+ '<label for="name">제목:</label>'
				+ '<input type="text" id="reward_title'+reward_count+'" value="title'+reward_count+'"><br>'
				/* + '<label for="name">아이템:</label>'
				+ '<input type="text" id="reward_items" name="item'+reward_count+'"><br>'
				+ '<label for="name">배송예정일:</label>'
				+ '<input type="date" id="reward_delivery_date" name="duedate'+reward_count+'"><br>'
				+ '<label for="name">한정수량:</label>'
				+ '<input type="text" id="reward_limited_count" name="amount'+reward_count+'"><br>'
				+ '<label for="name">서약금액:</label>'
				+ '<input type="text" id="reward_amount" name="re_money'+reward_count+'"><br>' */
				+ '<label for="name">리워드 번호:</label>'
				+ '<input type="text" id="reward_no'+reward_count+'" value="'+reward_count+'"><br>'
				+ '<button type="button" onclick="removeItem(' + reward_count
				+ ')" style="right:200px; width: 100px; onclick=removeItem('
				+ reward_count + ')">삭제</button></fieldset>'

				+ '</center>';

		var itemList = document.getElementById('itemList');
		itemList.appendChild(newDiv);
	
		//생성된 rewardBox의 갯수를 input type에 저장
		

	}
	function removeItem(reward_no) {
		var delDiv = document.getElementById('item_' + reward_no);
		delDiv.parentNode.removeChild(delDiv);

		var reward_box_count = $("#reward_count").val();

		reward_count = reward_box_count-1;
		$("#reward_count").val(reward_count);
		
		
		//deleteList[i] = reward_no;
		//i++;
		
		//중간 
//			var reward_title = $("#reward_title").val()
			alert("현재 리워드 번호 : "+reward_no)
			alert("총 리워드 갯수 : "+reward_count)
			var next_reward_no = reward_no+1;
			alert("다음 리워드 번호 : "+next_reward_no)
			alert("땡길 번호: "+next_reward_no-1)
			alert("땡길 번호2: "+next_reward_no-2)
			alert("땡길 번호2: "+next_reward_no-3)
		for(var i = next_reward_no ; i <=reward_count ; i++){
		    $("#reward_title"+i).attr("id", "reward_title"+);
		    $("#reward_no"+i).val(reward_count-1)
		    $("#reward_no"+i).attr("id","reward_no"+i-1);
		}
		//부모노드.removeChild(삭제할 자식노드);
		//var itemList = document.getElementById('itemList');
		// itemList.removeChild(delNode);
	}
	function nextStep() {

		document.reward.reward_count.value = reward_count;
		document.reward.deleteList.value = deleteList;

		document.reward.submit();
	}
	window.onload = function() {
		addItem();
	}
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
				
				<form name="reward" method="post">
					<div id="itemList"></div>
					<br><br>
					<input type="button" value="추가" onclick="addItem()"> 
					생성된 리워드 총 갯수 : <input type="text" id="reward_count" name="reward_count"> 
					<input type="hidden" value="" name="deleteList"> 
				</form>
				<center>
					<input id="re_Array" type="button" value="확인">
				</center>
				<div id="rewardArea"></div>
			<!-- 	<a id="addRewardBox">추가</button> -->
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