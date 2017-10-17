$(function(){
	$("#youtube_url_area").hide();
	$("#project_video_type").val("member_video")
	
	$("#video_tabs > li").click(function(){
		var select_btn = $(this).attr("id")
		if(select_btn =="member_video_tab"){
			alert("점선 영역에 업로드할 영상을 드래그 하세요")
			$("#youtube_url").val("");
			$("#youtube_url_area").hide();	
			$("#youtube_video").remove();	
			$("#project_video_type").val("member_video")
			$("#project_video").val('');
//			$("#imageZone").attr("class","thumbnailImage dragSpace");
			$("#imageZone").show();
		}else if(select_btn == "youtube_vedio_tab"){
			$("#project_video_type").val("youtube_video")
			$("#youtube_url_area").show();
			$("#member_video_area").remove();
//			$("#imageZone").attr("class","thumbnailImage dragSpace");
			$("#youtubeVideo_manualModal").modal();
		}
		$("#video_tabs > li").removeAttr("class")
		$(this).attr("class","active")
	})
	
	
	$("#youtube_url").keyup(function(){
		var youtube_url = $(this).val();
		youtube_url = youtube_url.substr(youtube_url.lastIndexOf("/")+1)
		var youtube_video = '<div id="youtube_video" align="center"><embed width="640" height="360" src="http://www.youtube.com/v/'+youtube_url+'" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed></div>'
		$("#project_video").val(youtube_url)
		$("#uploaded_file").html(youtube_video);
		$("#imageZone").hide();
//		$("#imageZone").removeAttr("class","thumbnailImage");
//		$("#imageZone").attr("class","boxSpace");
		
	})
	
	
//	alert("점선 영역에 업로드할 영상을 드래그하세요")
});//