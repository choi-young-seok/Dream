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
	
	function aa(){
		var search_address = $("#search_address").val()
		if(search_address == ""){
			alert("거주지의 동 또는 건물명을 입력하세요")
			return;
		}
		$.ajax({
			url : '/dream/serachAddressList',
			type : 'GET',
			data : {
				keyword : search_address
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
								pageMaker +='<li><a>&laquo;</a></li>';
							}

							//print each page Number to startPage until endPage 
							for(var i = this.startPage; i <= this.endPage; i++){
								if(this.cri.page == i){
									pageMaker += '<li class="active"><a>'+i+'</a></li>';								
								}else{
									pageMaker += '<li><a>'+i+'</a></li>';																	
								}
							}
							
							// print to '>>' when next is true
							if(this.next && this.endPage >0){
								pageMaker += '<li><a>&raquo;</a></li>';
							}
							
							$("#data_count").html("<b>검색된 데이터 총 "+this.totalCount+"건")
							$("#paginationReuslt").html(pageMaker);
						}//page Maker parsing
				});//outer each end			
			}//success end
		});//ajax
	}
	

});//ready