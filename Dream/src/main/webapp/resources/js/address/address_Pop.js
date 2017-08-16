$(function(){
	$("#findAddress").click(function(){
		$("#addressModal").modal();
		$("#search_address").val(""); 
		$("#search_address").focus();
	});//findAddress click event
	
	$("#address_search_btn").click(function(){
		$.ajax({
			url : '/dream/serachAddressList',
			type : 'GET',
			data : {
				keyword : $("#search_address").val()
			},
			success : function(result){
				$.each(result, function(key, value){
					if(key == "noData"){
						$("#search_result2").text("결과없음")
						alert("결과없음")
						return;
					}else if(key == "success"){
						alert("success key : " + key)
						var addressList = '<div class="dataSpace"><ul>';

						
						var idx=0;
						$(value).each(function(){
							idx++;
							var dataList = "6t6";
//							addressList += '<label for="authNum"><span class="glyphicon glyphicon-eye-open"></span>검색 결과</label>'
							
//							addressList +='<a id="addressData'+idx+'" onclick="getAddressData('+idx+')">'
							addressList +='<a id="addressData'+idx+'" onclick="getAddressData(\''+this.zip_code+'\',\''+this.address+'\')">'
//							addressList +='<a id="addressData'+idx+'" onclick="getAddressData2('+this.address+')">'
//										+ '<span id="zip_code" style="padding-right : 20px;">'+this.zip_code+'</span>'
//										+ '<span id="address">'+this.address+'</span>'
										+ this.zip_code + this.address
										+ '</a><br>';
						});//inner each end
						addressList += '</ul></div>';
						$("#search_result").html(addressList)
						
					}//else if
						if(key == "pageMaker"){
							alert("success key : " + key)
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
	});//address_search_btn click event
	

});//ready

//function popupOpen(){
//    var popUrl = ""; //팝업 URL
//    var popOption = "width=370, height=360," +
//          "resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
//        window.open(popUrl,"",popOption);
//    }
//

