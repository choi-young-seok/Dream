package kr.co.dream.common.encryption;

public class EncryptionPwd {

	public String shaPwd(String member_pass) {
		if(member_pass.equals("")){
			System.out.println("EncryptionPwd [shaPwd()] : ��й�ȣ null ��ȿ�� �˻� ��ģ�� �ش� ������ �����Ұ�?");
			return null;
		}
		SHA256 sha = SHA256.getInsatnce();
		String orgPwd = member_pass;
		System.out.println("EncryptionPwd [shaPwd() orgPw ��ȣȭ��] : " + orgPwd);

		String shaPwd;
		try {
			shaPwd = sha.getSha256(orgPwd.getBytes());
			System.out.println("EncryptionPwd [shaPwd() 1�� ��ȣȭ] : " + shaPwd);
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
		System.out.println("EncryptionPwd [shaPwd() 2�� ��ȣȭ] : " + bcryptPwd);

		return bcryptPwd;
	}

	public boolean checkPwd(String inputPwd, String dbPwd) {
		System.out.println("EncryptionPwd [checkPwd()  �Է� ��й�ȣ] : " + inputPwd);
		System.out.println("EncryptionPwd [checkPwd()  DB  ��й�ȣ] : " + dbPwd);
		if(dbPwd == null || dbPwd.equals("")){
			System.out.println("EncryptionPwd [checkPwd()  ��ġ�ϴ� ��й�ȣ ���� ���� : ���̵� ����]");
		 return false;
		}
		else{
			if (BCrypt.checkpw(shaPwd(inputPwd), dbPwd)) {
				System.out.println("EncryptionPwd [checkPwd()  ��й�ȣ ��ġ]");
				return true;
			} else {
				System.out.println("EncryptionPwd [checkPwd()  ��й�ȣ ����ġ]");
				return false;
			}
		}
		
	}
}
