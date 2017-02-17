<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- projcetTabList style -->
<link href="resources/css/project/projectTabList.css" rel="stylesheet">
<link href="resources/css/project/projectRegister.css" rel="stylesheet">

<!-- jQuery -->
<script src="resources/js/common/jquery.js"></script>

<!-- projcetTabList event -->
<!-- <script type="text/javascript" src="resources/js/project/projectTabList.js"></script> -->
<!-- projcetRegister event -->
<script type="text/javascript" src="resources/js/project/projectRegister.js"></script>

</head>
<header><%@include file="../../mainView/header.jsp"%>
<body>
<div class="container">
	<div class="row">
		<section>
        <div class="wizard">
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">

					<input type="text" value="${project.project_no }" id="project_no" name="project_no">
                    <li role="presentation" class="active">
                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="기본정보">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-picture iconLocations"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" id="rewardView" class="disabled">
                        <a href="#step2" data-toggle="tab"  aria-controls="step2" role="tab" title="리워즈">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-gift iconLocations"></i>
                            </span>
                        </a>
                    </li>
                    
                    <li role="presentation" class="disabled">
                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="스토리">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-pencil iconLocations"></i>
                            </span>
                        </a>
                    </li>
                    
                    <li role="presentation" class="disabled">
                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="프로필">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-user iconLocations"></i>
                            </span>
                        </a>
                    </li>
                    
                    <li role="presentation" class="disabled">
                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="계좌">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon glyphicon-usd iconLocations"></i>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

                <!-- <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="step1">
                        <ul class="list-inline pull-right">
                            <li><button type="button" id="basicInfoRegister" class="btn btn-primary next-step">저장하고 다음으로</button></li>
                            <div id="projectBasicInfoView"></div>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step2">
                        <ul class="list-inline pull-right">
                            <li><button type="button" id="projectRegiterView" class="btn btn-default prev-step">이전으로</button></li>
                            <li><button type="button" id="rewardInfoRegister" class="btn btn-primary next-step">저장하고 다음으로</button></li>
                            <div id="projectRewardView"></div>
                           
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step3">

                        <ul class="list-inline pull-right">
                            <li><button type="button" id="projectRegiterView" class="btn btn-default prev-step">이전으로</button></li>
                            <li><button type="button" id="storyInfoRegister" class="btn btn-primary btn-info-full next-step">저장하고 다음으로</button></li>
							<div id="projectStoryView"></div>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step4">

                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-primary btn-info-full next-step">Save and continue</button></li>
                            <div id="projectProfileView"></div>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="complete">
                        <h3>Complete</h3>
                    </div>
                    <div class="clearfix"></div>
                </div> -->
        </div>
    </section>
   </div>
</div>
</body>
</html>