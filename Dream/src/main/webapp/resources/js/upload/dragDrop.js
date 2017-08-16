$(function(){
	
	$("#imageZone").on("dragenter dragover", function(event) {
		//imageZone 영역에 dragenter or dragover 이벤트 발생시
		//dragenter = id="fileDrop"인 영역에 들어왔을때
		//dragover =  id="fileDrop"인 영역 위에 올라왔을경우
		
		event.preventDefault();
		//event.preventDefault(); = 브라우저의 동작 방지
	});
	
	$("#imageZone").on("drop",function(event) {
		//imageZone 영역에 drop 이벤트 발생시

				var requestName = event.target.title;
				alert(requestName)
				event.preventDefault();
				//event.preventDefault(); = 브라우저의 동작 방지
				
				var files = event.originalEvent.dataTransfer.files;
				// 해당 영역에 전달된 파일 데이터를 수신
				// jquery를 이용한 이벤트 처리의 경우
				// DOM객체에 대한 처리를 동반하기 위해 event.originalEvent객체를 이용
	
				var file = files[0];
				//다중 파일의 drop 이벤트 발생의 경우 첫번째 drop된 파일만 저장
				//첫번째 파일만 변수화 하는 이유는
				//여러개의 동시 파일을 drop할때 한가지 파일만 수신하기 위해서
				//2개 이상의 파일을 drop할때 첫번째 데이터만 수신가능함
				//결론 : 다중 drop이벤트적용이 불가
	
				var formData = new FormData();
				//FormData 는 HTML5 에서 제공되는 객체이다.
				//기존 <Form> 엘리먼트같은 역활로서 사용할 수 있다.
				//ex)var formData = new FormData();
	
				formData.append("file", file);
				//formData.append('file',file); : key='file', value=업로드 파일객체
				//컨트롤러에 formData(file객체)전달
				$.ajax({
					url : '/dream/uploadAjax/'+requestName, 
					data : formData,
					dataType : 'text',
					processData : false,
					contentType : false,
					type : 'POST',
					success : function(data) {
						alert("upload 파일"+data)
						var str = "";
	
						if (checkImageType(data)) {
							str = "<div>"
							// +"<a
							// href=displayFile?fileName="+getImageLink(data)+">"
							// displayFile()요청부
							+ "<img src='displayFile?fileName=" + data + "'/>"
							// +"</a>"
							+ "<small data-src=" + data + ">X</small>" + "</div>";
							if(requestName == 'project_thumbnail'){
								str += "<input id='project_thumbnail' type='text' value="+data+">";
							}else if(requestName == 'member_profile'){
								str += "<input id='member_profile' type='text' value="+data+">";								
							}else if(requestName == 'register_profile'){
								str += "<input id='register_profile' type='text' name='project_video' value="+data+">";								
							}else{
								alert("div태그 title 정보 없음 : "+requestName)
							}
						} else {
							str = "<div><a href='displayFile?fileName=" + data
									+ "'>" + getOriginalName(data) + "</a>"
									+ "<small data-src=" + data
									+ ">X</small></div></div>"
									+"<input type='text' id='project_video' name='project_video' value='"+data+"'>"
						}
	
						$("#imageZone").append(str);
					}
				});
			});
	
	$("#imageZone").on("click", "small", function(event) {
		//뿌려진 이미지 데이터에 대한 click이벤트
		var that = $(this);
		var requestName = event.target.title;
		alert("requestName ??: "+requestName )
		//해당 파일 삭제 요청
		$.ajax({
			url : "/dream/deleteFile",
			type : "post",
			data : {
				fileName : $(this).attr("data-src")
			},
			dataType : "text",
			success : function(result) {
				if (result == 'deleted') {
					that.parent("div").remove();
					//해당 파일 삭제
					$("#project_thumbnail").remove();
					$("#project_video").remove();
					
				}
			}
		});
	});
	
	function getOriginalName(fileName) {
		if (checkImageType(fileName)) {
			return;
		}
	
		var idx = fileName.indexOf("_") + 1;
	
		return fileName.substr(idx);
	
	}
	
	function getImageLink(fileName) {
	
		if (!checkImageType(fileName)) {
			return;
		}
		var front = fileName.substr(0, 12);
		// /년/월/일 경로 추출
		var end = fileName.substr(14);
		// 파일명 앞 's_'를 제거
	
		return front + end;
	
	}
	
	function checkImageType(fileName) {
	
		var pattern = /jpg|gif|png|jpeg/i;
	
		return fileName.match(pattern);
	
	}

});//ready