<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquey -->
<script type="text/javascript" src="resources/js/common/jquery.js"></script>



<title>프로젝트 계좌 정보 등록</title>
<link rel="icon" href="resources/img/title.png" type="image/x-icon">

<article> <%@include file="projectTabList.jsp"%>
</article>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="col col-md-12">
				<div class="col col-md-2"></div>
				<div class="col col-md-8">
					<legend>
						<h2>프로젝트 계좌 정보</h2>
					</legend>

					<div class="boxSpace">
						<legend>
							<h4 align="center">이용약관 동의</h4>
						</legend>
						<div>

							<b>1. 개인정보 수집 및 이용에 대한 동의<br></b><br> 
							‘회사’의 모바일 사이트, 서비스 및 제품을
							사용하는 이용자는 ‘회사’가 아래 2번 항목에 정의한 ‘개인정보 항목’을 수집할 수 있다는 데 동의합니다. ‘회사’는
							외부 업체와 집계 정보와 개인 정보를 공유할 수 있습니다. ‘회사’는 아래의 정책에 설명된 경우를 제외하고, 외부
							업체와 개인 정보를 공유하지 않습니다. 회사는 이용자가 회사의 개인정보처리방침 또는 이용약관의 내용에 대해
							「동의한다」버튼 또는 「동의하지 않는다」버튼을 클릭할 수 있는 절차를 마련하여, 「동의한다」버튼을 클릭하면 개인정보
							수집에 대해 동의한 것으로 간주합니다. 단, 법률에서 예외로 처리하는 경우에는 별도의 동의 없이 이용자에게 알리는
							것으로 갈음할 수 있습니다. <br><br>
							
							<b>2. 개인정보 수집 항목 및 방법</b><br><br>
							 가. 회사는 이용자에게 서비스를 제공하는 데 최소한의
							개인정보를 수집, 이용하고 있습니다. 그 중 선택적 항목은 보다 나은 서비스를 제공하기 위하여 수집하고 있습니다.<br><br>

							나. 이용자가 회사의 모바일 게임을 이용하는 경우 아래와 같은 개인정보를 수집할 수 있습니다. <br>
							 - 네스트 플랫폼 게임: 휴대전화번호, 생년월일(선택적), 성별(선택적), 주소록에 저장된 제 3자의 이름 및 전화번호, 통신사
							정보, 단말기 정보, 게임이용 및 접속 기록, 인증기록, 결제 기록, 게임버전, 가입 시 부여되는 회원번호(가입한
							이메일 등), 페이스북/트위터/네스트 등의 SNS 식별정보(카카오 앱센터ID, 프로필 사진 등), 이메일 
							<br>
							<br>- 카카오
							플랫폼 게임: 휴대전화번호, 통신사 정보, 단말기 정보, 게임이용 및 접속 기록, 인증기록, 결제 기록, 게임버전,
							가입 시 부여되는 회원번호, 페이스북/트위터/네스트 등의 SNS 식별정보(카카오 앱센터ID, 친구목록, 프로필 사진
							등), 이메일 
							<br>
							<br>- 조이시티 플랫폼 연동 게임: 휴대전화번호, 생년월일(선택적), 성별(선택적), 주소록에 저장된 제
							3자의 이름 및 전화번호, 통신사 정보, 단말기 정보, 게임이용 및 접속 기록, 인증기록, 결제 기록, 게임버전,
							가입 시 부여되는 회원번호, 페이스북/트위터/네스트 등의 SNS 식별정보(카카오 앱센터ID등), 광고용 식별 정보),이메일 
							<br>
							<br>- 구글 연동 게임: 휴대전화번호, 생년월일(선택적), 성별(선택적), 주소록에 저장된 제 3자의 이름 및
							전화번호, 단말기 정보, 게임이용 및 접속 기록, 인증기록, 결제 기록, 게임버전, 가입 시 부여되는 회원번호(가입한
							이메일, 구글ID 등), 페이스북/트위터/네스트/카카오/구글 등의 SNS 식별정보), 이메일 
							<br>
							<br>- 단독 서비스 게임:
							단말기 정보, 게임이용 및 접속 기록, 인증기록, 결제 기록, 게임버전, 가입 시 부여되는 회원번호(혹은 가입한
							이메일 등), 페이스북/트위터/네스트/카카오/ 등의 SNS 식별정보), 이메일 
							<br>
							<br>다. 회사는 이용자가 이벤트에 참여하는
							경우 이벤트 진행을 위해 아래와 같은 개인정보를 수집합니다. 
							<br>- 이벤트 당첨에 따른 경품 배송을 위한 이름, 연락처,
							주소 
							<br>- 페이스북/네스트 등의 SNS 식별정보(아이디) 
							<br>- 경품 지급 시 제세공과금 납부가 필요한 경우 관련 법령에서
							정하고 있는 개인정보 (이름, 주소, 주민등록번호, 우편번호, 신분을 확인할 수 있는 증서)
							<br>
							<br>라. 서비스 이용과정이나
							사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다. 
							<br>- 서비스 이용기록, 접속로그, 쿠키,
							접속IP정보, 접속 이동전화번호, 거래기록, 이용정지 기록 
							<br>
							<br>마. 이용자가 유료서비스를 이용하는 경우 아래와 같은
							정보들이 추가적으로 수집될 수 있습니다.
							<br> - 오픈 마켓을 통한 결재 시: 오픈마켓 아이디, 오픈마켓 닉네임,결제승인번호 
							<br>- ARS를 통한 결제 시: 이동통신사, 휴대전화번호, 결제승인번호 
							<br>
							<br>바. 개인정보의 수집 방법 회사는
							다음과 같은 방법으로 개인정보를 수집합니다. <br>① 고객센터를 통한 1:1문의 상담, 경품행사 응모, 캐시 구매 <br>②
							모바일 게임 인증<br> ③ 이벤트 또는 마케팅

						</div>
						<div class="row">
							<div class="pull-right">
								<input type="checkbox" id="access_terms_agree" name="access_terms_agree" value="T">이용 약관 동의
								<!-- <input type="radio" id="access_terms_agree" name="access_terms_agree" value="F">동의 않함 -->
							</div>
						</div>
					</div>

					<div id="numSector_payback_account" class="boxSpace">
						<div class="row">
							<div class="col-md-10 col-md-offset-1">
								<form class="form-horizontal" role="form">

									<!-- Form Name -->
									<legend>계좌 정보 입력</legend>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">은행
											: </label>
										<div class="col-sm-9">
											<select id="account_bank_list">
												<option>----</option>
												<option>신한</option>
												<option>농협</option>
												<option>하나</option>
												<option>조흥</option>
												<option>국민</option>
												<option>우리</option>
												<option>신협</option>
												<option>우체국</option>
												<option>새마을</option>
											</select>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-sm-3 control-label" for="textinput">계좌번호
											:</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="project_account"
												placeholder="숫자만 입력하세요">
										</div>
									</div>
								</form>
							</div>
							<!-- /.col-lg-12 -->
						</div>
						<!-- /.row -->
					</div>

					<button type="button" id="accountInfoRegister"
						class="btn btn-primary pull-right">저장하고 다음으로</button>
				</div>

				<div class="col col-md-2"></div>
			</div>
		</div>
	</div>
</body>
<footer> <%@include file="../../mainView/footer.jsp"%>
</footer>
</html>