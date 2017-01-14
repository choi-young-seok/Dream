package kr.co.dream.common.encryption;

public class EncryptionPwd {

	public String shaPwd(String member_pass) {
		SHA256 sha = SHA256.getInsatnce();
		String orgPwd = member_pass;
		System.out.println("EncryptionPwd [shaPwd() orgPw 암호화전] : " + orgPwd);

		String shaPwd;
		try {
			shaPwd = sha.getSha256(orgPwd.getBytes());
			System.out.println("EncryptionPwd [shaPwd() 1차 암호화] : " + shaPwd);
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
		System.out.println("EncryptionPwd [shaPwd() 2차 암호화] : " + bcryptPwd);

		return bcryptPwd;
	}

	public boolean checkPwd(String inputPwd, String dbPwd) {
		System.out.println("EncryptionPwd [checkPwd()  입력 비밀번호] : " + inputPwd);
		System.out.println("EncryptionPwd [checkPwd()  DB  비밀번호] : " + dbPwd);
		if (BCrypt.checkpw(shaPwd(inputPwd), dbPwd)) {
			System.out.println("EncryptionPwd [checkPwd()  비밀번호 일치]");
			return true;
		} else {
			System.out.println("EncryptionPwd [checkPwd()  비밀번호 불일치]");
			return false;
		}
	}
}
