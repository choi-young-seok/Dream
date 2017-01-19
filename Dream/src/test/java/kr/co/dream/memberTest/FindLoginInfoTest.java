package kr.co.dream.memberTest;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class FindLoginInfoTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void findMail(){
		MemberVO member = new MemberVO();
		member.setMember_name("�ֿ뼮");
		member.setMember_birth("910602");
		List<MemberVO> memberList = dao.findMail(member);
		for(int i =0 ; i<memberList.size() ; i++){
			member = memberList.get(i);
			//��ü ���̵�
			String memberMail = member.getMember_mail();
			System.out.println("��ü ���̵� : "+memberMail);
			
			//������ 3�ڸ�
			String memberMail1 = memberMail.substring(0,3);
			System.out.println("������ 3�ڸ� : "+memberMail1);
			
			//�Ⱥ����� �������ڸ�
			String memberMail2 = memberMail.substring(3,memberMail.indexOf("@"));
			System.out.println("�Ⱥ����� �������ڸ� : "+memberMail2);
			System.out.println("�ڸ���:" + memberMail2.length());
			System.out.println("�־ȹٲ��1 : "+memberMail2.valueOf(1));
			memberMail2.charAt(1);
//			System.out.println("�־ȹٲ�İ�1 : "+memberMail2.replace((String)memberMail2.charAt(1), "*"));
			System.out.println("�־ȹٲ��2 : "+memberMail2.valueOf(2));
//			System.out.println("�־ȹٲ�İ�2 : "+memberMail2.replace(memberMail2.charAt(2), "*"));
		
			//�ذ�å �ٲܺκ��� ���� ���� String ������ char������ ��ȯ
			//String������ lenght��ŭ char�� �����鼭 replace�Ұ�;;
			//�Ôg����������
			
			//�Ⱥ����� �������ڸ� "*"�� ��ü
			for (int j = 0; j <= memberMail2.length(); j++){ 
				memberMail2 = memberMail2.replace(memberMail2.valueOf(j), "*");
			}
			System.out.println("��ü�� �������ڸ� : " +memberMail2);
//			System.out.println(memberMail2.replaceAll(memberMail2, "*"));
			
			
			//@���� �����ּ�
			String mailaddress[] = memberMail.split("@");
			System.out.println("@���� �����ּ�"+mailaddress[1]);
			
			//ó���Ϸ�� ���̵�
			String memberMailFinal = memberMail1+memberMail2+"@"+mailaddress[1];
			System.out.println("ó�� �Ϸ�� ���̵�"+memberMailFinal);
			System.out.println("----------------");
			
			
			
			
			
			
			
			
			
//			String[] memberMail2 =memberMail.split("@");
////			System.out.println(member.getMember_mail());
//			System.out.println(memberMail2[0]);
//			String memberMailFinal1 = memberMail2[0].substring(0, 2);
//			String memberMailFinal2 = memberMail2[0].substring(2, memberMail2[0].indexOf("@"));
//			
////			String memberMailFinal =memberMail2[0].replaceAll(mem, "*");
//			System.out.println(memberMailFinal1);
//			System.out.println(memberMailFinal2);
////			String memberMailFinal3 = memberMailFinal
		}
	}
	
}
