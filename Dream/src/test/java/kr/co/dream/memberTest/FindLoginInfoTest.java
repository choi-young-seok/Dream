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
		member.setMember_name("최용석");
		member.setMember_birth("910602");
		List<MemberVO> memberList = dao.findMail(member);
		for(int i =0 ; i<memberList.size() ; i++){
			member = memberList.get(i);
			//전체 아이디
			String memberMail = member.getMember_mail();
			System.out.println("전체 아이디 : "+memberMail);
			
			//보여줄 3자리
			String memberMail1 = memberMail.substring(0,3);
			System.out.println("보여줄 3자리 : "+memberMail1);
			
			//안보여줄 나머지자리
			String memberMail2 = memberMail.substring(3,memberMail.indexOf("@"));
			System.out.println("안보여줄 나머지자리 : "+memberMail2);
			System.out.println("자리수:" + memberMail2.length());
			System.out.println("왜안바뀌냐1 : "+memberMail2.valueOf(1));
			memberMail2.charAt(1);
//			System.out.println("왜안바뀌냐고1 : "+memberMail2.replace((String)memberMail2.charAt(1), "*"));
			System.out.println("왜안바뀌냐2 : "+memberMail2.valueOf(2));
//			System.out.println("왜안바뀌냐고2 : "+memberMail2.replace(memberMail2.charAt(2), "*"));
		
			//해결책 바꿀부분의 값을 가진 String 변수를 char형으로 변환
			//String변수의 lenght만큼 char를 돌리면서 replace할것;;
			//시봥존나귀찮당
			
			//안보여줄 나머지자리 "*"로 대체
			for (int j = 0; j <= memberMail2.length(); j++){ 
				memberMail2 = memberMail2.replace(memberMail2.valueOf(j), "*");
			}
			System.out.println("대체된 나머지자리 : " +memberMail2);
//			System.out.println(memberMail2.replaceAll(memberMail2, "*"));
			
			
			//@이하 메일주소
			String mailaddress[] = memberMail.split("@");
			System.out.println("@이하 메일주소"+mailaddress[1]);
			
			//처리완료된 아이디
			String memberMailFinal = memberMail1+memberMail2+"@"+mailaddress[1];
			System.out.println("처리 완료된 아이디"+memberMailFinal);
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
