<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="col-md-8 col-sm-6 col-xs-12 personal-info">

<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="text-center">
							<div id="profileArea">
								<div id="imageZone" class="member_profile" style="height: 240px;"
									title="member_profile">
								<h6>점선영역에 프로필 사진을 드래그하세요</h6>									
									</div>
								<input type="hidden" id="member_profile">
							</div>
							<input id="member_profile_value" type="hidden"
								value="${member.member_profile }">

							<c:if test="${member.member_profile != 'NO PROFILE'}">
								<div id="proFileZone">
									<div>
										<img src="displayFile?fileName=${member.member_profile}"
											class="avatar img-circle img-thumbnail"
											alt="drag your profile Image"> <input
											id="member_profile_value" type="hidden"
											value="${member.member_profile }">
									</div>
									<a id="profileEdit" class="btn btn-success">수정</a>
								</div>
							</c:if>
						</div>
					</div>
					
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-lg-3 control-label">이름 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${session.member_name }"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">생년월일 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${member.member_birth }"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">이메일 :</label>
								<div class="col-lg-8">
									<input class="form-control" value="${session.member_mail}"
										type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">가입일 :</label>
								<div class="col-lg-8">
									<input class="form-control"
										value="<fmt:formatDate pattern='yyyy-MM-dd' value='${member.member_regdate }'/>"
										type="text" readonly="readonly">
									<%-- ${member.member_regdate } --%>
								</div>
							</div>