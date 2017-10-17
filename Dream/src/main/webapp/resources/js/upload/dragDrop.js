$(function(){
	
	$("#imageZone").on("dragenter dragover", function(event) {
		//imageZone 영역에 dragenter or dragover 이벤트 발생시
		//dragenter = id="fileDrop"인 영역에 들어왔을때
		//dragover =  id="fileDrop"인 영역 위에 올라왔을경우
		event.preventDefault();
		//event.preventDefault(); = 브라우저의 동작 방지
	});
	
	//imageZone 영역에 drop 이벤트 발생시
	$("#imageZone").on("drop",function(event) {
		var requestName = event.target.title;
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		var file = files[0];
		var formData = new FormData();
		formData.append("file", file);
		
		$.ajax({
			url : '/dream/uploadAjax/'+requestName, 
			data : formData,
			dataType : 'text',
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				var str = "";

				if (checkImageType(data)) {
					str = "<div id='file_area'>"
					+ "<img src='displayFile?fileName=" + data + "'/>"
                    + "<input type='button' class='btn-success' value='삭제' data-src="+data+">" 
					+ "</div>";
					if(requestName == 'project_thumbnail'){
						$("#project_thumbnail").val(data);
					}else if(requestName == 'member_profile'){
						$("#member_profile").val(data);
					}else if(requestName == 'register_profile'){
						$("#register_profile").val(data);
					}
				} else {
					str = "<div id='member_video_area' align ='center'>" 
							+ "<video width='485' heigth='480' controls>"
							+'<source src="resources'+data+'" type="video/ogg">'
							+ "</video><br>"
                            + "<input type='button' class='btn-success' value='삭제' data-src="+data+">"
							+ "</div>";
						$("#project_video").val(data);
				}
				$("#uploaded_file").append(str);
				$("#imageZone").hide();
			}
		});
	});
	
//	$("#imageZone").on("drop",function(event) {
//		//imageZone 영역에 drop 이벤트 발생시
//		
//		var requestName = event.target.title;
////				alert(requestName)
//		event.preventDefault();
//		//event.preventDefault(); = 브라우저의 동작 방지
//		
//		var files = event.originalEvent.dataTransfer.files;
//		// 해당 영역에 전달된 파일 데이터를 수신
//		// jquery를 이용한 이벤트 처리의 경우
//		// DOM객체에 대한 처리를 동반하기 위해 event.originalEvent객체를 이용
//		
//		var file = files[0];
//		//다중 파일의 drop 이벤트 발생의 경우 첫번째 drop된 파일만 저장
//		//첫번째 파일만 변수화 하는 이유는
//		//여러개의 동시 파일을 drop할때 한가지 파일만 수신하기 위해서
//		//2개 이상의 파일을 drop할때 첫번째 데이터만 수신가능함
//		//결론 : 다중 drop이벤트적용이 불가
//		
//		var formData = new FormData();
//		//FormData 는 HTML5 에서 제공되는 객체이다.
//		//기존 <Form> 엘리먼트같은 역활로서 사용할 수 있다.
//		//ex)var formData = new FormData();
//		
//		formData.append("file", file);
//		//formData.append('file',file); : key='file', value=업로드 파일객체
//		//컨트롤러에 formData(file객체)전달
//		$.ajax({
//			url : '/dream/uploadAjax/'+requestName, 
//			data : formData,
//			dataType : 'text',
//			processData : false,
//			contentType : false,
//			type : 'POST',
//			success : function(data) {
////						alert("upload 파일"+data)
//				var str = "";
//				
//				if (checkImageType(data)) {
//					str = "<div id='file_area'>"
//						// +"<a
//						// href=displayFile?fileName="+getImageLink(data)+">"
//						// displayFile()요청부
//						+ "<img src='displayFile?fileName=" + data + "'/>"
//						// +"</a>"
//						+ "<input type='button' class='btn-success' value='삭제' data-src="+data+">" 
//						+ "</div>";
//					if(requestName == 'project_thumbnail'){
////								str += "<input id='project_thumbnail' type='hidden' value="+data+">";
//						$("#project_thumbnail").val(data);
//					}else if(requestName == 'member_profile'){
//						$("#member_profile").val(data);
////								str += "<input id='member_profile' type='hidden' value="+data+">";								
//					}else if(requestName == 'register_profile'){
//						$("#register_profile").val(data);
////								str += "<input id='register_profile' type='hidden' name='project_video' value="+data+">";								
//					}else{
//						alert("div태그 title 정보 없음 : "+requestName)
//					}
//				} else {
//					str = "<div id='member_video_area' align ='center'>" 
//						+ "<video width='485' heigth='480' controls>"
//						+'<source src="resources'+data+'" type="video/ogg">'
//						+ "</video><br>"
////									+ "<a href='displayFile?fileName=" + data +"'>" + getOriginalName(data) + "</a>"
//						+ "<input type='button' class='btn-success' value='삭제' data-src="+data+">"
//						+ "</div>";
//					$("#project_video").val(data);
//				}
//				$("#uploaded_file").append(str);
//				$("#imageZone").hide();
////						("class","thumbnailImage");
////						$("#imageZone").attr("class","boxSpace");
//				
//			}
//		});
//	});
	
	 $("#uploaded_file").on("click", "input", function(event) {
         //뿌려진 이미지 데이터에 대한 click이벤트
         if(confirm("삭제하시겠습니까?")){
            var that = $(this);
            var requestName = event.target.title;
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
//                            $("#project_thumbnail").remove();
                            $("#project_thumbnail").val("");
                            $("#project_video").remove();
                            $("#imageZone").show();
//                            $("#imageZone").attr("class","thumbnailImage dragSpace");
                     }
                  }
            });
         }
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