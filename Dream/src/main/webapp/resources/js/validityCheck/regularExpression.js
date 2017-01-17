function Account(email_confirm) {
	var email_1 = $("#id_box_1").val();
	var email_2 = $("#id_box_2").val();
	//이메일
	
	var email = email_1 + "@" + email_2;	
	//비밀번호
	var password = $("#pw_box1").val();
	//이름
	var name = $("#name_box").val();
	//별명
	var nickName = $("#nickName_box").val();
	//핸드폰
	var phone_1 = $("#hp_box_1").val();
	var phone_2 = $("#hp_box_2").val();
	var phone_3 = $("#hp_box_3").val();
	var reg_phone = /^[0-9]*$/;
	if(!reg_phone.test(phone_2)){
		alert('올바르지 않은 핸드폰 번호입니다.')
		return;
	}else if(!reg_phone.test(phone_3)){
		alert('올바르지 않은 핸드폰 번호입니다.')
		return;
	}
	var phone = phone_1 + "-" + phone_2 + "-" + phone_3;
	//생년 월 일
	var year = $(".year").val();
	var month = $(".month").val();
	var day = $(".day").val();
	
	var birthday = year + "-" + month + "-" + day;
	
	//이용약관 동의
	var emailCheck = $("#email_search").is(":checked");
	var smsCheck = $("#sms_search").is(":checked");	
	var check1 = $("#aa2").is(":checked"); //이용약관 동의
	var check2 = $("#bb2").is(":checked"); //전자금융거래 동의
	var check3 = $("#cc2").is(":checked"); //개인정보 수집 이용 동의
	
	if (!email_1 || email_2 === "선택하세요") {
		alert("이메일을 입력해주세요.");
		return;
	} else if (!email_confirm){
		alert('이메일 중복확인을 해주세요.')
		return;
	} else if (!password) {
		alert("비밀번호를 입력해주세요.");
		return;
	} else if (!name) {
		alert("이름을 입력해주세요.");
		return;
	} else if (!nickName) {
		alert("닉네임을 입력해주세요.");
		return;
	} else if (!phone_1 || !phone_2 || !phone_3) {
		alert("핸드폰을 입력해주세요.");
		return;
	} else if (year ==="년도" || month==="월" || day==="일" ) {
		alert("생년월일을 입력해주세요.");
		return;
	} else if (!pwd_check_vl) {
		alert("비밀번호 일치 여부를 해주세요.");
		return;
	} else if (check1 == false || check2 == false || check3 == false) {
		alert("약관동의를 해주세요.");

		return;
	}
	allCheck = true;

	Account_AX(email, password, name, nickName, phone, birthday, allCheck, emailCheck, smsCheck);

}

function Account_AX(email, password, name, nickName, phone, birthday, allCheck, emailCheck, smsCheck) {
	$.ajax({
		url : '/show/sign/sign_AX', //주소
		type : 'POST',
		data : {
			"member_email" : email,
			"member_pass" : password,
			"member_name" : name,
			"member_nickName" : nickName,
			"member_phone" : phone,
			"member_birth" : birthday,
			"allCheck" : allCheck,
			"emailCheck" : emailCheck,
			"smsCheck" : smsCheck
		},
		success : function(result) {
			if (result == "OK") {
				alert('가입되었습니다.');
				location.href='/show';
			} else if (result != "OK") {
				alert(result);		
				return;
			}
		}
	});
}
function sell_Account_AX(email, password, name, nickName, phone, birthday, allCheck) {
	
	$.ajax({
		url : '/show/sign/sell_sign_AX', //주소
		type : 'POST',
		data : {
			"email" : email,
			"password" : password,
			"name" : name,
			"nickName" : nickName,
			"phone" : phone,
			"birthday" : birthday,
			"allCheck" : allCheck,
			"emailCheck" : false,
			"smsCheck" : false
		},
		success : function(result) {
			if (result == "OK") {
				alert('가입되었습니다.');
				location.href('/show');
			} else if (result != "OK") {
				alert(result);
				
				return;
			}
			
		}
	});
}

// 패스워드 일치 확인용
var pwd_check_vl = false;
// 패스워드 일치함수
function pwd_check() {

	var password1 = $("#pw_box1").val();
	var password2 = $("#pw_box2").val();

	var password = new Array();
	var reg_pwd = /^.*(?=.{4,8})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

	for (i = 0; i < password1.length; i++) {
		tmp = password1.charCodeAt(i);
		// document.write(tmp);
		password[i] = tmp;
	}

	if (!reg_pwd.test(password1)) {
		var print = document.getElementById("print");
		print.innerHTML = "영문,숫자 조합으로 4~8자리로 입력해 주십시오.";
		$("#pw_box1").val("");
		$("#pw_box2").val("");
		$("#pw_box1").focus();
		return;
	} else if (reg_pwd.test(password1)) {

		if (password1.length > 3 && password1.length < 9) {
			if (password1 == password2) {
				var print = document.getElementById("print");
				print.innerHTML = "비밀번호가 일치합니다.";
				pwd_check_vl = true;
				return;
			} else if (!(password1 == password2)) {
				var print = document.getElementById("print");
				print.innerHTML = "비밀번호가 일치하지않습니다.";
				$("#pw_box1").val("");
				$("#pw_box2").val("");
				$("#pw_box1").focus();
				pwd_check_vl = false;
				return;
			}// 비밀번호 일치 확인
			return;
		} else if (!(password1.length > 3 && password1.length < 9)) {
			var print = document.getElementById("print");
			print.innerHTML = "비밀번호를 4~8자 사이로 입력해주십시오.";
			return;
		}
	}
}


