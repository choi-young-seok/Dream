<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="reward_select" type="text/x-handlebars-template">
						{{#each .}}
								<div class="row" id="select_reward">
                                    <form class="form-horizontal boxSpace" role="form">
                                          <!-- Form Name -->
                                          <%-- <legend align="center">리워드 ${rewards.reward_no }</legend> --%>
                                          <legend align="center">{{reward_no }}번 리워드</legend>
                                          <!-- Text input-->
                                          <div class="form-group">
                                                <label class="col-sm-4 control-label" for="textinput">리워드
                                                      제목 : </label> <label class="col-sm-5 control-label" for="textinput">{{reward_title}}</label>
                                          </div>
                                          <div class="form-group">
                                                <label class="col-sm-4 control-label" for="textinput">리워드
                                                      품목 : </label> <label class="col-sm-5 control-label" for="textinput">{{reward_items}}</label>
                                          </div>
                                          <div class="form-group">
                                                <label class="col-sm-4 control-label" for="textinput">배송 예정일 : </label>
                                                <label class="col-sm-5 control-label" for="textinput">{{reward_delivery_date}} </label>
                                                      <%-- <fmt:formatDate pattern="yy-MM-dd" value="{{reward_delivery_date}}" /> --%>
                                          </div>
                                          <div class="form-group">
                                                <label class="col-sm-4 control-label" for="textinput">한정
                                                      수량 : </label> <label class="col-sm-5 control-label" for="textinput">{{reward_limited_count}}</label>
                                          </div>
                                          <div class="form-group">
                                                <label class="col-sm-4 control-label" for="textinput">가격
                                                      : </label> <label class="col-sm-5 control-label" for="textinput">{{reward_amount}}</label>
                                                <input type="hidden" id="support_amount"
                                                      value="{{reward_amount }}">
                                          </div>
                                    </form>
                                    <%-- <input type="hidden" id="support_amount" value="${rewards.reward_amount }"> --%>
                                    <div class="col-sm-offset-2 col-sm-8" title="supportBtn">
                                          <div class="pull-right">
                                                <button id="payBtn" title="{{total_reward_no}}"
                                                      class="btn btn-warning" param="{{total_reward_no}}">후원하기</button>
                                          </div>
                                    </div>
                                    <!-- /.row -->
                             	</div>
						{{/each}}
</script>

    						<!-- <div class="col-md-2 col-md-offset-0">
                        	</div> -->