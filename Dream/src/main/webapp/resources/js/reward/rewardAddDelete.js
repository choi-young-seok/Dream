$(function() {

	var reward_count =0;
	addItem();

	//ㅡㅡㅡㅡㅡ 리워드 박스 추가 이벤트 ㅡㅡㅡㅡㅡ
	$("#addItem").click(function(){
		addItem();
	});//addItem click event
	
	//ㅡㅡㅡㅡㅡ 리워드 박스 추가 함수 ㅡㅡㅡㅡㅡ
	function addItem() {
		
	reward_count++;
	$("#reward_count").val(reward_count);

	var newDiv = document.createElement("div"); //<div></div>
	newDiv.setAttribute('id', 'item_' + reward_count); //<div id="item_1"></div>

	newDiv.innerHTML = //'<center>'

			"<h1>리워즈"+reward_count+"</h1>"
		+ '<label for="name">제목:</label>'
		+ '<input type="text" id="reward_title['+reward_count+']" value="title['+reward_count+']"><br>'
		+ '<label for="name">아이템s:</label>'
		+ '<input type="text" id="reward_items['+reward_count+']" value="items['+reward_count+']"><br>'
		+ '<label for="name">배송예정일:</label>'
		+ '<input type="date" id="reward_delivery_date['+reward_count+']"><br>'
		+ '<label for="name">한정수량:</label>'
		+ '<input type="text" id="reward_limited_count['+reward_count+']" value="amount'+reward_count+'"><br>'
		+ '<label for="name">서약금액:</label>'
		+ '<input type="text" id="reward_amount['+reward_count+']" value="re_money'+reward_count+'"><br>'
		+ '<label for="name">리워드 번호:</label>'
		+ '리워드 번호 : <input type="text" id="reward_no['+reward_count+']" value="'+reward_count+'"><br>'
		+ '<button type="button" id="removeBtn'+reward_count+'" onclick="removeItem(' + reward_count+')" >삭제</button>';
//		+ '<button type="button" id="removeBtn'+reward_count+'" >삭제</button>';

	var itemList = document.getElementById('itemList');
	itemList.appendChild(newDiv);

	}//end addItem

//ㅡㅡㅡㅡㅡ 리워드 박스 삭제 및 재정렬 함수 ㅡㅡㅡㅡㅡ
function removeItem(reward_no) {
	//alert("현재 선택된 reward번호 : "+reward_no)
	var delDiv = document.getElementById('item_' + reward_no);
	delDiv.parentNode.removeChild(delDiv);

	var reward_box_count = $("#reward_count").val();
	
	// var reward_title = $("#reward_title").val()
	// alert("현재 리워드 번호 : "+reward_no)
	// alert("총 리워드 갯수 : "+reward_count)
	var next_reward_no = reward_no+1;
	// alert("다음 리워드 번호 : "+next_reward_no)
	
	if(reward_no === reward_count){
		//alert("마지막 리워드 박스 삭제!!")
		reward_count = reward_box_count-1;
		$("#reward_count").val(reward_count);
		return;
	}//end if
		
	for(var i = next_reward_no ; i <=reward_count ; i++){	
		//alert("변경되는 item 번호 : item_"+i);
		$("#item_"+i).attr("id","item_"+(i-1));
		
	    $("#reward_title"+i).attr("id", "reward_title["+(i-1)+"]");
	    $("#reward_title"+(i-1)).val("title"+(i-1))

	    $("#reward_items"+i).attr("id", "reward_items["+(i-1)+"]");
	    $("#reward_items"+(i-1)).val("reward_items"+(i-1))

	    $("#reward_delivery_date"+i).attr("id", "reward_delivery_date["+(i-1)+"]");
	    //$("#reward_delivery_date"+(i-1)).val("reward_delivery_date"+(i-1))

	    $("#reward_limited_count"+i).attr("id", "reward_limited_count["+(i-1)+"]");
	    $("#reward_limited_count"+(i-1)).val("reward_limited_count"+(i-1))

	    $("#reward_amount"+i).attr("id", "reward_amount["+(i-1)+"]");
	    $("#reward_amount"+(i-1)).val("reward_amount"+(i-1))

	    $("#reward_no"+i).attr("id","reward_no["+(i-1)+"]");
	    $("#reward_no"+(i-1)).val(i-1) 
	    
	    $("#removeBtn"+i).attr("id","removeBtn"+(i-1))
	    $("#removeBtn"+(i-1)).attr("onclick","removeItem("+(i-1)+")")
	    //alert("변경된 reward_no : "+$("#reward_no"+(i-1)).val())
	}//end for
	
	reward_count = reward_box_count-1;
	$("#reward_count").val(reward_count);
}//end removeItem

});