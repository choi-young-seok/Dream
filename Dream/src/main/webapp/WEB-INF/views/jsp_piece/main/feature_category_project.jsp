<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script id="feature_project_category" type="text/x-handlebars-template">
{{#each .}}
	<div class="row">
		<div class="col-md-10">
			<legend style="font-size: xx-large;">{{project_category}} </legend>
		</div>
		<div class="pull-right"style="font-size: xx-large;     margin-right: 19px;">더보기 >></div>
	
			<div id="category_projects{{project_category}}"></div>
	</div>
{{/each}}
</script>

<!-- style="border: solid;" -->

