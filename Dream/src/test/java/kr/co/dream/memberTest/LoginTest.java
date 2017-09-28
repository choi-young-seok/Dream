package kr.co.dream.memberTest;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.common.encryption.EncryptionPwd;
import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class LoginTest {

	@Inject
	private MemberDAO dao;
	
	@Inject
	private EncryptionPwd encryptionPwd;
	
	//@Test
	public void selectPwd(){
		LoginDTO dto = new LoginDTO();
		dto.setLogin_mail("rcn115@naver.com");
		dto.setLogin_pass("0000");
		System.out.println(dao.selectPwd(dto));
	}
	
	//@Test
	public void loginTest(){
		LoginDTO dto = new LoginDTO();
		dto.setLogin_mail("rcn115@naver.com");
		dto.setLogin_pass("0000");
		
		if(encryptionPwd.checkPwd(dto.getLogin_pass(), dao.selectPwd(dto))){
			System.out.println("로그인 테스트 완료 : " +dao.login(dto).toStringLogin());			
		}
	}
}
