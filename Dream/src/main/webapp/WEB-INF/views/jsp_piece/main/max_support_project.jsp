<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script id="max_support_project" type="text/x-handlebars-template">
{{#each .}}
	<div class='col-sm-6 col-lg-6 col-md-6'>
		<div class='thumbnail'>
			<a href='/dream/projectInfoView?project_no={{project_no}}'>
			<img src='resources{{project_thumbnail}}'></a>
			
			<div class='progress'>
				<div class='progress-bar' role='progressbar' aria-valuenow='100' 
						aria-valuemin='0' aria-valuemax='100' align='center' 
						style='width: {{projectOperDTO.project_percentage}}%'></div>
			</div>
			
			<div class='caption'>
				<h4>
					<b>{{project_title }}</b>
					<hr>
				</h4>
				<p>{{project_summary }}</p>
				<p style="color: gray;">{{project_category}}</p>
				<div class="point" style="font-size : large">
					<div class='col-md-4' align='center'>
						<b>{{projectOperDTO.project_percentage}}%</b><br/>
						<small>달성도</small>
					</div>
					<div class='col-md-4' align="center">
						<b>{{supporting_count}}명</b><br />
						<small>후원수</small>
					</div>
					<div class='col-md-4' align="center">
						<b>{{projectOperDTO.project_d_day}}일</b><br />
						<small>잔여기간</small>
					</div>
				</div>
			</div>
		</div>
	</div>
{{/each}}
</script>



