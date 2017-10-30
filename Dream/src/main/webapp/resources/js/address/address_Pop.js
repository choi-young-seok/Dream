$(function(){
	$("#findAddress").click(function(){
		$("#addressModal").modal();
		$("#search_address").val(""); 
		$("#search_address").focus();
	});//findAddress click event
	
	$("#address_search_btn").click(function(){
		aa();
	});//address_search_btn click event
	
	$("#search_address").keydown(function(event){
		if(event.keyCode == 13){
			aa();
			event.preventDefault();
			return;
		}
	})
	
	function aa(page){
		var search_address = $("#search_address").val()
		if(search_address == ""){
			alert("거주지의 동 또는 건물명을 입력하세요")
			return;
		}
		$.ajax({
			url : '/dream/serachAddressList',
			type : 'POST',
			data : {
				keyword : search_address,
				page : page
			},
			success : function(result){
				$.each(result, function(key, value){
					if(key == "noData"){
						alert("결과없음")
						return;
					}else if(key == "success"){
						var addressList = '<div class="dataSpace"><ul>';
						var idx=0;
						$(value).each(function(){
							idx++;
//							var dataList = "";
							addressList +='<a id="addressData'+idx+'" onclick="getAddressData(\''+this.zip_code+'\',\''+this.address+'\')">'
										+ this.zip_code+"&nbsp;&nbsp;&nbsp;&nbsp;" + this.address
										+ '</a><br>';
						});//inner each end
						addressList += '</ul></div>';
						$("#search_result").html(addressList)
						
					}//else if
						if(key == "pageMaker"){
							var pageMaker ='';
							
							// print to '<<' when prev is true
							if(this.prev){
								pageMaker +='<li><a id="prev">&laquo;</a></li>';
							}

							//print each page Number to startPage until endPage 
							for(var i = this.startPage; i <= this.endPage; i++){
								if(this.cri.page == i){
									pageMaker += '<li class="active"><a>'+i+'</a></li>';								
								}else{
									pageMaker += '<li param='+i+'><a param='+i+'>'+i+'</a></li>';																	
								}
							}
							
							// print to '>>' when next is true
							if(this.next && this.endPage >0){
								pageMaker += '<li><a id="next">&raquo;</a></li>';
							}
							
							pageMaker += '<input type="hidden" value="'+(i-10)+'" id="first-page">'
							pageMaker += '<input type="hidden" value="'+i+'" id="last-page">'
							
							$("#data_count").html("<b>검색된 데이터 총 "+this.totalCount+"건")
							$("#paginationReuslt").html(pageMaker);
						}//page Maker parsing
				});//outer each end		
				
			}//success end
		});//ajax
	}
	

	$("#paginationReuslt").on("click", "li a", function(event){
		var page = $(this).attr("param")
		aa(page);
	})
	$("#paginationReuslt").on("click", "#prev", function(event){
		var page = $("#first-page").val();
		aa(page-1)
	})
	
	$("#paginationReuslt").on("click", "#next", function(event){
		var page = $("#last-page").val();
		aa(page)
	})
});//ready