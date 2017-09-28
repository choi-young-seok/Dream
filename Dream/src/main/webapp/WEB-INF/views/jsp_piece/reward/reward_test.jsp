<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="reward_select" type="text/x-handlebars-template">
{{#each .}}
<div class="col-md-2 col-md-offset-0">
<div>
전체 리워드 번호 : {{total_reward_no}}<br>
리워드 제목 : {{reward_title}}<br>
리워드 품목 : {{reward_items}}<br>
배송 예정일 : {{reward_delivery_date}}<br>
한정 수량 : {{reward_limited_count}}<br>
리워드 가격 : {{reward_amount}}<br>
</div>
</div>
{{/each}}
</script>