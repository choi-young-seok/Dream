package kr.co.dream.common.encryption;

public class EncryptionPwd {

	public String shaPwd(String member_pass) {
		if(member_pass.equals("")){
			System.out.println("EncryptionPwd \t\tshaPwd() \t\t[비밀번호 null 유효성 검사 마친후 해당 로직은 삭제할것]");
			return null;
		}
		SHA256 sha = SHA256.getInsatnce();
		String orgPwd = member_pass;
		System.out.println("EncryptionPwd \t\tshaPwd() \t\t[orgPw 암호화전] : " + orgPwd);

		String shaPwd;
		try {
			shaPwd = sha.getSha256(orgPwd.getBytes());
			System.out.println("EncryptionPwd \t\tshaPwd() \t\t[1차 암호화] : " + shaPwd);
			return shaPwd;
			// String encryptionPwd = bCryptPwd(shaPwd);
			// return encryptionPwd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public String bCryptPwd(String shaPwd) {

		String bcryptPwd = BCrypt.hashpw(shaPwd, BCrypt.gensalt());
		System.out.println("EncryptionPwd \t\tshaPwd() \t\t[2차 암호화] : " + bcryptPwd);

		return bcryptPwd;
	}

	public boolean checkPwd(String inputPwd, String dbPwd) {
		System.out.println("EncryptionPwd \t\tcheckPwd()  \t\t[사용자 입력 비밀번호] : " + inputPwd);
		System.out.println("EncryptionPwd \t\tcheckPwd()  \t\t[DB 비밀번호] : " + dbPwd);
		if(dbPwd == null || dbPwd.equals("")){
			System.out.println("EncryptionPwd \t\tcheckPwd()  \t\t[일치하는 비밀번호 정보 없음] : 아이디 없음");
		 return false;
		}
		else{
			if (BCrypt.checkpw(shaPwd(inputPwd), dbPwd)) {
				System.out.println("EncryptionPwd \t\tcheckPwd()  \t\t[비밀번호 일치]");
				return true;
			} else {
				System.out.println("EncryptionPwd \t\tcheckPwd()  \t\t[비밀번호 불일치]");
				return false;
			}
		}
		
	}
}
